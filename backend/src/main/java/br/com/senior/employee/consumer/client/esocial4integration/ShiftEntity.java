/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.employee.consumer.client.esocial4integration;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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
		sb.append("dateWhen=").append(dateWhen == null ? "null" : dateWhen);
		sb.append(']');
		return sb.toString();
	}
	
}
