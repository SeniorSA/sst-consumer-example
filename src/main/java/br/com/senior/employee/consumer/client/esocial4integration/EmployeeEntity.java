package br.com.senior.employee.consumer.client.esocial4integration;

import java.util.ArrayList;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

    /**
     * Id interno do colaborador.
     */
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false)
    private java.util.UUID id;

    /**
     * Id externo do colaborador (no Payroll).
     */
    @Column(name = "external_id", length = 36)
    private String externalId;

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
    @Column(name = "e_social_registration", length = 30)
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
    @Column(name = "nis_number", length = 11)
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
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "e_social_category")
    private ESocialCategoryEntity eSocialCategory;

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
     * Motivo do afastamento.
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "reason_leave")
    private ReasonLeaveEntity reasonLeave;

    /**
     * Deficiência do colaborador.
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = CascadeType.ALL)
    private java.util.List<DeficiencyEntity> deficiencies = new ArrayList<>();

    /**
     * Data de demissão.
     */
    @Column(name = "dismissal_date")
    private java.time.LocalDate dismissalDate;

    /**
     * Número da carteira de trabalho
     */
    @Column(name = "ctps_number")
    private String ctpsNumber;

    /**
     * Série da carteira de trabalho
     */
    @Column(name = "ctps_serie", length = 5)
    private String ctpsSerie;

    /**
     * Data de emissão da carteira de trabalho
     */
    @Column(name = "ctps_issuance_date")
    private java.time.LocalDate ctpsIssuanceDate;

    /**
     * Digito da carteira de trabalho
     */
    @Column(name = "ctps_serie_digit", length = 5)
    private String ctpsSerieDigit;

    /**
     * Estado da carteira de trabalho
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "ctps_state")
    private State ctpsState;

    /**
     * Carteira de identidade
     */
    @Column(name = "rg_number")
    private String rgNumber;

    /**
     * Orgão emissor da carteira de identidade
     */
    @Column(name = "rg_issuer")
    private String rgIssuer;

    /**
     * Estado da carteira de identidade
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "rg_state")
    private State rgState;

    /**
     * Data de emissão da carteira de identidade
     */
    @Column(name = "rg_issuance_date")
    private java.time.LocalDate rgIssuanceDate;

    public java.util.UUID getId() {
        return this.id;
    }

    public String getExternalId() {
        return this.externalId;
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

    public ESocialCategoryEntity getESocialCategory() {
        return this.eSocialCategory;
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

    public ReasonLeaveEntity getReasonLeave() {
        return reasonLeave;
    }

    public java.util.List<DeficiencyEntity> getDeficiencies() {
        return this.deficiencies;
    }

    public java.time.LocalDate getDismissalDate() {
        return this.dismissalDate;
    }

    public String getCtpsNumber() {
        return ctpsNumber;
    }

    public String getCtpsSerie() {
        return ctpsSerie;
    }

    public java.time.LocalDate getCtpsIssuanceDate() {
        return ctpsIssuanceDate;
    }

    public String getCtpsSerieDigit() {
        return ctpsSerieDigit;
    }

    public State getCtpsState() {
        return ctpsState;
    }

    public String getRgNumber() {
        return rgNumber;
    }

    public String getRgIssuer() {
        return rgIssuer;
    }

    public State getRgState() {
        return rgState;
    }

    public java.time.LocalDate getRgIssuanceDate() {
        return rgIssuanceDate;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
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

    public void setESocialCategory(ESocialCategoryEntity eSocialCategory) {
        this.eSocialCategory = eSocialCategory;
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

    public void setReasonLeave(ReasonLeaveEntity reasonLeave) {
        this.reasonLeave = reasonLeave;
    }

    public void setDeficiencies(java.util.List<DeficiencyEntity> deficiencies) {
        this.deficiencies = deficiencies;
    }

    public void setDismissalDate(java.time.LocalDate dismissalDate) {
        this.dismissalDate = dismissalDate;
    }

    public void setCtpsNumber(String ctpsNumber) {
        this.ctpsNumber = ctpsNumber;
    }

    public void setCtpsSerie(String ctpsSerie) {
        this.ctpsSerie = ctpsSerie;
    }

    public void setCtpsIssuanceDate(java.time.LocalDate ctpsIssuanceDate) {
        this.ctpsIssuanceDate = ctpsIssuanceDate;
    }

    public void setCtpsSerieDigit(String ctpsSerieDigit) {
        this.ctpsSerieDigit = ctpsSerieDigit;
    }

    public void setCtpsState(State ctpsState) {
        this.ctpsState = ctpsState;
    }

    public void setRgNumber(String rgNumber) {
        this.rgNumber = rgNumber;
    }

    public void setRgIssuer(String rgIssuer) {
        this.rgIssuer = rgIssuer;
    }

    public void setRgState(State rgState) {
        this.rgState = rgState;
    }

    public void setRgIssuanceDate(java.time.LocalDate rgIssuanceDate) {
        this.rgIssuanceDate = rgIssuanceDate;
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
        sb.append("dismissalDate=").append(dismissalDate == null ? "null" : dismissalDate);
        sb.append("ctpsNumber=").append(ctpsNumber == null ? "null" : ctpsNumber).append(", ");
        sb.append("ctpsSerie=").append(ctpsSerie == null ? "null" : ctpsSerie).append(", ");
        sb.append("ctpsIssuanceDate=").append(ctpsIssuanceDate == null ? "null" : ctpsIssuanceDate).append(", ");
        sb.append("ctpsSerieDigit=").append(ctpsSerieDigit == null ? "null" : ctpsSerieDigit).append(", ");
        sb.append("ctpsState=").append(ctpsState == null ? "null" : ctpsState).append(", ");
        sb.append("rgNumber=").append(rgNumber == null ? "null" : rgNumber).append(", ");
        sb.append("rgIssuer=").append(rgIssuer == null ? "null" : rgIssuer).append(", ");
        sb.append("rgState=").append(rgState == null ? "null" : rgState).append(", ");
        sb.append("rgIssuanceDate=").append(rgIssuanceDate == null ? "null" : rgIssuanceDate);
        sb.append(']');
        return sb.toString();
    }

}
