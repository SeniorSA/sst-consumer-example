package br.com.senior.employee.consumer.client.esocial;

import java.util.List;
import java.util.Objects;

/**
 *  Entidade que representa o retorno do xml, com seu id e status.
 */
public class XmlStatus {

    /**
     * Id da entidade.
     */
    public String id; //NOSONAR
    /**
     * Status do XML.
     */
    public XmlStatusType xmlStatusType; //NOSONAR

    /**
     * Mensagem de erro.
     */
    public String mensagem; //NOSONAR

    public XmlStatus() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XmlStatus xmlStatus = (XmlStatus) o;
        return Objects.equals(id, xmlStatus.id) &&
                xmlStatusType == xmlStatus.xmlStatusType &&
                Objects.equals(mensagem, xmlStatus.mensagem);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, xmlStatusType, mensagem);
    }

    @Override
    public String toString() {
        return "XmlStatus{" +
                "id='" + id + '\'' +
                ", xmlStatusType=" + xmlStatusType +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }

    public static class PagedResults {
        public Long totalPages; //NOSONAR
        public Long totalElements; //NOSONAR

        public List<XmlStatus> contents; //NOSONAR

        public PagedResults() {
        }

        public PagedResults(List<XmlStatus> contents) {
            this.contents = contents;
        }

        public PagedResults(List<XmlStatus> contents, Long totalPages, Long totalElements) {
            this.contents = contents;
            this.totalPages = totalPages;
            this.totalElements = totalElements;
        }
    }
    public static class PageRequest {
        public Long offset; //NOSONAR
        public Long size; //NOSONAR
        public boolean translations; //NOSONAR
        public String orderBy; //NOSONAR
        public String filter; //NOSONAR
        public List<String> displayFields; //NOSONAR

        public PageRequest() {
        }

        public PageRequest(Long offset, Long size) {
            this(offset, size, null, null);
        }

        public PageRequest(Long offset, Long size, String orderBy) {
            this(offset, size, orderBy, null);
        }

        public PageRequest(Long offset, Long size, String orderBy, String filter) {
            this(offset, size, orderBy, filter, null);
        }

        public PageRequest(Long offset, Long size, String orderBy, String filter, List<String> displayFields) {
            this.offset = offset;
            this.size = size;
            this.orderBy = orderBy;
            this.filter = filter;
            this.displayFields = displayFields;
        }
    }

}
