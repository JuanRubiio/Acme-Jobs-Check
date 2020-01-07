
package acme.features.authenticated.provider.employer.job;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.duty.Duty;
import acme.entities.job.Job;
import acme.entities.molet.Molet;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractDeleteService;

@Service
public class EmployerJobDeleteService implements AbstractDeleteService<Employer, Job> {

	@Autowired
	EmployerJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		boolean result;
		int jobId;
		Job job;
		Employer employer;
		Principal principal;

		jobId = request.getModel().getInteger("id");
		job = this.repository.findJobById(jobId);
		employer = job.getEmployer();
		principal = request.getPrincipal();

		result = employer.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void bind(final Request<Job> request, final Job entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "reference", "status", "salary", "link", "description", "active", "ayuda");

	}

	@Override
	public Job findOne(final Request<Job> request) {
		assert request != null;

		Job result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findJobById(id);
		return result;
	}

	@Override
	public void validate(final Request<Job> request, final Job entity, final Errors errors) {

		assert request != null;
		assert entity != null;
		assert errors != null;

		List<Application> apps = this.repository.findAllApplicationToThisJob(entity.getId());
		if (apps != null && !apps.isEmpty()) {
			errors.state(request, false, "title", "employer.job.applications");

		}
		int idJob = entity.getId();
		Collection<Duty> duties = this.repository.findAllDutiesToThisJob(idJob);
		if (duties != null && !duties.isEmpty()) {
			errors.state(request, false, "title", "employer.job.duties.delete");

		}
		Molet e = this.repository.findMoletToThisJob(entity.getId());
		if (e != null) {
			errors.state(request, false, "title", "employer.job.molet.delete");

		}
	}

	@Override
	public void delete(final Request<Job> request, final Job entity) {

		assert request != null;
		assert entity != null;

		this.repository.delete(entity);
	}

}
