
package acme.features.authenticated.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.aolet.Aolet;
import acme.entities.job.Job;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedJobShowService implements AbstractShowService<Authenticated, Job> {

	@Autowired
	private AuthenticatedJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		//		boolean result;
		//		int jobId;
		//		Job job;
		//		Employer employer;
		//		Principal principal;
		//
		//		jobId = request.getModel().getInteger("id");
		//		job = this.repository.findJobById(jobId);
		//		employer = job.getEmployer();
		//		principal = request.getPrincipal();
		//
		//		result = job.getActive() || !job.getActive() && employer.getUserAccount().getId() == principal.getAccountId();

		return true;
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		int jobId = request.getModel().getInteger("id");
		Aolet e = this.repository.findAoletToThisJob(jobId);
		Boolean b = false;
		if (e == null) {
			b = true;
		} else {
			b = false;
		}

		request.unbind(entity, model, "title", "deadline", "reference", "status", "salary", "link", "description", "active");
		model.setAttribute("ayuda", b);

	}

	@Override
	public Job findOne(final Request<Job> request) {
		assert request != null;

		int jobId;
		Job job;

		jobId = request.getModel().getInteger("id");
		job = this.repository.findJobById(jobId);
		return job;
	}

}
