/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.employee.consumer.entity;

import br.com.senior.employee.consumer.pojos.common.DeficiencyType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="deficiency")
public class DeficiencyEntity {
	
	/**
	 * Id interno da entidade.
	 */
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id", updatable = false)
	private java.util.UUID id;
	
	/**
	 * Código da deficiência.
	 */
	@Column(name = "code")
	private Long code;
	
	/**
	 * Nome da deficiência.
	 */
	@Column(name = "name")
	private String name;
	
	/**
	 * É a deficiência principal?
	 */
	@Column(name = "is_main_deficiency")
	private Boolean isMainDeficiency;
	
	/**
	 * Tipo da deficiência no e-Social.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "deficiency_type")
	private DeficiencyType deficiencyType;
	
	/**
	 * Data de início da deficiência.
	 */
	@Column(name = "date_when")
	private java.time.LocalDate dateWhen;
	
	/**
	 * Reabilitado.
	 */
	@Column(name = "is_rehabilitated")
	private Boolean isRehabilitated;
	
	public java.util.UUID getId() {
		return this.id;
	}
	
	public Long getCode() {
		return this.code;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Boolean getIsMainDeficiency() {
		return this.isMainDeficiency;
	}
	
	public DeficiencyType getDeficiencyType() {
		return this.deficiencyType;
	}
	
	public java.time.LocalDate getDateWhen() {
		return this.dateWhen;
	}
	
	public Boolean getIsRehabilitated() {
		return this.isRehabilitated;
	}
	
	public void setId(java.util.UUID id) {
		this.id = id;
	}
	
	public void setCode(Long code) {
		this.code = code;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setIsMainDeficiency(Boolean isMainDeficiency) {
		this.isMainDeficiency = isMainDeficiency;
	}
	
	public void setDeficiencyType(DeficiencyType deficiencyType) {
		this.deficiencyType = deficiencyType;
	}
	
	public void setDateWhen(java.time.LocalDate dateWhen) {
		this.dateWhen = dateWhen;
	}
	
	public void setIsRehabilitated(Boolean isRehabilitated) {
		this.isRehabilitated = isRehabilitated;
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
	    if (!(obj instanceof DeficiencyEntity)) {
	        return false;
	    }
	    DeficiencyEntity other = (DeficiencyEntity) obj;
	    if ((id == null) != (other.id == null)) {
	        return false;
	    }
	    if ((id != null) && !id.equals(other.id)) { //NOSONAR
	        return false;
	    }
	    return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName()).append(" [");
		sb.append("id=").append(id == null ? "null" : id).append(", ");
		sb.append("code=").append(code == null ? "null" : code).append(", ");
		sb.append("name=").append(name == null ? "null" : name).append(", ");
		sb.append("isMainDeficiency=").append(isMainDeficiency == null ? "null" : isMainDeficiency).append(", ");
		sb.append("deficiencyType=").append(deficiencyType == null ? "null" : deficiencyType).append(", ");
		sb.append("dateWhen=").append(dateWhen == null ? "null" : dateWhen).append(", ");
		sb.append("isRehabilitated=").append(isRehabilitated == null ? "null" : isRehabilitated);
		sb.append(']');
		return sb.toString();
	}
	
}
