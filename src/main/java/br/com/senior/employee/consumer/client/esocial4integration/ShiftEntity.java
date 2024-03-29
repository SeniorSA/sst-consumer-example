/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.employee.consumer.client.esocial4integration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="shift")
public class ShiftEntity {
	
	/**
	 * Id interno da entidade.
	 */
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id", updatable = false)
	private java.util.UUID id;
	
	/**
	 * Código do turno.
	 */
	@Column(name = "code")
	private Long code;
	
	/**
	 * Nome do turno.
	 */
	@Column(name = "name")
	private String name;
	
	/**
	 * Data do histórico da Turno (A partir de).
	 */
	@Column(name = "date_when")
	private java.time.LocalDate dateWhen;

	/**
	 * Turno da escala
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "workshift_scale_type")
	private WorkshiftScaleType workshiftScaleType;
	
	public java.util.UUID getId() {
		return this.id;
	}
	
	public Long getCode() {
		return this.code;
	}
	
	public String getName() {
		return this.name;
	}
	
	public java.time.LocalDate getDateWhen() {
		return this.dateWhen;
	}

	public WorkshiftScaleType getWorkshiftScaleType() {
		return workshiftScaleType;
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
	
	public void setDateWhen(java.time.LocalDate dateWhen) {
		this.dateWhen = dateWhen;
	}

	public void setWorkshiftScaleType(WorkshiftScaleType workshiftScaleType) {
		this.workshiftScaleType = workshiftScaleType;
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
	    if (!(obj instanceof ShiftEntity)) {
	        return false;
	    }
	    ShiftEntity other = (ShiftEntity) obj;
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
		sb.append("dateWhen=").append(dateWhen == null ? "null" : dateWhen).append(", ");
		sb.append("workshiftScaleType=").append(workshiftScaleType == null ? "null" : workshiftScaleType);
		sb.append(']');
		return sb.toString();
	}
	
}
