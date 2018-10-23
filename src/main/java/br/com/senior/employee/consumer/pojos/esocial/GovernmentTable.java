package br.com.senior.employee.consumer.pojos.esocial;

/**
 * Tabela de consulta do governo.
 */
public class GovernmentTable {

    /**
     * Código da tabela.
     */
    public String code; //NOSONAR
    /**
     * Descrição da tabela.
     */
    public String name; //NOSONAR

    public GovernmentTable() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public GovernmentTable(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        if (code != null) {
            ret = 31 * ret + code.hashCode();
        }
        if (name != null) {
            ret = 31 * ret + name.hashCode();
        }
        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GovernmentTable)) {
            return false;
        }
        GovernmentTable other = (GovernmentTable) obj;
        if ((code == null) != (other.code == null)) {
            return false;
        }
        if ((code != null) && !code.equals(other.code)) {
            return false;
        }
        if ((name == null) != (other.name == null)) {
            return false;
        }
        if ((name != null) && !name.equals(other.name)) { //NOSONAR
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(" [");
        sb.append("code=").append(code == null ? "null" : code).append(", ");
        sb.append("name=").append(name == null ? "null" : name);
        sb.append(']');
        return sb.toString();
    }

}
