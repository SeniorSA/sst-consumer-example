package br.com.senior.employee.consumer.client.esocial;

import br.com.senior.employee.consumer.client.common.SubscriptionType;

/**
 * Informações de identificação do empregador.
 */
public class IdeEmpregadorS1060 {
    
    /**
     * Código correspondente ao tipo de inscrição.
     */
    public SubscriptionType tpInsc; //NOSONAR
    /**
     * Número de inscrição do contribuinte.
     */
    public String nrInsc; //NOSONAR
    
    public IdeEmpregadorS1060() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public IdeEmpregadorS1060(SubscriptionType tpInsc, String nrInsc) {
        this.tpInsc = tpInsc;
        this.nrInsc = nrInsc;
    }
    
    @Override
    public int hashCode() {
        int ret = 1;
        if (tpInsc != null) {
            ret = 31 * ret + tpInsc.hashCode();
        }
        if (nrInsc != null) {
            ret = 31 * ret + nrInsc.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IdeEmpregadorS1060)) {
            return false;
        }
        IdeEmpregadorS1060 other = (IdeEmpregadorS1060) obj;
        if ((tpInsc == null) != (other.tpInsc == null)) {
            return false;
        }
        if ((tpInsc != null) && !tpInsc.equals(other.tpInsc)) {
            return false;
        }
        if ((nrInsc == null) != (other.nrInsc == null)) {
            return false;
        }
        if ((nrInsc != null) && !nrInsc.equals(other.nrInsc)) { //NOSONAR
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(getClass().getSimpleName()).append(" [");
    	sb.append("tpInsc=").append(tpInsc == null ? "null" : tpInsc).append(", ");
    	sb.append("nrInsc=").append(nrInsc == null ? "null" : nrInsc);
    	sb.append(']');
    	return sb.toString();
    }
    
}
