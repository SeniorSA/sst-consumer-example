package br.com.senior.employee.consumer.pojos.esocial;

/**
 * Alteração de informações já existentes.
 */
public class AlteracaoS1060 {

    /**
     * Grupo de informações de identificação do Ambiente de Trabalho,
     * apresentando código e período de validade do Ambiente cujas informações
     * serão alteradas pelos dados constantes neste evento.
     */
    public IdeAmbienteS1060 ideAmbiente; //NOSONAR
    /**
     * Informações do Ambiente de Trabalho.
     */
    public DadosAmbienteS1060 dadosAmbiente; //NOSONAR
    /**
     * Informação preenchida exclusivamente em caso de alteração do período de
     * validade das informações do Ambiente identificado em {ideAmbiente},
     * apresentando o novo período de validade.
     */
    public NovaValidadeS1060 novaValidade; //NOSONAR

    public AlteracaoS1060() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public AlteracaoS1060(IdeAmbienteS1060 ideAmbiente, DadosAmbienteS1060 dadosAmbiente, NovaValidadeS1060 novaValidade) {
        this.ideAmbiente = ideAmbiente;
        this.dadosAmbiente = dadosAmbiente;
        this.novaValidade = novaValidade;
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
        if (novaValidade != null) {
            ret = 31 * ret + novaValidade.hashCode();
        }
        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlteracaoS1060)) {
            return false;
        }
        AlteracaoS1060 other = (AlteracaoS1060) obj;
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
        if ((novaValidade == null) != (other.novaValidade == null)) {
            return false;
        }
        if ((novaValidade != null) && !novaValidade.equals(other.novaValidade)) { //NOSONAR
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(getClass().getSimpleName()).append(" [");
    	sb.append("ideAmbiente=<").append(ideAmbiente == null ? "null" : ideAmbiente).append('>').append(", ");
    	sb.append("dadosAmbiente=<").append(dadosAmbiente == null ? "null" : dadosAmbiente).append('>').append(", ");
    	sb.append("novaValidade=<").append(novaValidade == null ? "null" : novaValidade).append('>');
    	sb.append(']');
    	return sb.toString();
    }

}
