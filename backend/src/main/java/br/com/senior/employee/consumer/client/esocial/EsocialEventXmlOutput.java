package br.com.senior.employee.consumer.client.esocial;

import java.util.Map;

public class EsocialEventXmlOutput {
    
    public ProviderXml result;
    
    public EsocialEventXmlOutput() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public EsocialEventXmlOutput(ProviderXml result) {
        this.result = result;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        if (result != null) {
            ret = 31 * ret + result.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EsocialEventXmlOutput)) {
            return false;
        }
        EsocialEventXmlOutput other = (EsocialEventXmlOutput) obj;
        if ((result == null) != (other.result == null)) {
            return false;
        }
        if ((result != null) && !result.equals(other.result)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(getClass().getSimpleName()).append(" [");
    	sb.append("result=<").append(result == null ? "null" : result).append('>');
    	sb.append(']');
    	return sb.toString();
    }
    
}
