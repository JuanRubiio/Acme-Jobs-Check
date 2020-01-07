
package acme.features.authenticated.provider.employer.molet;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.molet.Molet;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class EmployerMoletListService implements AbstractListService<Employer, Molet> {

	@Autowired
	private EmployerMoletRepository repository;


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

		request.unbind(entity, model, "text", "key");
	}

	@Override
	public Collection<Molet> findMany(final Request<Molet> request) {
		assert request != null;
		Collection<Molet> result;

		int id;

		String[] aux = request.getServletRequest().getQueryString().trim().split("=");
		id = Integer.parseInt(aux[1]);

		result = this.repository.findAllByJob(id);

		return result;
	}

}
