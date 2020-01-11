
package acme.features.authenticated.worker.etiqueta1;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.aolet.Aolet;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class WorkerEtiqueta1ListService implements AbstractListService<Worker, Aolet> {

	@Autowired
	private WorkerEtiqueta1Repository repository;


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
	public Collection<Aolet> findMany(final Request<Aolet> request) {
		assert request != null;
		Collection<Aolet> result;

		int id;

		String[] aux = request.getServletRequest().getQueryString().trim().split("=");
		request.getServletRequest().getQueryString();
		id = Integer.parseInt(aux[1]);

		result = this.repository.findAllByJob(id);

		return result;
	}

}
