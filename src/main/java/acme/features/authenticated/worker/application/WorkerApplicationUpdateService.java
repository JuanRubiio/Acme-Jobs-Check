
package acme.features.authenticated.worker.application;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.aolet.Aolet;
import acme.entities.applications.Application;
import acme.entities.roles.Worker;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractUpdateService;

@Service
public class WorkerApplicationUpdateService implements AbstractUpdateService<Worker, Application> {

	@Autowired
	WorkerApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		boolean result;
		int appId;
		Application app;
		Worker apwor;
		Principal principal;

		appId = request.getModel().getInteger("id");
		app = this.repository.findOneById(appId);
		apwor = app.getWorker();
		principal = request.getPrincipal();

		result = apwor.getUserAccount().getId() == principal.getAccountId();
		return result;
	}

	@Override
	public void bind(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		Aolet result;
		int id;
		Boolean b = false;
		id = entity.getJob().getId();
		String value = "";

		result = this.repository.findEtiqueta1ToThisJob(id);
		if (StringUtils.isNotBlank(result.getBadge())) {
			value = result.getBadge();
			b = true;
		}

		request.unbind(entity, model, "referenceNumber", "moment", "status", "statement", "skills", "qualifications", "messageRejected", "worker", "answerWorker", "confirmation", "cc");
		model.setAttribute("badger", value);
		model.setAttribute("conf", b);
	}

	@Override
	public Application findOne(final Request<Application> request) {
		assert request != null;

		Application result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

	@Override
	public void validate(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		//		Pattern pattern;
		//		pattern = Pattern.compile("^(?=.*[A-Za-z]){5,}(?=.*\\d){2,}(?=.*[,.;:¿\\(\\)\\[\\]\\\"\\-_¨\\/&]){1,}[A-Za-z\\d,.;:¿\\(\\)\\[\\]\\\"\\-_¨\\/&]{8,}$");
		//
		//		if (StringUtils.isNotBlank(entity.getConfirmation()) && !pattern.matcher(entity.getConfirmation()).matches()) {
		//			errors.state(request, false, "confirmation", "worker.application.confirmationPass");
		//		}

		if (StringUtils.isNotBlank(entity.getCc()) && StringUtils.isNotBlank(entity.getConfirmation()) && !entity.getCc().equals(entity.getConfirmation())) {
			errors.state(request, false, "confirmation", "authenticated.employer.application.form.badPassword");

		}

	}

	@Override
	public void update(final Request<Application> request, final Application entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
