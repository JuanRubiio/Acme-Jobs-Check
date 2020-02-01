
package acme.features.authenticated.provider.employer.aolet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.aolet.Aolet;
import acme.entities.job.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerAoletCreateService implements AbstractCreateService<Employer, Aolet> {

	@Autowired
	private EmployerAoletRepository repository;


	@Override
	public boolean authorise(final Request<Aolet> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Aolet> request, final Aolet entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Aolet> request, final Aolet entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "badge");
		model.setAttribute("id", entity.getJob().getId());

	}

	@Override
	public Aolet instantiate(final Request<Aolet> request) {
		Aolet res;
		res = new Aolet();
		int idJob = request.getModel().getInteger("id");
		Job job = this.repository.findJobById(idJob);
		if (job != null) {
			res.setJob(job);
		}

		return res;
	}

	@Override
	public void validate(final Request<Aolet> request, final Aolet entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (entity.getText().length() > 256) {
			errors.state(request, false, "text", "authenticated.employer.aolet.error");
		}

	}

	@Override
	public void create(final Request<Aolet> request, final Aolet entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
