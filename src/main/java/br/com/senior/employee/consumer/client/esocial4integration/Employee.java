package br.com.senior.employee.consumer.client.esocial4integration;

import java.time.LocalDate;
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
    public ESocialCategory eSocialCategory;
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
     * Posto de trabalho.
     */
    public Workstation workstation;
    /**
     * Motivo do afastamento.
     */
    public ReasonLeave reasonLeave;
    /**
     * Deficiência do colaborador.
     */
    public List<Deficiency> deficiencies;
    /**
     * Data de demissão.
     */
    public java.time.LocalDate dismissalDate;

    /**
     * Número da carteira de trabalho
     */
    public String ctpsNumber;
    /**
     * Série da carteira de trabalho
     */
    public String ctpsSerie;
    /**
     * Data de emissão da carteira de trabalho
     */
    public java.time.LocalDate ctpsIssuanceDate;
    /**
     * Digito da carteira de trabalho
     */
    public String ctpsSerieDigit;
    /**
     * Estado da carteira de trabalho
     */
    public State ctpsState;
    /**
     * Carteira de identidade
     */
    public String rgNumber;
    /**
     * Orgão emissor da carteira de identidade
     */
    public String rgIssuer;
    /**
     * Estado da carteira de identidade
     */
    public State rgState;
    /**
     * Data de emissão da carteira de identidade
     */
    public java.time.LocalDate rgIssuanceDate;

    /**
     * Número de contratos do colaborador
     */
    public Long numberContractSameHireDate;
    /**
     * Empresa anterior do colaborador.
     */
    public Company previousCompany;
    /**
     * Filial anterior do colaborador.
     */
    public CompanyBranch previousCompanyBranch;
    /**
     * Adicionais no salário do colaborador
     */
    public SalaryPremium salaryPremium;


    public Employee() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public Employee(String id, String externalId, EmployeeType employeeType, Long code, String eSocialRegistration, String name, String cpfNumber, String nisNumber, LocalDate birthday, LocalDate hireDate, MaritalStatusType maritalStatusType, GenderType genderType, SituationType situationType, ContractType contractType, ESocialCategory eSocialCategory, Boolean isDeficient, Company company, CompanyBranch companyBranch, CostCenter costCenter, Department department, JobPosition jobPosition, Shift shift, Workstation workstation, ReasonLeave reasonLeave, List<Deficiency> deficiencies, LocalDate dismissalDate, String ctpsNumber, String ctpsSerie, LocalDate ctpsIssuanceDate, String ctpsSerieDigit, State ctpsState, String rgNumber, String rgIssuer, State rgState, LocalDate rgIssuanceDate, Long numberContractSameHireDate, Company previousCompany, CompanyBranch previousCompanyBranch, SalaryPremium salaryPremium) {
        this.id = id;
        this.externalId = externalId;
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
        this.eSocialCategory = eSocialCategory;
        this.isDeficient = isDeficient;
        this.company = company;
        this.companyBranch = companyBranch;
        this.costCenter = costCenter;
        this.department = department;
        this.jobPosition = jobPosition;
        this.shift = shift;
        this.workstation = workstation;
        this.reasonLeave = reasonLeave;
        this.deficiencies = deficiencies;
        this.dismissalDate = dismissalDate;
        this.ctpsNumber = ctpsNumber;
        this.ctpsSerie = ctpsSerie;
        this.ctpsIssuanceDate = ctpsIssuanceDate;
        this.ctpsSerieDigit = ctpsSerieDigit;
        this.ctpsState = ctpsState;
        this.rgNumber = rgNumber;
        this.rgIssuer = rgIssuer;
        this.rgState = rgState;
        this.rgIssuanceDate = rgIssuanceDate;
        this.numberContractSameHireDate = numberContractSameHireDate;
        this.previousCompany = previousCompany;
        this.previousCompanyBranch = previousCompanyBranch;
        this.salaryPremium = salaryPremium;
    }

    /**
     * This convenience constructor allows initialization of all required fields.
     */
    public Employee(String externalId, String name, SituationType situationType, Company company, CompanyBranch companyBranch) {
        this.externalId = externalId;
        this.name = name;
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
        sb.append("eSocialCategory=<").append(eSocialCategory == null ? "null" : eSocialCategory).append('>').append(", ");
        sb.append("isDeficient=").append(isDeficient == null ? "null" : isDeficient).append(", ");
        sb.append("company=<").append(company == null ? "null" : company).append('>').append(", ");
        sb.append("companyBranch=<").append(companyBranch == null ? "null" : companyBranch).append('>').append(", ");
        sb.append("costCenter=<").append(costCenter == null ? "null" : costCenter).append('>').append(", ");
        sb.append("department=<").append(department == null ? "null" : department).append('>').append(", ");
        sb.append("jobPosition=<").append(jobPosition == null ? "null" : jobPosition).append('>').append(", ");
        sb.append("shift=<").append(shift == null ? "null" : shift).append('>').append(", ");
        sb.append("workstation=<").append(workstation == null ? "null" : workstation).append('>').append(", ");
        sb.append("reasonLeave=<").append(reasonLeave == null ? "null" : reasonLeave).append('>').append(", ");
        sb.append("deficiencies=<").append(deficiencies == null ? "null" : deficiencies).append('>').append(", ");
        sb.append("dismissalDate=").append(dismissalDate == null ? "null" : dismissalDate);
        sb.append("ctpsNumber=").append(ctpsNumber == null ? "null" : ctpsNumber).append(", ");
        sb.append("ctpsSerie=").append(ctpsSerie == null ? "null" : ctpsSerie).append(", ");
        sb.append("ctpsIssuanceDate=").append(ctpsIssuanceDate == null ? "null" : ctpsIssuanceDate).append(", ");
        sb.append("ctpsSerieDigit=").append(ctpsSerieDigit == null ? "null" : ctpsSerieDigit).append(", ");
        sb.append("ctpsState=").append(ctpsState == null ? "null" : ctpsState).append(", ");
        sb.append("rgNumber=").append(rgNumber == null ? "null" : rgNumber).append(", ");
        sb.append("rgIssuer=").append(rgIssuer == null ? "null" : rgIssuer).append(", ");
        sb.append("rgState=").append(rgState == null ? "null" : rgState).append(", ");
        sb.append("rgIssuanceDate=").append(rgIssuanceDate == null ? "null" : rgIssuanceDate).append(", ");
        sb.append("numberContractSameHireDate=").append(numberContractSameHireDate == null ? "null" : numberContractSameHireDate).append(", ");
        sb.append("previousCompany=").append(previousCompany == null ? "null" : previousCompany).append(", ");
        sb.append("previousCompanyBranch=").append(previousCompanyBranch == null ? "null" : previousCompanyBranch).append(", ");
        sb.append("salaryPremium=").append(salaryPremium == null ? "null" : salaryPremium);
        sb.append(']');
        return sb.toString();
    }

}