package br.com.senior.employee.consumer.pojos.esocial4integration;

import br.com.senior.employee.consumer.pojos.common.SubscriptionType;

public class EmployeeEventPayload {

    /**
     * Dados do colaborador.
     */
    public Employee employee; //NOSONAR
    /**
     * Tipo da atualização do colaborador.
     */
    public SubscriptionType.IntegrationType integrationType; //NOSONAR
    /**
     * Id da integração.
     */
    public String integrationId; //NOSONAR

    public EmployeeEventPayload() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public EmployeeEventPayload(Employee employee, SubscriptionType.IntegrationType integrationType, String integrationId) {
        this.employee = employee;
        this.integrationType = integrationType;
        this.integrationId = integrationId;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        if (employee != null) {
            ret = 31 * ret + employee.hashCode();
        }
        if (integrationType != null) {
            ret = 31 * ret + integrationType.hashCode();
        }
        if (integrationId != null) {
            ret = 31 * ret + integrationId.hashCode();
        }
        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmployeeEventPayload)) {
            return false;
        }
        EmployeeEventPayload other = (EmployeeEventPayload) obj;
        if ((employee == null) != (other.employee == null)) {
            return false;
        }
        if ((employee != null) && !employee.equals(other.employee)) {
            return false;
        }
        if ((integrationType == null) != (other.integrationType == null)) {
            return false;
        }
        if ((integrationType != null) && !integrationType.equals(other.integrationType)) {
            return false;
        }
        if ((integrationId == null) != (other.integrationId == null)) {
            return false;
        }
        if ((integrationId != null) && !integrationId.equals(other.integrationId)) { //NOSONAR
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(" [");
        sb.append("employee=<").append(employee == null ? "null" : employee).append('>').append(", ");
        sb.append("integrationType=").append(integrationType == null ? "null" : integrationType).append(", ");
        sb.append("integrationId=").append(integrationId == null ? "null" : integrationId);
        sb.append(']');
        return sb.toString();
    }

}
