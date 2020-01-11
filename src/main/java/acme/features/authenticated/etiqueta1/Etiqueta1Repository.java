
package acme.features.authenticated.etiqueta1;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.aolet.Aolet;
import acme.entities.job.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface Etiqueta1Repository extends AbstractRepository {

	@Query("select d from Aolet d where d.id=?1")
	Aolet findOneById(int id);

	@Query("select d from Aolet d where d.job.id = ?1")
	Collection<Aolet> findAllByJob(int idJob);

	@Query("select d from Job d where d.id=?1")
	Job findJobById(int id);

	@Query("select a from Aolet a where a.job.id =?1")
	Aolet findEtiqueta1ToThisJob(int id);

}
