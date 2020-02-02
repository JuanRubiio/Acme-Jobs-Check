
package acme.features.authenticated.worker.application;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.job.Job;
import acme.entities.roles.Worker;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class WorkerApplicationCreateService implements AbstractCreateService<Worker, Application> {

	@Autowired
	WorkerApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		boolean result;
		int Idnuevo;
		List<Integer> idAppFM;

		Idnuevo = request.getModel().getInteger("id");
		idAppFM = this.repository.findIdJobsActive();
		if (idAppFM.contains(Idnuevo)) {
			result = true;
		} else {
			result = false;
		}

		return result;
	}

	@Override
	public void validate(final Request<Application> request, final Application entity, final Errors errors) {

		assert request != null;
		assert entity != null;
		assert errors != null;

		boolean isDuplicated = false;

		isDuplicated = this.repository.findByReference(entity.getReferenceNumber()) != null;
		errors.state(request, !isDuplicated, "referenceNumber", "worker.application.duplicatedReference");

	}

	@Override
	public void bind(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment", "status", "messageRejected", "lastUpdate", "answerWorker", "confirmation");
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "referenceNumber", "statement", "skills", "qualifications");
		model.setAttribute("id", entity.getJob().getId());
	}

	@Override
	public Application instantiate(final Request<Application> request) {
		assert request != null;

		Application res = new Application();
		int userAccountId = request.getPrincipal().getAccountId();
		Worker worker = this.repository.findWorker(userAccountId);

		Job j = this.repository.findJobById(request.getModel().getInteger("id"));
		res.setJob(j);
		res.setWorker(worker);

		String status = "Pending";
		res.setStatus(status);
		String messageRejected = "";
		res.setMessageRejected(messageRejected);
		String answerWorker = "";
		res.setAnswerWorker(answerWorker);
		String confirmation = "";
		res.setConfirmation(confirmation);
		res.setAolet(false);
		return res;

	}

	@Override
	public void create(final Request<Application> request, final Application entity) {
		assert request != null;
		assert entity != null;

		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		entity.setLastUpdate(moment);

		this.repository.save(entity);
	}

}
