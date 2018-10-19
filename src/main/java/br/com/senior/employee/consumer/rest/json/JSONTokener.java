package br.com.senior.employee.consumer.rest.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class JSONTokener {
    private int index;
    private int line;
    private Reader reader;
    private char lastChar;
    private boolean useLastChar;

    public JSONTokener(Reader reader) {
        this.reader = (Reader) (reader.markSupported() ? reader : new BufferedReader(reader));
        this.useLastChar = false;
        this.index = 0;
        this.line = 1;
    }

    public JSONTokener(String s) {
        this((Reader) (new StringReader(s)));
    }

    public void back() throws JSONException {
        if (!this.useLastChar && this.index > 0) {
            --this.index;
            this.useLastChar = true;
        } else {
            throw new JSONException("Stepping back two steps is not supported");
        }
    }

    public static int dehexchar(char c) {
        if (c >= '0' && c <= '9') {
            return c - 48;
        } else if (c >= 'A' && c <= 'F') {
            return c - 55;
        } else {
            return c >= 'a' && c <= 'f' ? c - 87 : -1;
        }
    }

    public boolean more() throws JSONException {
        char nextChar = this.next();
        if (nextChar == 0) {
            return false;
        } else {
            this.back();
            return true;
        }
    }

    public char next() throws JSONException {
        if (this.useLastChar) {
            this.useLastChar = false;
            if (this.lastChar != 0) {
                ++this.index;
            }

            return this.lastChar;
        } else {
            int c;
            try {
                c = this.reader.read();
            } catch (IOException var3) {
                throw new JSONException(var3);
            }

            if (c <= 0) {
                this.lastChar = 0;
                return '\u0000';
            } else {
                ++this.index;
                if (c == 10) {
                    ++this.line;
                }

                this.lastChar = (char) c;
                return this.lastChar;
            }
        }
    }

    public char next(char c) throws JSONException {
        char n = this.next();
        if (n != c) {
            throw this.syntaxError("Expected '" + c + "' and instead saw '" + n + "'");
        } else {
            return n;
        }
    }

    public String next(int n) throws JSONException {
        if (n == 0) {
            return "";
        } else {
            char[] buffer = new char[n];
            int pos = 0;
            if (this.useLastChar) {
                this.useLastChar = false;
                buffer[0] = this.lastChar;
                pos = 1;
            }

            int len;
            try {
                while (pos < n && (len = this.reader.read(buffer, pos, n - pos)) != -1) {
                    pos += len;
                }
            } catch (IOException var5) {
                throw new JSONException(var5);
            }

            this.index += pos;
            if (pos < n) {
                throw this.syntaxError("Substring bounds error");
            } else {
                this.lastChar = buffer[n - 1];
                return new String(buffer);
            }
        }
    }

    public char nextClean() throws JSONException {
        label52:
        while (true) {
            char c = this.next();
            if (c == '/') {
                switch (this.next()) {
                    case '*':
                        while (true) {
                            c = this.next();
                            if (c == 0) {
                                throw this.syntaxError("Unclosed comment");
                            }

                            if (c == '*') {
                                if (this.next() == '/') {
                                    continue label52;
                                }

                                this.back();
                            }
                        }
                    case '/':
                        while (true) {
                            c = this.next();
                            if (c == '\n' || c == '\r' || c == 0) {
                                continue label52;
                            }
                        }
                    default:
                        this.back();
                        return '/';
                }
            } else if (c == '#') {
                while (true) {
                    c = this.next();
                    if (c == '\n' || c == '\r' || c == 0) {
                        break;
                    }
                }
            } else if (c == 0 || c > ' ') {
                return c;
            }
        }
    }

    public String nextString(char quote) throws JSONException {
        StringBuffer sb = new StringBuffer();

        while (true) {
            char c = this.next();
            switch (c) {
                case '\u0000':
                case '\n':
                case '\r':
                    throw this.syntaxError("Unterminated string");
                case '\\':
                    c = this.next();
                    switch (c) {
                        case 'b':
                            sb.append('\b');
                            continue;
                        case 'f':
                            sb.append('\f');
                            continue;
                        case 'n':
                            sb.append('\n');
                            continue;
                        case 'r':
                            sb.append('\r');
                            continue;
                        case 't':
                            sb.append('\t');
                            continue;
                        case 'u':
                            sb.append((char) Integer.parseInt(this.next((int) 4), 16));
                            continue;
                        case 'x':
                            sb.append((char) Integer.parseInt(this.next((int) 2), 16));
                            continue;
                        default:
                            sb.append(c);
                            continue;
                    }
                default:
                    if (c == quote) {
                        return sb.toString();
                    }

                    sb.append(c);
            }
        }
    }

    public String nextTo(char d) throws JSONException {
        StringBuffer sb = new StringBuffer();

        while (true) {
            char c = this.next();
            if (c == d || c == 0 || c == '\n' || c == '\r') {
                if (c != 0) {
                    this.back();
                }

                return sb.toString().trim();
            }

            sb.append(c);
        }
    }

    public String nextTo(String delimiters) throws JSONException {
        StringBuffer sb = new StringBuffer();

        while (true) {
            char c = this.next();
            if (delimiters.indexOf(c) >= 0 || c == 0 || c == '\n' || c == '\r') {
                if (c != 0) {
                    this.back();
                }

                return sb.toString().trim();
            }

            sb.append(c);
        }
    }

    public Object nextValue() throws JSONException {
        char c = this.nextClean();
        switch (c) {
            case '"':
            case '\'':
                return this.nextString(c);
            case '(':
            case '[':
                this.back();
                return new JSONArray(this);
            case '{':
                this.back();
                return new JSONObject(this);
            default:
                StringBuffer sb = new StringBuffer();

                char b;
                for (b = c; c >= ' ' && ",:]}/\\\"[{;=#".indexOf(c) < 0; c = this.next()) {
                    sb.append(c);
                }

                this.back();
                String s = sb.toString().trim();
                if (s.equals("")) {
                    throw this.syntaxError("Missing value");
                } else if (s.equalsIgnoreCase("true")) {
                    return Boolean.TRUE;
                } else if (s.equalsIgnoreCase("false")) {
                    return Boolean.FALSE;
                } else if (s.equalsIgnoreCase("null")) {
                    return JSONObject.NULL;
                } else if ((b < '0' || b > '9') && b != '.' && b != '-' && b != '+') {
                    return s;
                } else {
                    if (b == '0') {
                        if (s.length() > 2 && (s.charAt(1) == 'x' || s.charAt(1) == 'X')) {
                            try {
                                return new Integer(Integer.parseInt(s.substring(2), 16));
                            } catch (Exception var12) {
                                ;
                            }
                        } else {
                            try {
                                return new Integer(Integer.parseInt(s, 8));
                            } catch (Exception var11) {
                                ;
                            }
                        }
                    }

                    try {
                        return new Integer(s);
                    } catch (Exception var10) {
                        try {
                            return new Long(s);
                        } catch (Exception var9) {
                            try {
                                return new Double(s);
                            } catch (Exception var8) {
                                return s;
                            }
                        }
                    }
                }
        }
    }

    public char skipTo(char to) throws JSONException {
        char c;
        try {
            int startIndex = this.index;
            this.reader.mark(2147483647);

            do {
                c = this.next();
                if (c == 0) {
                    this.reader.reset();
                    this.index = startIndex;
                    return c;
                }
            } while (c != to);
        } catch (IOException var4) {
            throw new JSONException(var4);
        }

        this.back();
        return c;
    }

    public JSONException syntaxError(String message) {
        return new JSONException(message + this.toString());
    }

    public String toString() {
        return " at character " + this.index + " line " + this.line;
    }
}