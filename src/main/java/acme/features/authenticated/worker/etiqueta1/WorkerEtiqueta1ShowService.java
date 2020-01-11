
package acme.features.authenticated.worker.etiqueta1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.aolet.Aolet;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class WorkerEtiqueta1ShowService implements AbstractShowService<Worker, Aolet> {

	@Autowired
	WorkerEtiqueta1Repository repository;


	@Override
	public boolean authorise(final Request<Aolet> request) {
		assert request != null;

		return true;
	}
	@Override
	public void unbind(final Request<Aolet> request, final Aolet entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "badge");
	}
	@Override
	public Aolet findOne(final Request<Aolet> request) {
		assert request != null;

		Aolet result;
		int id;

		String[] aux = request.getServletRequest().getQueryString().trim().split("=");
		id = Integer.parseInt(aux[1]);

		result = this.repository.findEtiqueta1ToThisJob(id);

		return result;
	}
}
