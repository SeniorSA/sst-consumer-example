package br.com.senior.employee.consumer.pojos.esocial;

/**
 * Exclusão de informações.
 */
public class ExclusaoS1060 {
    
    /**
     * Grupo de informações que identifica o Ambiente que será excluído.
     */
    public IdeAmbienteS1060 ideAmbiente; //NOSONAR
    
    public ExclusaoS1060() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public ExclusaoS1060(IdeAmbienteS1060 ideAmbiente) {
        this.ideAmbiente = ideAmbiente;
    }
    
    @Override
    public int hashCode() {
        int ret = 1;
        if (ideAmbiente != null) {
            ret = 31 * ret + ideAmbiente.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExclusaoS1060)) {
            return false;
        }
        ExclusaoS1060 other = (ExclusaoS1060) obj;
        if ((ideAmbiente == null) != (other.ideAmbiente == null)) {
            return false;
        }
        if ((ideAmbiente != null) && !ideAmbiente.equals(other.ideAmbiente)) { //NOSONAR
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(getClass().getSimpleName()).append(" [");
    	sb.append("ideAmbiente=<").append(ideAmbiente == null ? "null" : ideAmbiente).append('>');
    	sb.append(']');
    	return sb.toString();
    }
    
}
