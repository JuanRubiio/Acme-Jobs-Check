
package acme.features.authenticated.provider.employer.molet;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.job.Job;
import acme.entities.molet.Molet;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerMoletRepository extends AbstractRepository {

	@Query("select d from Molet d where d.id=?1")
	Molet findOneById(int id);

	@Query("select d from Molet d where d.job.id = ?1")
	Collection<Molet> findAllByJob(int idJob);

	@Query("select d from Job d where d.id=?1")
	Job findJobById(int id);

	@Query("select a from Molet a where a.job.id =?1")
	Molet findMoletToThisJob(int id);

}
