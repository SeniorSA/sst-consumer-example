package br.com.senior.employee.consumer.pojos.esocial;

/**
 * Identificação da operação (inclusão, alteração ou exclusão) e das informações do ambiente.
 */
public class InfoAmbienteS1060 {
    
    /**
     * Inclusão de novas informações.
     */
    public InclusaoS1060 inclusao; //NOSONAR
    /**
     * Alteração de informações já existentes.
     */
    public AlteracaoS1060 alteracao; //NOSONAR
    /**
     * Exclusão de informações.
     */
    public ExclusaoS1060 exclusao; //NOSONAR
    
    public InfoAmbienteS1060() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public InfoAmbienteS1060(InclusaoS1060 inclusao, AlteracaoS1060 alteracao, ExclusaoS1060 exclusao) {
        this.inclusao = inclusao;
        this.alteracao = alteracao;
        this.exclusao = exclusao;
    }
    
    @Override
    public int hashCode() {
        int ret = 1;
        if (inclusao != null) {
            ret = 31 * ret + inclusao.hashCode();
        }
        if (alteracao != null) {
            ret = 31 * ret + alteracao.hashCode();
        }
        if (exclusao != null) {
            ret = 31 * ret + exclusao.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InfoAmbienteS1060)) {
            return false;
        }
        InfoAmbienteS1060 other = (InfoAmbienteS1060) obj;
        if ((inclusao == null) != (other.inclusao == null)) {
            return false;
        }
        if ((inclusao != null) && !inclusao.equals(other.inclusao)) {
            return false;
        }
        if ((alteracao == null) != (other.alteracao == null)) {
            return false;
        }
        if ((alteracao != null) && !alteracao.equals(other.alteracao)) {
            return false;
        }
        if ((exclusao == null) != (other.exclusao == null)) {
            return false;
        }
        if ((exclusao != null) && !exclusao.equals(other.exclusao)) { //NOSONAR
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(getClass().getSimpleName()).append(" [");
    	sb.append("inclusao=<").append(inclusao == null ? "null" : inclusao).append('>').append(", ");
    	sb.append("alteracao=<").append(alteracao == null ? "null" : alteracao).append('>').append(", ");
    	sb.append("exclusao=<").append(exclusao == null ? "null" : exclusao).append('>');
    	sb.append(']');
    	return sb.toString();
    }
    
}
