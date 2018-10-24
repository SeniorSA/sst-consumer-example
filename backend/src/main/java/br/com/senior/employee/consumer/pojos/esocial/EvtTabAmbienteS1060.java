package br.com.senior.employee.consumer.pojos.esocial;

/**
 * Evento Tabela de Ambientes de Trabalho do Empregador.
 */
public class EvtTabAmbienteS1060 {
    
    /**
     * Identificação única do evento.
     */
    public String id; //NOSONAR
    /**
     * Informações de Identificação do Evento.
     */
    public IdeEventoS1060 ideEvento; //NOSONAR
    /**
     * Informações de identificação do empregador.
     */
    public IdeEmpregadorS1060 ideEmpregador; //NOSONAR
    /**
     * Identificação da operação (inclusão, alteração ou exclusão) e das informações do ambiente.
     */
    public InfoAmbienteS1060 infoAmbiente; //NOSONAR
    
    public EvtTabAmbienteS1060() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public EvtTabAmbienteS1060(String id, IdeEventoS1060 ideEvento, IdeEmpregadorS1060 ideEmpregador, InfoAmbienteS1060 infoAmbiente) {
        this.id = id;
        this.ideEvento = ideEvento;
        this.ideEmpregador = ideEmpregador;
        this.infoAmbiente = infoAmbiente;
    }
    
    @Override
    public int hashCode() {
        int ret = 1;
        if (id != null) {
            ret = 31 * ret + id.hashCode();
        }
        if (ideEvento != null) {
            ret = 31 * ret + ideEvento.hashCode();
        }
        if (ideEmpregador != null) {
            ret = 31 * ret + ideEmpregador.hashCode();
        }
        if (infoAmbiente != null) {
            ret = 31 * ret + infoAmbiente.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EvtTabAmbienteS1060)) {
            return false;
        }
        EvtTabAmbienteS1060 other = (EvtTabAmbienteS1060) obj;
        if ((id == null) != (other.id == null)) {
            return false;
        }
        if ((id != null) && !id.equals(other.id)) {
            return false;
        }
        if ((ideEvento == null) != (other.ideEvento == null)) {
            return false;
        }
        if ((ideEvento != null) && !ideEvento.equals(other.ideEvento)) {
            return false;
        }
        if ((ideEmpregador == null) != (other.ideEmpregador == null)) {
            return false;
        }
        if ((ideEmpregador != null) && !ideEmpregador.equals(other.ideEmpregador)) {
            return false;
        }
        if ((infoAmbiente == null) != (other.infoAmbiente == null)) {
            return false;
        }
        if ((infoAmbiente != null) && !infoAmbiente.equals(other.infoAmbiente)) { //NOSONAR
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(getClass().getSimpleName()).append(" [");
    	sb.append("id=").append(id == null ? "null" : id).append(", ");
    	sb.append("ideEvento=<").append(ideEvento == null ? "null" : ideEvento).append('>').append(", ");
    	sb.append("ideEmpregador=<").append(ideEmpregador == null ? "null" : ideEmpregador).append('>').append(", ");
    	sb.append("infoAmbiente=<").append(infoAmbiente == null ? "null" : infoAmbiente).append('>');
    	sb.append(']');
    	return sb.toString();
    }
    
}
