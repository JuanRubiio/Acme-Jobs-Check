
package acme.entities.etiqueta1;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.job.Job;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Etiqueta1 extends DomainEntity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= -4647622525675794079L;

	//MAX=XXXX de momento he puesto 100 por poner un número
	@NotBlank
	@Length(min = 1, max = 100)
	private String				text;

	@URL
	private String				atributoEtiqueta1;

	@NotNull
	@Valid
	@OneToOne(optional = false)
	private Job					job;

}
