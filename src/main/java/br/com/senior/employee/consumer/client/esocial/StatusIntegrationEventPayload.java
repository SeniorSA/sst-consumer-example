package br.com.senior.employee.consumer.client.esocial;

public class StatusIntegrationEventPayload {
    
    public StatusEsocialXmlDTO result;
    
    public StatusIntegrationEventPayload() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public StatusIntegrationEventPayload(StatusEsocialXmlDTO result) {
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
        if (!(obj instanceof StatusIntegrationEventPayload)) {
            return false;
        }
        StatusIntegrationEventPayload other = (StatusIntegrationEventPayload) obj;
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
