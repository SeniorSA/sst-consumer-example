package br.com.senior.employee.consumer.client.esocial;

import java.util.List;

/**
 * Entidade que representa o envio do XML.
 */
public class XmlSituation {

    public static class Id {

        public String id; //NOSONAR

        public Id() {
        }

        public Id(String xmlSituationId) {
            this.id = xmlSituationId;
        }

        public String getXmlSituationId() {
            return id;
        }

        public String getId() {
            return id;
        }
    }

    public static class PagedResults {
        public Long totalPages; //NOSONAR
        public Long totalElements; //NOSONAR

        public List<XmlSituation> contents; //NOSONAR

        public PagedResults() {
        }

        public PagedResults(List<XmlSituation> contents) {
            this.contents = contents;
        }

        public PagedResults(List<XmlSituation> contents, Long totalPages, Long totalElements) {
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

    /**
     * Id da entidade.
     */
    public String id; //NOSONAR

    /**
     * Xml.
     */
    public EsocialEventXmlInput xml; //NOSONAR


    public XmlSituation() {
    }

}
