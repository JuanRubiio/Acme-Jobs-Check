
package acme.features.authenticated.provider.employer.molet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.job.Job;
import acme.entities.molet.Molet;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractUpdateService;

@Service
public class EmployerMoletUpdateService implements AbstractUpdateService<Employer, Molet> {

	@Autowired
	EmployerMoletRepository repository;


	@Override
	public boolean authorise(final Request<Molet> request) {
		assert request != null;
		boolean result;
		int jobId;
		Molet et1;
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

		request.unbind(entity, model, "text", "_key");

	}

	@Override
	public Molet findOne(final Request<Molet> request) {
		assert request != null;

		Molet result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

	@Override
	public void validate(final Request<Molet> request, final Molet entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void update(final Request<Molet> request, final Molet entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
