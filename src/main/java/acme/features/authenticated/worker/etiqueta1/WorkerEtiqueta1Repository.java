
package acme.features.authenticated.worker.etiqueta1;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.etiqueta1.Etiqueta1;
import acme.entities.job.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface WorkerEtiqueta1Repository extends AbstractRepository {

	@Query("select d from Etiqueta1 d where d.id=?1")
	Etiqueta1 findOneById(int id);

	@Query("select d from Etiqueta1 d where d.job.id = ?1")
	Collection<Etiqueta1> findAllByJob(int idJob);

	@Query("select d from Job d where d.id=?1")
	Job findJobById(int id);

	@Query("select a from Etiqueta1 a where a.job.id =?1")
	Etiqueta1 findEtiqueta1ToThisJob(int id);

}
