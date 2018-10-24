/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.employee.consumer.entity;

import br.com.senior.employee.consumer.pojos.common.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

    public static final String SECURITY_RESOURCE = "res://senior.com.br/hcm/esocial4integration/entities/employee";

    /**
     * Id interno do colaborador.
     */
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false)
    private java.util.UUID id;

    /**
     * Tipo do colaborador.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "employee_type")
    private EmployeeType employeeType;

    /**
     * Código do colaborador.
     */
    @Column(name = "code")
    private Long code;

    /**
     * Matrícula do e-Social.
     */
    @Column(name = "e_social_registration")
    private String eSocialRegistration;

    /**
     * Nome do colaborador.
     */
    @Column(name = "name")
    private String name;

    /**
     * Número do CPF.
     */
    @Column(name = "cpf_number")
    private String cpfNumber;

    /**
     * Número do NIS.
     */
    @Column(name = "nis_number")
    private String nisNumber;

    /**
     * Data de nascimento.
     */
    @Column(name = "birthday")
    private java.time.LocalDate birthday;

    /**
     * Data de admissão.
     */
    @Column(name = "hire_date")
    private java.time.LocalDate hireDate;

    /**
     * Estado civil.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "marital_status_type")
    private MaritalStatusType maritalStatusType;

    /**
     * Gênero do colaborador.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "gender_type")
    private GenderType genderType;

    /**
     * Situação do colaborador.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "situation_type")
    private SituationType situationType;

    /**
     * Tipo do contrato.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "contract_type")
    private ContractType contractType;

    /**
     * Categoria do colaborador no e-Social.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "e_social_category_type")
    private ESocialCategoryType eSocialCategoryType;

    /**
     * Colaborador é deficiente?
     */
    @Column(name = "is_deficient")
    private Boolean isDeficient;

    /**
     * Empresa do colaborador.
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "company")
    private CompanyEntity company;

    /**
     * Filial do colaborador.
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "company_branch")
    private CompanyBranchEntity companyBranch;

    /**
     * Centro de custo.
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "cost_center")
    private CostCenterEntity costCenter;

    /**
     * Local / Setor do colaborador.
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "department")
    private DepartmentEntity department;

    /**
     * Cargo do colaborador.
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "job_position")
    private JobPositionEntity jobPosition;

    /**
     * Turno do colaborador.
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "shift")
    private ShiftEntity shift;

    /**
     * Posto de trabalho.
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "workstation")
    private WorkstationEntity workstation;

    /**
     * Deficiência do colaborador.
     */
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "employee_deficiency",
            joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "deficiency_id", referencedColumnName = "id"))
    private java.util.List<DeficiencyEntity> deficiency;


    /**
     * Tipo da integração.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "integration_type")
    private IntegrationType integrationType;

    /**
     * Data de demissão.
     */
    @Column(name = "dismissal_date")
    private java.time.LocalDate dismissalDate;

    /**
     * Data e hora do recebimento do colaborador.
     */
    @Column(name = "receipt_date")
    private java.time.Instant receiptDate;

    public java.util.UUID getId() {
        return this.id;
    }

    public EmployeeType getEmployeeType() {
        return this.employeeType;
    }

    public Long getCode() {
        return this.code;
    }

    public String getESocialRegistration() {
        return this.eSocialRegistration;
    }

    public String getName() {
        return this.name;
    }

    public String getCpfNumber() {
        return this.cpfNumber;
    }

    public String getNisNumber() {
        return this.nisNumber;
    }

    public java.time.LocalDate getBirthday() {
        return this.birthday;
    }

    public java.time.LocalDate getHireDate() {
        return this.hireDate;
    }

    public MaritalStatusType getMaritalStatusType() {
        return this.maritalStatusType;
    }

    public GenderType getGenderType() {
        return this.genderType;
    }

    public SituationType getSituationType() {
        return this.situationType;
    }

    public ContractType getContractType() {
        return this.contractType;
    }

    public ESocialCategoryType getESocialCategoryType() {
        return this.eSocialCategoryType;
    }

    public Boolean getIsDeficient() {
        return this.isDeficient;
    }

    public CompanyEntity getCompany() {
        return this.company;
    }

    public CompanyBranchEntity getCompanyBranch() {
        return this.companyBranch;
    }

    public CostCenterEntity getCostCenter() {
        return this.costCenter;
    }

    public DepartmentEntity getDepartment() {
        return this.department;
    }

    public JobPositionEntity getJobPosition() {
        return this.jobPosition;
    }

    public ShiftEntity getShift() {
        return this.shift;
    }

    public WorkstationEntity getWorkstation() {
        return this.workstation;
    }

    public java.util.List<DeficiencyEntity> getDeficiency() {
        return this.deficiency;
    }

    public java.time.LocalDate getDismissalDate() {
        return this.dismissalDate;
    }

    public IntegrationType getIntegrationType() {
        return integrationType;
    }

    public Instant getReceiptDate() {
        return receiptDate;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setESocialRegistration(String eSocialRegistration) {
        this.eSocialRegistration = eSocialRegistration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpfNumber(String cpfNumber) {
        this.cpfNumber = cpfNumber;
    }

    public void setNisNumber(String nisNumber) {
        this.nisNumber = nisNumber;
    }

    public void setBirthday(java.time.LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setHireDate(java.time.LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public void setMaritalStatusType(MaritalStatusType maritalStatusType) {
        this.maritalStatusType = maritalStatusType;
    }

    public void setGenderType(GenderType genderType) {
        this.genderType = genderType;
    }

    public void setSituationType(SituationType situationType) {
        this.situationType = situationType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public void setESocialCategoryType(ESocialCategoryType eSocialCategoryType) {
        this.eSocialCategoryType = eSocialCategoryType;
    }

    public void setIsDeficient(Boolean isDeficient) {
        this.isDeficient = isDeficient;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public void setCompanyBranch(CompanyBranchEntity companyBranch) {
        this.companyBranch = companyBranch;
    }

    public void setCostCenter(CostCenterEntity costCenter) {
        this.costCenter = costCenter;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    public void setJobPosition(JobPositionEntity jobPosition) {
        this.jobPosition = jobPosition;
    }

    public void setShift(ShiftEntity shift) {
        this.shift = shift;
    }

    public void setWorkstation(WorkstationEntity workstation) {
        this.workstation = workstation;
    }

    public void setDeficiency(java.util.List<DeficiencyEntity> deficiency) {
        this.deficiency = deficiency;
    }

    public void setDismissalDate(java.time.LocalDate dismissalDate) {
        this.dismissalDate = dismissalDate;
    }

    public void setIntegrationType(IntegrationType integrationType) {
        this.integrationType = integrationType;
    }

    public void setReceiptDate(Instant receiptDate) {
        this.receiptDate = receiptDate;
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
        if (!(obj instanceof EmployeeEntity)) {
            return false;
        }
        EmployeeEntity other = (EmployeeEntity) obj;
        if ((id == null) != (other.id == null)) {
            return false;
        }
        if ((id != null) && !id.equals(other.id)) { //NOSONAR
            return false;
        }
        return true;
    }

    @Override
    public String toString() { //NOSONAR
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(" [");
        sb.append("id=").append(id == null ? "null" : id).append(", ");
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
        sb.append("workstation=<").append(workstation == null ? "null" : workstation).append('>').append(", ");
        sb.append("deficiency=<").append(deficiency == null ? "null" : deficiency).append('>').append(", ");
        sb.append("dismissalDate=").append(dismissalDate == null ? "null" : dismissalDate);
        sb.append(']');
        return sb.toString();
    }

}
