
package acme.features.authenticated.worker.molet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.molet.Molet;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class WorkerMoletShowService implements AbstractShowService<Worker, Molet> {

	@Autowired
	WorkerMoletRepository repository;


	@Override
	public boolean authorise(final Request<Molet> request) {
		assert request != null;

		return true;
	}
	@Override
	public void unbind(final Request<Molet> request, final Molet entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "_key");
	}
	@Override
	public Molet findOne(final Request<Molet> request) {
		assert request != null;

		Molet result;
		int id;

		String[] aux = request.getServletRequest().getQueryString().trim().split("=");
		id = Integer.parseInt(aux[1]);

		result = this.repository.findMoletToThisJob(id);

		return result;
	}
}
