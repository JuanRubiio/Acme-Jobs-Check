
package acme.features.authenticated.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedRequestShowService implements AbstractShowService<Authenticated, acme.entities.request.Request> {

	@Autowired
	AuthenticatedRequestRepository repository;


	@Override
	public boolean authorise(final Request<acme.entities.request.Request> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<acme.entities.request.Request> request, final acme.entities.request.Request entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "moment", "deadline", "text", "ticker", "reward");

	}

	@Override
	public acme.entities.request.Request findOne(final Request<acme.entities.request.Request> request) {
		assert request != null;

		acme.entities.request.Request result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

}
