
package acme.features.authenticated.provider.employer.application;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.aolet.Aolet;
import acme.entities.applications.Application;
import acme.entities.job.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.components.Response;
import acme.framework.entities.Principal;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractUpdateService;

@Service
public class EmployerApplicationUpdateService implements AbstractUpdateService<Employer, Application> {

	@Autowired
	EmployerApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		boolean result;
		int appId;
		Application app;
		Job job;
		Employer employer;
		Principal principal;

		appId = request.getModel().getInteger("id");
		app = this.repository.findOneById(appId);
		job = app.getJob();
		employer = job.getEmployer();
		principal = request.getPrincipal();

		result = employer.getUserAccount().getId() == principal.getAccountId();
		return result;
	}

	@Override
	public void bind(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment");
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

		String sr = "Rejected";

		if (entity.getStatus().contains(sr) && entity.getMessageRejected() == "") {
			errors.state(request, false, "messageRejected", "authenticated.employer.application.form.label.justification");
		}

		int MIN_CARACTERES = 10;
		int MIN_LETRAS = 1;
		int MIN_DIGITOS = 1;
		int MIN_SIMBOLOS = 1;

		int tot_digitos = 0;
		int tot_letras = 0;
		int tot_caracteres = 0;
		int tot_simbolos = 0;

		List<String> list = Arrays.asList(",", ".", "'", ":", "-", "!", "¡", "?", "¿", "(", ")", ";");
		if (entity.getCc().length() != 0) {
			for (int i = 0; i < entity.getCc().length(); i++) {
				char a = entity.getCc().charAt(i);

				if (Character.isDigit(a)) {
					tot_digitos++;
					tot_caracteres++;
				}
				if (Character.isLetter(a)) {
					tot_letras++;
					tot_caracteres++;
				}
				for (String symbol : list) {
					String s = Character.toString(a);
					if (symbol.equals(s)) {
						tot_simbolos++;
						tot_caracteres++;
					}
				}

			}

			if (tot_caracteres < MIN_CARACTERES || tot_letras < MIN_LETRAS || tot_digitos < MIN_DIGITOS || tot_simbolos < MIN_SIMBOLOS) {
				errors.state(request, false, "cc", "worker.application.confirmationPass");
			}
		}

	}

	@Override
	public void update(final Request<Application> request, final Application entity) {

		assert request != null;
		assert entity != null;
		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setLastUpdate(moment);

		this.repository.save(entity);
	}

	@Override
	public void onSuccess(final Request<Application> request, final Response<Application> response) {
		assert request != null;
		assert response != null;

		if (request.isMethod(HttpMethod.POST)) {
			PrincipalHelper.handleUpdate();
		}

	}

}
