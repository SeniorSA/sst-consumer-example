package br.com.senior.employee.consumer.pojos.esocial;

import br.com.senior.employee.consumer.pojos.common.SubscriptionType;

/**
 * Informações do ambiente de trabalho.
 */
public class DadosAmbienteS1060 {
    
    /**
     * Descrição do ambiente de trabalho.
     */
    public String dscAmb; //NOSONAR
    /**
     * Preencher com uma das opções:
     * 1 - Estabelecimento do próprio empregador;
     * 2 - Estabelecimento de terceiros;
     * 3 - Prestação de serviços em instalações de terceiros não consideradas como lotações dos tipos 03 a 09 da Tabela 10.
     */
    public EnvironmentModeType localAmb; //NOSONAR
    /**
     * Código correspondente ao tipo de inscrição.
     * 1 - CNPJ
     * 2 - CPF
     * 3 - CAEPF (Cadastro de Atividade Econômica de Pessoa Física)
     * 4 - CNO (Cadastro Nacional de Obra)
     */
    public SubscriptionType tpInsc; //NOSONAR
    /**
     * Número de inscrição onde está localizado o ambiente.
     */
    public String nrInsc; //NOSONAR
    /**
     * O registro apresenta o detalhamento do(s) fator(es) de risco(s) presente(s) no ambiente identificado.
     */
    public java.util.List<FatorRiscoS1060> fatorRisco; //NOSONAR
    
    public DadosAmbienteS1060() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public DadosAmbienteS1060(String dscAmb, EnvironmentModeType localAmb, SubscriptionType tpInsc, String nrInsc, java.util.List<FatorRiscoS1060> fatorRisco) {
        this.dscAmb = dscAmb;
        this.localAmb = localAmb;
        this.tpInsc = tpInsc;
        this.nrInsc = nrInsc;
        this.fatorRisco = fatorRisco;
    }
    
    @Override
    public int hashCode() {
        int ret = 1;
        if (dscAmb != null) {
            ret = 31 * ret + dscAmb.hashCode();
        }
        if (localAmb != null) {
            ret = 31 * ret + localAmb.hashCode();
        }
        if (tpInsc != null) {
            ret = 31 * ret + tpInsc.hashCode();
        }
        if (nrInsc != null) {
            ret = 31 * ret + nrInsc.hashCode();
        }
        if (fatorRisco != null) {
            ret = 31 * ret + fatorRisco.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) { //NOSONAR
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DadosAmbienteS1060)) {
            return false;
        }
        DadosAmbienteS1060 other = (DadosAmbienteS1060) obj;
        if ((dscAmb == null) != (other.dscAmb == null)) {
            return false;
        }
        if ((dscAmb != null) && !dscAmb.equals(other.dscAmb)) {
            return false;
        }
        if ((localAmb == null) != (other.localAmb == null)) {
            return false;
        }
        if ((localAmb != null) && !localAmb.equals(other.localAmb)) {
            return false;
        }
        if ((tpInsc == null) != (other.tpInsc == null)) {
            return false;
        }
        if ((tpInsc != null) && !tpInsc.equals(other.tpInsc)) {
            return false;
        }
        if ((nrInsc == null) != (other.nrInsc == null)) {
            return false;
        }
        if ((nrInsc != null) && !nrInsc.equals(other.nrInsc)) {
            return false;
        }
        if ((fatorRisco == null) != (other.fatorRisco == null)) {
            return false;
        }
        if ((fatorRisco != null) && !fatorRisco.equals(other.fatorRisco)) { //NOSONAR
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(getClass().getSimpleName()).append(" [");
    	sb.append("dscAmb=").append(dscAmb == null ? "null" : dscAmb).append(", ");
    	sb.append("localAmb=").append(localAmb == null ? "null" : localAmb).append(", ");
    	sb.append("tpInsc=").append(tpInsc == null ? "null" : tpInsc).append(", ");
    	sb.append("nrInsc=").append(nrInsc == null ? "null" : nrInsc).append(", ");
    	sb.append("fatorRisco=<").append(fatorRisco == null ? "null" : fatorRisco).append('>');
    	sb.append(']');
    	return sb.toString();
    }
    
}
