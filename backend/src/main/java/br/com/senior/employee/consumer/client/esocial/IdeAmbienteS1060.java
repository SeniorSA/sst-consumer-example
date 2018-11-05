package br.com.senior.employee.consumer.client.esocial;

/**
 * Informações de identificação do ambiente de trabalho do empregador e de validade das informações.
 */
public class IdeAmbienteS1060 {
    
    /**
     * Código atribuído pela empresa ao Ambiente de Trabalho.
     */
    public String codAmb; //NOSONAR
    /**
     * Mês e ano de início da validade das informações prestadas no evento, no formato AAAA-MM.
     */
    public String iniValid; //NOSONAR
    /**
     * Mês e ano de término da validade das informações, se houver, no formato AAAA-MM.
     */
    public String fimValid; //NOSONAR
    
    public IdeAmbienteS1060() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public IdeAmbienteS1060(String codAmb, String iniValid, String fimValid) {
        this.codAmb = codAmb;
        this.iniValid = iniValid;
        this.fimValid = fimValid;
    }
    /** 
     * This convenience constructor allows initialization of all required fields.
     */
    public IdeAmbienteS1060(String codAmb, String iniValid) {
        this.codAmb = codAmb;
        this.iniValid = iniValid;
    }
    
    @Override
    public int hashCode() {
        int ret = 1;
        if (codAmb != null) {
            ret = 31 * ret + codAmb.hashCode();
        }
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
        if (!(obj instanceof IdeAmbienteS1060)) {
            return false;
        }
        IdeAmbienteS1060 other = (IdeAmbienteS1060) obj;
        if ((codAmb == null) != (other.codAmb == null)) {
            return false;
        }
        if ((codAmb != null) && !codAmb.equals(other.codAmb)) {
            return false;
        }
        if ((iniValid == null) != (other.iniValid == null)) {
            return false;
        }
        if ((iniValid != null) && !iniValid.equals(other.iniValid)) {
            return false;
        }
        if ((fimValid == null) != (other.fimValid == null)) {
            return false;
        }
        if ((fimValid != null) && !fimValid.equals(other.fimValid)) { //NOSONAR
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(getClass().getSimpleName()).append(" [");
    	sb.append("codAmb=").append(codAmb == null ? "null" : codAmb).append(", ");
    	sb.append("iniValid=").append(iniValid == null ? "null" : iniValid).append(", ");
    	sb.append("fimValid=").append(fimValid == null ? "null" : fimValid);
    	sb.append(']');
    	return sb.toString();
    }
    
}
