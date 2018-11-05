package br.com.senior.employee.consumer.client.esocial;

/**
 * O registro apresenta o detalhamento do(s) fator(es) de risc(s) presente(s) no ambiente identificado.
 */
public class FatorRiscoS1060 {
    
    /**
     * Código do fator de risco.
     */
    public GovernmentTable codFatRis; //NOSONAR
    
    public FatorRiscoS1060() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public FatorRiscoS1060(GovernmentTable codFatRis) {
        this.codFatRis = codFatRis;
    }
    
    @Override
    public int hashCode() {
        int ret = 1;
        if (codFatRis != null) {
            ret = 31 * ret + codFatRis.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FatorRiscoS1060)) {
            return false;
        }
        FatorRiscoS1060 other = (FatorRiscoS1060) obj;
        if ((codFatRis == null) != (other.codFatRis == null)) {
            return false;
        }
        if ((codFatRis != null) && !codFatRis.equals(other.codFatRis)) { //NOSONAR
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(getClass().getSimpleName()).append(" [");
    	sb.append("codFatRis=<").append(codFatRis == null ? "null" : codFatRis).append('>');
    	sb.append(']');
    	return sb.toString();
    }
    
}
