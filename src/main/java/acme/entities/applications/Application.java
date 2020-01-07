
package acme.entities.applications;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import acme.entities.job.Job;
import acme.entities.roles.Worker;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
	@Index(columnList = "referenceNumber"), @Index(columnList = "moment"), @Index(columnList = "status")
})
public class Application extends DomainEntity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 4364563924515790536L;

	@Column(unique = true)
	@NotBlank
	@Length(min = 5, max = 15)
	private String				referenceNumber;

	@Temporal(TemporalType.TIMESTAMP)
	private Date				moment;

	@NotBlank
	private String				status;

	@NotBlank
	private String				statement;

	@NotBlank
	private String				skills;

	@NotBlank
	private String				qualifications;

	private String				messageRejected;

	@Temporal(TemporalType.TIMESTAMP)
	private Date				lastUpdate;

	//CHECK

	private String				answerWorker;

	private String				key;

	private String				cc;

	//------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Worker				worker;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Job					job;

}
