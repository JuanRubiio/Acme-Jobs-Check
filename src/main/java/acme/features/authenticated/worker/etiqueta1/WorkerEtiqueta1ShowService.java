
package acme.features.authenticated.worker.etiqueta1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.etiqueta1.Etiqueta1;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class WorkerEtiqueta1ShowService implements AbstractShowService<Worker, Etiqueta1> {

	@Autowired
	WorkerEtiqueta1Repository repository;


	@Override
	public boolean authorise(final Request<Etiqueta1> request) {
		assert request != null;

		return true;
	}
	@Override
	public void unbind(final Request<Etiqueta1> request, final Etiqueta1 entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "atributoEtiqueta1");
	}
	@Override
	public Etiqueta1 findOne(final Request<Etiqueta1> request) {
		assert request != null;

		Etiqueta1 result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}
}
