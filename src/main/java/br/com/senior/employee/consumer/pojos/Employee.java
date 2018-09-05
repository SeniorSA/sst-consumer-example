package br.com.senior.employee.consumer.pojos;

import java.util.List;

/**
 * Colaborador.
 */
public class Employee {

    public static class Id {

        public String id;

        public Id() {
        }

        public Id(String employeeId) {
            this.id = employeeId;
        }

        public String getEmployeeId() {
            return id;
        }

        public String getId() {
            return id;
        }

    }

    public static class PagedResults {
        public Long totalPages;
        public Long totalElements;

        public List<Employee> contents;

        public PagedResults() {
        }

        public PagedResults(List<Employee> contents) {
            this.contents = contents;
        }

        public PagedResults(List<Employee> contents, Long totalPages, Long totalElements) {
            this.contents = contents;
            this.totalPages = totalPages;
            this.totalElements = totalElements;
        }
    }

    public static class PageRequest {
        public Long offset;
        public Long size;
        public boolean translations;
        public String orderBy;
        public String filter;
        public List<String> displayFields;

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
     * Id interno do colaborador.
     */
    public String id;
    /**
     * Id externo do colaborador (no Payroll).
     */
    public String externalId;
    /**
     * Data e hora do recebimento do colaborador.
     */
    public java.time.Instant receiptDate;
    /**
     * Tipo do colaborador.
     */
    public EmployeeType employeeType;
    /**
     * Código do colaborador.
     */
    public Long code;
    /**
     * Matrícula do e-Social.
     */
    public String eSocialRegistration;
    /**
     * Nome do colaborador.
     */
    public String name;
    /**
     * Número do CPF.
     */
    public String cpfNumber;
    /**
     * Número do NIS.
     */
    public String nisNumber;
    /**
     * Data de nascimento.
     */
    public java.time.LocalDate birthday;
    /**
     * Data de admissão.
     */
    public java.time.LocalDate hireDate;
    /**
     * Estado civil.
     */
    public MaritalStatusType maritalStatusType;
    /**
     * Gênero do colaborador.
     */
    public GenderType genderType;
    /**
     * Situação do colaborador.
     */
    public SituationType situationType;
    /**
     * Tipo do contrato.
     */
    public ContractType contractType;
    /**
     * Categoria do colaborador no e-Social.
     */
    public ESocialCategoryType eSocialCategoryType;
    /**
     * Colaborador é deficiente?
     */
    public Boolean isDeficient;
    /**
     * Empresa do colaborador.
     */
    public Company company;
    /**
     * Filial do colaborador.
     */
    public CompanyBranch companyBranch;
    /**
     * Centro de custo.
     */
    public CostCenter costCenter;
    /**
     * Local / Setor do colaborador.
     */
    public Department department;
    /**
     * Cargo do colaborador.
     */
    public JobPosition jobPosition;
    /**
     * Turno do colaborador.
     */
    public Shift shift;
    /**
     * Motivo de licença.
     */
    public ReasonLeave reasonLeave;
    /**
     * Posto de trabalho.
     */
    public Workstation workstation;
    /**
     * Deficiência do colaborador.
     */
    public List<Deficiency> deficiency;

    public Employee() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public Employee(String id, String externalId, java.time.Instant receiptDate, EmployeeType employeeType, Long code, String eSocialRegistration, String name, String cpfNumber, String nisNumber, java.time.LocalDate birthday, java.time.LocalDate hireDate, MaritalStatusType maritalStatusType, GenderType genderType, SituationType situationType, ContractType contractType, ESocialCategoryType eSocialCategoryType, Boolean isDeficient, Company company, CompanyBranch companyBranch, CostCenter costCenter, Department department, JobPosition jobPosition, Shift shift, ReasonLeave reasonLeave, Workstation workstation, List<Deficiency> deficiency) {
        this.id = id;
        this.externalId = externalId;
        this.receiptDate = receiptDate;
        this.employeeType = employeeType;
        this.code = code;
        this.eSocialRegistration = eSocialRegistration;
        this.name = name;
        this.cpfNumber = cpfNumber;
        this.nisNumber = nisNumber;
        this.birthday = birthday;
        this.hireDate = hireDate;
        this.maritalStatusType = maritalStatusType;
        this.genderType = genderType;
        this.situationType = situationType;
        this.contractType = contractType;
        this.eSocialCategoryType = eSocialCategoryType;
        this.isDeficient = isDeficient;
        this.company = company;
        this.companyBranch = companyBranch;
        this.costCenter = costCenter;
        this.department = department;
        this.jobPosition = jobPosition;
        this.shift = shift;
        this.reasonLeave = reasonLeave;
        this.workstation = workstation;
        this.deficiency = deficiency;
    }

