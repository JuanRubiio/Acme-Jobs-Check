
package acme.features.authenticated.provider.employer.molet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.job.Job;
import acme.entities.molet.Molet;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerMoletCreateService implements AbstractCreateService<Employer, Molet> {

	@Autowired
	private EmployerMoletRepository repository;


	@Override
	public boolean authorise(final Request<Molet> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Molet> request, final Molet entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Molet> request, final Molet entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "key");
		model.setAttribute("id", entity.getJob().getId());

	}

	@Override
	public Molet instantiate(final Request<Molet> request) {
		Molet res;
		res = new Molet();
		int idJob = request.getModel().getInteger("id");
		Job job = this.repository.findJobById(idJob);
		if (job != null) {
			res.setJob(job);
		}

		return res;
	}

	@Override
	public void validate(final Request<Molet> request, final Molet entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (entity.getText().length() > 100) {
			errors.state(request, false, "text", "The text must be lower than 100 words");
		}

	}

	@Override
	public void create(final Request<Molet> request, final Molet entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
