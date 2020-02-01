
package acme.features.authenticated.provider.employer.aolet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.aolet.Aolet;
import acme.entities.job.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractUpdateService;

@Service
public class EmployerAoletUpdateService implements AbstractUpdateService<Employer, Aolet> {

	@Autowired
	EmployerAoletRepository repository;


	@Override
	public boolean authorise(final Request<Aolet> request) {
		assert request != null;
		boolean result;
		int jobId;
		Aolet et1;
		Job job;
		Principal principal;
		Employer employer;

		jobId = request.getModel().getInteger("id");
		et1 = this.repository.findOneById(jobId);
		job = et1.getJob();
		employer = job.getEmployer();
		principal = request.getPrincipal();

		result = employer.getUserAccount().getId() == principal.getAccountId();

		return result;
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

	}

	@Override
	public Aolet findOne(final Request<Aolet> request) {
		assert request != null;

		Aolet result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
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
	public void update(final Request<Aolet> request, final Aolet entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
