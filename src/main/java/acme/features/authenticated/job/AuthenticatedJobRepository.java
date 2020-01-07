
package acme.features.authenticated.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.entities.job.Job;
import acme.entities.molet.Molet;
import acme.framework.repositories.AbstractRepository;

public interface AuthenticatedJobRepository extends AbstractRepository {

	@Query("select ua from Job ua where ua.active = 1")
	Collection<Job> getJobsActive();

	@Query("select ua from Job ua where ua.id = ?1")
	Job findJobById(int id);

	@Query("select a.job from Application a where a.id= ?1")
	Collection<Job> getAllJobToWorker(int id);

	@Query("select a from Molet a where a.job.id =?1")
	Molet findMoletToThisJob(int id);

}
