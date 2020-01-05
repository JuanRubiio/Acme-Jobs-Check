
package acme.features.authenticated.worker.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.etiqueta1.Etiqueta1;
import acme.entities.job.Job;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class WorkerJobShowService implements AbstractShowService<Worker, Job> {

	@Autowired
	private WorkerJobRepository repository;


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
		Etiqueta1 e = this.repository.findEtiqueta1ToThisJob(jobId);
		if (e == null) {
			entity.setAyuda(true);
		} else {
			entity.setAyuda(false);
		}

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

	//	@Override
	//	public Job findOne(final Request<Job> request) {
	//		assert request != null;
	//
	//		int id;
	//		Job job;
	//		String[] aux = request.getServletRequest().getQueryString().trim().split("=");
	//		request.getServletRequest().getQueryString();
	//		id = Integer.parseInt(aux[1]);
	//		job = this.repository.getOneJobToApplication(id);
	//		return job;
	//	}

}
