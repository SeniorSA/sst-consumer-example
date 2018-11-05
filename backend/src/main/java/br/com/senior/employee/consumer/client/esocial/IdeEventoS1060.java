package br.com.senior.employee.consumer.client.esocial;

/**
 * Informações de Identificação do Evento.
 */
public class IdeEventoS1060 {

    /**
     * Identificação do ambiente:
     * 1 - Produção;
     * 2 - Produção restrita.
     */
    public EnvironmentIdType tpAmb; //NOSONAR
    /**
     * Processo de emissão do evento:
     * 1 - Aplicativo do empregador;
     * 2 - Aplicativo governamental - Empregador Doméstico;
     * 3 - Aplicativo governamental - Web Geral;
     * 4 - Aplicativo governamental - Microempreendedor Individual (MEI);
     * 5 - Aplicativo governamental - Segurado Especial.
     */
    public EventEmissionType procEmi; //NOSONAR
    /**
     * Versão do processo de emissão do evento.
     * Informar a versão do aplicativo emissor do evento.
     * Tamanho máximo de 20 caracteres.
     */
    public String verProc; //NOSONAR

    public IdeEventoS1060() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public IdeEventoS1060(EnvironmentIdType tpAmb, EventEmissionType procEmi, String verProc) {
        this.tpAmb = tpAmb;
        this.procEmi = procEmi;
        this.verProc = verProc;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        if (tpAmb != null) {
            ret = 31 * ret + tpAmb.hashCode();
        }
        if (procEmi != null) {
            ret = 31 * ret + procEmi.hashCode();
        }
        if (verProc != null) {
            ret = 31 * ret + verProc.hashCode();
        }
        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IdeEventoS1060)) {
            return false;
        }
        IdeEventoS1060 other = (IdeEventoS1060) obj;
        if ((tpAmb == null) != (other.tpAmb == null)) {
            return false;
        }
        if ((tpAmb != null) && !tpAmb.equals(other.tpAmb)) {
            return false;
        }
        if ((procEmi == null) != (other.procEmi == null)) {
            return false;
        }
        if ((procEmi != null) && !procEmi.equals(other.procEmi)) {
            return false;
        }
        if ((verProc == null) != (other.verProc == null)) {
            return false;
        }
        if ((verProc != null) && !verProc.equals(other.verProc)) { //NOSONAR
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(" [");
        sb.append("tpAmb=").append(tpAmb == null ? "null" : tpAmb).append(", ");
        sb.append("procEmi=").append(procEmi == null ? "null" : procEmi).append(", ");
        sb.append("verProc=").append(verProc == null ? "null" : verProc);
        sb.append(']');
        return sb.toString();
    }

}
