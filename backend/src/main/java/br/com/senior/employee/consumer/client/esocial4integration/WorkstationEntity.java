/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.employee.consumer.client.esocial4integration;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name="workstation")
public class WorkstationEntity {
	
	public static final String SECURITY_RESOURCE = "res://senior.com.br/hcm/esocial4integration/entities/workstation";

	/**
	 * Id interno da entidade.
	 */
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id", updatable = false)
	private java.util.UUID id;
	
	/**
	 * Código do posto de trabalho.
	 */
	@Column(name = "code")
	private String code;
	
	/**
	 * Estrutura do posto de trabalho.
	 */
	@Column(name = "structure_code")
	private Long structureCode;
	
	/**
	 * Nome do posto de trabalho.
	 */
	@Column(name = "name")
	private String name;
	
	/**
	 * Data do histórico do posto de trabalho (A partir de).
	 */
	@Column(name = "date_when")
	private java.time.LocalDate dateWhen;
	
	public java.util.UUID getId() {
		return this.id;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public Long getStructureCode() {
		return this.structureCode;
	}
	
	public String getName() {
		return this.name;
	}
	
	public java.time.LocalDate getDateWhen() {
		return this.dateWhen;
	}
	
	public void setId(java.util.UUID id) {
		this.id = id;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public void setStructureCode(Long structureCode) {
		this.structureCode = structureCode;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDateWhen(java.time.LocalDate dateWhen) {
		this.dateWhen = dateWhen;
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
	    if (!(obj instanceof WorkstationEntity)) {
	        return false;
	    }
	    WorkstationEntity other = (WorkstationEntity) obj;
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
		sb.append("code=").append(code == null ? "null" : code).append(", ");
		sb.append("structureCode=").append(structureCode == null ? "null" : structureCode).append(", ");
		sb.append("name=").append(name == null ? "null" : name).append(", ");
		sb.append("dateWhen=").append(dateWhen == null ? "null" : dateWhen);
		sb.append(']');
		return sb.toString();
	}
	
}
