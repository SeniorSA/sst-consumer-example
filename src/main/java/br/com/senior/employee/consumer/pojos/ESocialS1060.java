package br.com.senior.employee.consumer.pojos;

/**
 * DTO com dados do layout S-1060.
 */
public class ESocialS1060 extends BaseLayout {

    /**
     * Evento Tabela de Ambientes de Trabalho do Empregador.
     */
    public EvtTabAmbienteS1060 evtTabAmbiente;

    public ESocialS1060() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public ESocialS1060(String xmlns, EvtTabAmbienteS1060 evtTabAmbiente) {
        this.xmlns = xmlns;
        this.evtTabAmbiente = evtTabAmbiente;
    }

    /**
     * This convenience constructor allows initialization of all required fields.
     */
    public ESocialS1060(EvtTabAmbienteS1060 evtTabAmbiente) {
        this.evtTabAmbiente = evtTabAmbiente;
    }

    @Override
    public int hashCode() {
        int ret = super.hashCode();
        if (evtTabAmbiente != null) {
            ret = 31 * ret + evtTabAmbiente.hashCode();
        }
        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ESocialS1060)) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        ESocialS1060 other = (ESocialS1060) obj;
        if ((evtTabAmbiente == null) != (other.evtTabAmbiente == null)) {
            return false;
        }
        if ((evtTabAmbiente != null) && !evtTabAmbiente.equals(other.evtTabAmbiente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(" [");
        sb.append("xmlns=").append(xmlns == null ? "null" : xmlns).append(", ");
        sb.append("evtTabAmbiente=<").append(evtTabAmbiente == null ? "null" : evtTabAmbiente).append('>');
        sb.append(']');
        return sb.toString();
    }

}
