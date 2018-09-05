package br.com.senior.employee.consumer.pojos;

/**
 * Informação preenchida exclusivamente em caso de alteração do período de
 * validade das informações do Ambiente identificado em {ideAmbiente},
 * apresentando o novo período de validade.
 */
public class NovaValidadeS1060 {

    /**
     * Mês e ano de início da validade das informações prestadas no evento, no formato AAAA-MM.
     */
    public String iniValid;
    /**
     * Preencher com o mês e ano de término da validade das informações, se houver, no formato AAAA-MM.
     */
    public String fimValid;

    public NovaValidadeS1060() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public NovaValidadeS1060(String iniValid, String fimValid) {
        this.iniValid = iniValid;
        this.fimValid = fimValid;
    }

    /**
     * This convenience constructor allows initialization of all required fields.
     */
    public NovaValidadeS1060(String iniValid) {
        this.iniValid = iniValid;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        if (iniValid != null) {
            ret = 31 * ret + iniValid.hashCode();
        }
        if (fimValid != null) {
            ret = 31 * ret + fimValid.hashCode();
        }
        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NovaValidadeS1060)) {
            return false;
        }
        NovaValidadeS1060 other = (NovaValidadeS1060) obj;
        if ((iniValid == null) != (other.iniValid == null)) {
            return false;
        }
        if ((iniValid != null) && !iniValid.equals(other.iniValid)) {
            return false;
        }
        if ((fimValid == null) != (other.fimValid == null)) {
            return false;
        }
        if ((fimValid != null) && !fimValid.equals(other.fimValid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(" [");
        sb.append("iniValid=").append(iniValid == null ? "null" : iniValid).append(", ");
        sb.append("fimValid=").append(fimValid == null ? "null" : fimValid);
        sb.append(']');
        return sb.toString();
    }

}
