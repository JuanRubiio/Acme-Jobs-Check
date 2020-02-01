
package acme.features.authenticated.provider.employer.job;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import acme.entities.aolet.Aolet;
import acme.entities.applications.Application;
import acme.entities.customisationParameters.CustomisationParameters;
import acme.entities.duty.Duty;
import acme.entities.job.Job;
import acme.entities.roles.Employer;
import acme.framework.repositories.AbstractRepository;

public interface EmployerJobRepository extends AbstractRepository {

	@Query("select ua from Job ua where ua.employer.id = ?1")
	Collection<Job> getJobsByEmployerId(int id);

	@Query("select ua from Job ua where ua.id = ?1")
	Job findJobById(int id);

	@Query("select ua from Employer ua where ua.userAccount.id = ?1")
	Employer findEmployerById(int id);

	@Query("select ua from Job ua where ua.reference = ?1")
	Job findByReference(String reference);

	@Query("select ua from CustomisationParameters ua")
	CustomisationParameters findCustomParameters();

	@Query("select a from Application a where a.job.id =?1")
	List<Application> findAllApplicationToThisJob(int id);

	@Query("select a from Duty a where a.job.id =?1")
	List<Duty> findAllDutiesToThisJob(int id);

	@Query("select a from Aolet a where a.job.id =?1")
	Aolet findAoletToThisJob(int id);
}