    /**
     * This convenience constructor allows initialization of all required fields.
     */
    public Employee(String externalId, java.time.Instant receiptDate, String name, String cpfNumber, SituationType situationType, Company company, CompanyBranch companyBranch) {
        this.externalId = externalId;
        this.receiptDate = receiptDate;
        this.name = name;
        this.cpfNumber = cpfNumber;
        this.situationType = situationType;
        this.company = company;
        this.companyBranch = companyBranch;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        if (id != null) {
            ret = 31 * ret + id.hashCode();
        }
        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) obj;
        if ((id == null) != (other.id == null)) {
            return false;
        }
        if ((id != null) && !id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(" [");
        sb.append("id=").append(id == null ? "null" : id).append(", ");
        sb.append("externalId=").append(externalId == null ? "null" : externalId).append(", ");
        sb.append("receiptDate=").append(receiptDate == null ? "null" : receiptDate).append(", ");
        sb.append("employeeType=").append(employeeType == null ? "null" : employeeType).append(", ");
        sb.append("code=").append(code == null ? "null" : code).append(", ");
        sb.append("eSocialRegistration=").append(eSocialRegistration == null ? "null" : eSocialRegistration).append(", ");
        sb.append("name=").append(name == null ? "null" : name).append(", ");
        sb.append("cpfNumber=").append(cpfNumber == null ? "null" : cpfNumber).append(", ");
        sb.append("nisNumber=").append(nisNumber == null ? "null" : nisNumber).append(", ");
        sb.append("birthday=").append(birthday == null ? "null" : birthday).append(", ");
        sb.append("hireDate=").append(hireDate == null ? "null" : hireDate).append(", ");
        sb.append("maritalStatusType=").append(maritalStatusType == null ? "null" : maritalStatusType).append(", ");
        sb.append("genderType=").append(genderType == null ? "null" : genderType).append(", ");
        sb.append("situationType=").append(situationType == null ? "null" : situationType).append(", ");
        sb.append("contractType=").append(contractType == null ? "null" : contractType).append(", ");
        sb.append("eSocialCategoryType=").append(eSocialCategoryType == null ? "null" : eSocialCategoryType).append(", ");
        sb.append("isDeficient=").append(isDeficient == null ? "null" : isDeficient).append(", ");
        sb.append("company=<").append(company == null ? "null" : company).append('>').append(", ");
        sb.append("companyBranch=<").append(companyBranch == null ? "null" : companyBranch).append('>').append(", ");
        sb.append("costCenter=<").append(costCenter == null ? "null" : costCenter).append('>').append(", ");
        sb.append("department=<").append(department == null ? "null" : department).append('>').append(", ");
        sb.append("jobPosition=<").append(jobPosition == null ? "null" : jobPosition).append('>').append(", ");
        sb.append("shift=<").append(shift == null ? "null" : shift).append('>').append(", ");
        sb.append("reasonLeave=<").append(reasonLeave == null ? "null" : reasonLeave).append('>').append(", ");
        sb.append("workstation=<").append(workstation == null ? "null" : workstation).append('>').append(", ");
        sb.append("deficiency=<").append(deficiency == null ? "null" : deficiency).append('>');
        sb.append(']');
        return sb.toString();
    }

}
