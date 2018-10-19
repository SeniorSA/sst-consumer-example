package br.com.senior.employee.consumer.pojos;

import java.util.Map;

/**
 * Inclusão de novas informações.
 */
public class InclusaoS1060 {
    
    /**
     * Informações de identificação do ambiente de trabalho do empregador e de validade das informações.
     */
    public IdeAmbienteS1060 ideAmbiente;
    /**
     * Informações do ambiente de trabalho.
     */
    public DadosAmbienteS1060 dadosAmbiente;
    
    public InclusaoS1060() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public InclusaoS1060(IdeAmbienteS1060 ideAmbiente, DadosAmbienteS1060 dadosAmbiente) {
        this.ideAmbiente = ideAmbiente;
        this.dadosAmbiente = dadosAmbiente;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        if (ideAmbiente != null) {
            ret = 31 * ret + ideAmbiente.hashCode();
        }
        if (dadosAmbiente != null) {
            ret = 31 * ret + dadosAmbiente.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InclusaoS1060)) {
            return false;
        }
        InclusaoS1060 other = (InclusaoS1060) obj;
        if ((ideAmbiente == null) != (other.ideAmbiente == null)) {
            return false;
        }
        if ((ideAmbiente != null) && !ideAmbiente.equals(other.ideAmbiente)) {
            return false;
        }
        if ((dadosAmbiente == null) != (other.dadosAmbiente == null)) {
            return false;
        }
        if ((dadosAmbiente != null) && !dadosAmbiente.equals(other.dadosAmbiente)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(getClass().getSimpleName()).append(" [");
    	sb.append("ideAmbiente=<").append(ideAmbiente == null ? "null" : ideAmbiente).append('>').append(", ");
    	sb.append("dadosAmbiente=<").append(dadosAmbiente == null ? "null" : dadosAmbiente).append('>');
    	sb.append(']');
    	return sb.toString();
    }
    
}
