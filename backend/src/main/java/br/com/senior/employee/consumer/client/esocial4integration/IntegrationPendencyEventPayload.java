package br.com.senior.employee.consumer.client.esocial4integration;

public class IntegrationPendencyEventPayload {
    
    /**
     * Dados de integração.
     */
    public Integration integration; //NOSONAR
    
    public IntegrationPendencyEventPayload() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public IntegrationPendencyEventPayload(Integration integration) {
        this.integration = integration;
    }
    
    @Override
    public int hashCode() {
        int ret = 1;
        if (integration != null) {
            ret = 31 * ret + integration.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntegrationPendencyEventPayload)) {
            return false;
        }
        IntegrationPendencyEventPayload other = (IntegrationPendencyEventPayload) obj;
        if ((integration == null) != (other.integration == null)) {
            return false;
        }
        if ((integration != null) && !integration.equals(other.integration)) { //NOSONAR
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(getClass().getSimpleName()).append(" [");
    	sb.append("integration=<").append(integration == null ? "null" : integration).append('>');
    	sb.append(']');
    	return sb.toString();
    }
    
}
