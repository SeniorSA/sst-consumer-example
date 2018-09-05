package br.com.senior.employee.consumer.pojos;

/**
 * Record base para todos os Layouts.
 */
public class BaseLayout {

    /**
     * Atributo necessário para geração do xml no padrão do governo.
     */
    public String xmlns;

    public BaseLayout() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public BaseLayout(String xmlns) {
        this.xmlns = xmlns;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        if (xmlns != null) {
            ret = 31 * ret + xmlns.hashCode();
        }
        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseLayout)) {
            return false;
        }
        BaseLayout other = (BaseLayout) obj;
        if ((xmlns == null) != (other.xmlns == null)) {
            return false;
        }
        if ((xmlns != null) && !xmlns.equals(other.xmlns)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(" [");
        sb.append("xmlns=").append(xmlns == null ? "null" : xmlns);
        sb.append(']');
        return sb.toString();
    }

}
