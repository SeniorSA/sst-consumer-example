package br.com.senior.employee.consumer.rest.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DtoJsonConverter {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static DateTimeFormatter DATE_TIME_FORMAT; //NOSONAR
    private static DateTimeFormatter DATE_FORMAT; //NOSONAR
    private static DateTimeFormatter TIME_FORMAT; //NOSONAR
    public static final String DISCRIMINATOR = "_discriminator";
    private static Gson objectGson;
    private static Gson primitiveGson;

    public DtoJsonConverter() { //NOSONAR
    }

    private static boolean isSerializable(Field toCheck) { //NOSONAR
        return !toCheck.getType().isArray() || toCheck.getType().getComponentType() == Byte.TYPE;
    }

    public static <T> T toDTO(byte[] json, Class<T> targetType) {
        return getGson().fromJson(new String(json, UTF_8), targetType);
    }

    public static <T> byte[] toJSON(T source) {
        return getGson().toJson(source).getBytes(UTF_8);
    }

    private static Gson getGson() {
        return objectGson;
    }

    private static Gson buildGson(boolean supportObjects) {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new DtoJsonConverter.DateTimeAdapter());
        builder.registerTypeAdapter(LocalDate.class, new DtoJsonConverter.DateAdapter());
        builder.registerTypeAdapter(LocalTime.class, new DtoJsonConverter.TimeAdapter());
        builder.registerTypeAdapter(byte[].class, new DtoJsonConverter.BlobAdapter());
        builder.registerTypeAdapter(Instant.class, new DtoJsonConverter.InstantAdapter());
        if (supportObjects) {
            builder.registerTypeHierarchyAdapter(Object.class, new DtoJsonConverter.ObjectAdapter());
        }

        return builder.create();
    }

    private static boolean isPrimitive(Type valueType) { //NOSONAR
        if (!(valueType instanceof Class)) {
            return false;
        } else {
            Class<?> clazz = (Class) valueType;
            List<Class<?>> basicTypes = Arrays.asList(String.class, Date.class, LocalDate.class, LocalTime.class, Double.class, Long.class, Boolean.class, BigDecimal.class);
            return clazz.isPrimitive() || clazz.isEnum() || basicTypes.contains(valueType);
        }
    }

    private static boolean isCollection(Type valueType) { //NOSONAR
        if (!(valueType instanceof Class)) {
            return false;
        } else {
            Class<?> clazz = (Class) valueType;
            return Collection.class.isAssignableFrom(clazz);
        }
    }

    private static boolean isMap(Type valueType) { //NOSONAR
        Type rawType = getRawTypeOf(valueType);
        return !(rawType instanceof Class) ? false : Map.class.isAssignableFrom((Class) rawType); //NOSONAR
    }

    private static Type getRawTypeOf(Type valueType) {
        return valueType instanceof ParameterizedType ? ((ParameterizedType) valueType).getRawType() : valueType;
    }

    static {
        DATE_TIME_FORMAT = DateTimeFormatter.ISO_DATE_TIME;
        DATE_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE;
        TIME_FORMAT = DateTimeFormatter.ISO_LOCAL_TIME;
        objectGson = buildGson(true);
        primitiveGson = buildGson(false);
    }

    public static class ObjectAdapter implements JsonDeserializer<Object>, JsonSerializer<Object> {
        public ObjectAdapter() { //NOSONAR
        }

        public JsonElement serialize(Object src, Type typeOfSrc, JsonSerializationContext context) { //NOSONAR
            if (src == null) {
                return null;
            } else if (!DtoJsonConverter.isPrimitive(typeOfSrc) && !DtoJsonConverter.isMap(typeOfSrc)) {
                if (DtoJsonConverter.isCollection(typeOfSrc)) {
                    JsonArray array = new JsonArray();
                    Iterator var13 = ((Collection) src).iterator();

                    while (var13.hasNext()) {
                        Object current = var13.next();
                        array.add(current == null ? null : this.serialize(current, current.getClass(), context));
                    }

                    return array;
                } else {
                    Class<?> objectClass = src.getClass();
                    List<Field> fields = new LinkedList();
                    this.collectFields(objectClass, fields);
                    JsonObject serialized = new JsonObject();
                    Iterator var7 = fields.iterator();

                    while (var7.hasNext()) {
                        Field field = (Field) var7.next();
                        int modifiers = field.getModifiers();
                        if (!Modifier.isFinal(modifiers) && DtoJsonConverter.isSerializable(field)) {
                            field.setAccessible(true);

                            try {
                                serialized.add(field.getName(), context.serialize(field.get(src), field.getType()));
                            } catch (ReflectiveOperationException var11) {
                                throw new RuntimeException(var11); //NOSONAR
                            }
                        }
                    }

                    if (objectClass.getSuperclass() != Object.class) {
                        serialized.addProperty("_discriminator", toFirstLower(objectClass.getSimpleName())); //NOSONAR
                    }

                    return serialized;
                }
            } else {
                return DtoJsonConverter.primitiveGson.toJsonTree(src);
            }
        }

        public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException { //NOSONAR
            if (json instanceof JsonArray) {
                JsonArray asArray = json.getAsJsonArray();
                Collection<Object> collection = new ArrayList();
                Type elementType = ((ParameterizedType) typeOfT).getActualTypeArguments()[0];
                asArray.forEach((item) -> collection.add(DtoJsonConverter.objectGson.fromJson(item, elementType))); //NOSONAR
                return collection;
            } else if (json instanceof JsonObject && !DtoJsonConverter.isPrimitive(typeOfT) && !DtoJsonConverter.isMap(typeOfT)) {
                JsonObject jsonObject = (JsonObject) json;
                JsonElement discriminatorValue = jsonObject.get("_discriminator");

                try {
                    Class<?> dtoClass = (Class) typeOfT;
                    String fieldName;
                    if (discriminatorValue instanceof JsonPrimitive) {
                        String discriminator = discriminatorValue.getAsString();
                        char separator = dtoClass.isMemberClass() ? (char) 36 : (char) 46;
                        String prefix = dtoClass.getName().substring(0, dtoClass.getName().lastIndexOf(separator) + 1);
                        fieldName = toFirstUpper(discriminator);
                        dtoClass = Class.forName(prefix + fieldName);
                    }

                    Object dto = dtoClass.newInstance();
                    Iterator var19 = jsonObject.entrySet().iterator();

                    while (var19.hasNext()) {
                        Entry<String, JsonElement> entry = (Entry) var19.next();
                        fieldName = (String) entry.getKey(); //NOSONAR
                        JsonElement fieldValue = (JsonElement) entry.getValue(); //NOSONAR
                        if (!"_discriminator".equals(fieldName)) {
                            Field dtoField = this.getField(dtoClass, fieldName);
                            if (dtoField != null && DtoJsonConverter.isSerializable(dtoField)) {
                                dtoField.setAccessible(true);
                                Object dtoValue = context.deserialize(fieldValue, dtoField.getGenericType());
                                dtoField.set(dto, dtoValue);
                            }
                        }
                    }

                    return dto;
                } catch (ReflectiveOperationException var14) {
                    throw new RuntimeException(var14); //NOSONAR
                }
            } else {
                return DtoJsonConverter.primitiveGson.fromJson(json, typeOfT);
            }
        }

        private void collectFields(Class<?> clazz, List<Field> fields) {
            if (clazz != Object.class) {
                Field[] var3 = clazz.getDeclaredFields();
                int var4 = var3.length;

                for (int var5 = 0; var5 < var4; ++var5) {
                    Field f = var3[var5];
                    fields.add(f);
                }

                this.collectFields(clazz.getSuperclass(), fields);
            }

        }

        private Field getField(Class<?> clazz, String fieldName) {
            try {
                return clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException var5) {
                Class<?> superclass = clazz.getSuperclass();
                return superclass != null && superclass != Object.class ? this.getField(clazz.getSuperclass(), fieldName) : null;
            }
        }

        private static String toFirstUpper(String string) {
            return string.substring(0, 1).toUpperCase() + (string.length() > 1 ? string.substring(1) : "");
        }

        private static String toFirstLower(String string) {
            return string.substring(0, 1).toLowerCase() + (string.length() > 1 ? string.substring(1) : "");
        }
    }

    public static class BlobAdapter implements JsonSerializer<byte[]>, JsonDeserializer<byte[]> {
        public BlobAdapter() { //NOSONAR
        }

        public JsonElement serialize(byte[] src, Type typeOfSrc, JsonSerializationContext context) {
            return src == null ? null : new JsonPrimitive(Base64.getEncoder().encodeToString(src));
        }

        public byte[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException { //NOSONAR
            if (json != null && !(json instanceof JsonNull)) {
                try {
                    return Base64.getDecoder().decode(json.getAsString());
                } catch (DateTimeParseException var5) {
                    throw new JsonParseException(var5);
                }
            } else {
                return null; //NOSONAR
            }
        }
    }

    public static class TimeAdapter implements JsonSerializer<LocalTime>, JsonDeserializer<LocalTime> {
        public TimeAdapter() { //NOSONAR
        }

        public JsonElement serialize(LocalTime src, Type typeOfSrc, JsonSerializationContext context) {
            return src == null ? null : new JsonPrimitive(DtoJsonConverter.TIME_FORMAT.format(src));
        }

        public LocalTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException { //NOSONAR
            if (json != null && !(json instanceof JsonNull)) {
                try {
                    return LocalTime.parse(json.getAsString(), DtoJsonConverter.TIME_FORMAT);
                } catch (DateTimeParseException var5) {
                    throw new JsonParseException(var5);
                }
            } else {
                return null;
            }
        }
    }

    public static class DateAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {
        public DateAdapter() { //NOSONAR
        }

        public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
            return src == null ? null : new JsonPrimitive(DtoJsonConverter.DATE_FORMAT.format(src));
        }

        public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException { //NOSONAR
            if (json != null && !(json instanceof JsonNull)) {
                try {
                    return LocalDate.parse(json.getAsString(), DtoJsonConverter.DATE_FORMAT);
                } catch (DateTimeParseException var5) {
                    throw new JsonParseException(var5);
                }
            } else {
                return null;
            }
        }
    }

    public static class DateTimeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
        public DateTimeAdapter() { //NOSONAR
        }

        public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
            return src == null ? null : new JsonPrimitive(DtoJsonConverter.DATE_TIME_FORMAT.format(OffsetDateTime.ofInstant(src.toInstant(), ZoneOffset.UTC)));
        }

        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException { //NOSONAR
            if (json != null && !(json instanceof JsonNull)) {
                try {
                    return new Date(OffsetDateTime.parse(json.getAsString(), DtoJsonConverter.DATE_TIME_FORMAT).toInstant().toEpochMilli());
                } catch (DateTimeParseException var5) {
                    throw new JsonParseException(var5);
                }
            } else {
                return null;
            }
        }
    }

    public static class InstantAdapter implements JsonSerializer<Instant>, JsonDeserializer<Instant> {
        public InstantAdapter() { //NOSONAR
        }

        public JsonElement serialize(Instant src, Type typeOfSrc, JsonSerializationContext context) {
            return src == null ? null : new JsonPrimitive(DtoJsonConverter.DATE_TIME_FORMAT.format(OffsetDateTime.ofInstant(src, ZoneOffset.UTC)));
        }

        public Instant deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException { //NOSONAR
            if (json != null && !(json instanceof JsonNull)) {
                try {
                    return OffsetDateTime.parse(json.getAsString(), DtoJsonConverter.DATE_TIME_FORMAT).toInstant();
                } catch (DateTimeParseException var5) {
                    throw new JsonParseException(var5);
                }
            } else {
                return null;
            }
        }
    }
}
