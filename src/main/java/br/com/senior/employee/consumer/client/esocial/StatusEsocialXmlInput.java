package br.com.senior.employee.consumer.client.esocial;

public class StatusEsocialXmlInput {

    /**
     * Identificador do XML no prestador SST
     */
    public String providerXmlId;
    /**
     * Identificador do registro na plataforma senior X.
     */
    public String id;

    public StatusEsocialXmlInput() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public StatusEsocialXmlInput(String providerXmlId, String id) {
        this.providerXmlId = providerXmlId;
        this.id = id;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        if (providerXmlId != null) {
            ret = 31 * ret + providerXmlId.hashCode();
        }
        if (id != null) {
            ret = 31 * ret + id.hashCode();
        }
        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StatusEsocialXmlInput)) {
            return false;
        }
        StatusEsocialXmlInput other = (StatusEsocialXmlInput) obj;
        if ((providerXmlId == null) != (other.providerXmlId == null)) {
            return false;
        }
        if ((providerXmlId != null) && !providerXmlId.equals(other.providerXmlId)) {
            return false;
        }
        if ((id == null) != (other.id == null)) {
            return false;
        }
        if ((id != null) && !id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(" [");
        sb.append("providerXmlId=").append(id == null ? "null" : providerXmlId).append(", ");
        sb.append("id=").append(id == null ? "null" : id);
        sb.append(']');
        return sb.toString();
    }

}
