
package acme.features.authenticated.worker.application;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

		entity.setContieneMolet(true);
		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		entity.setContieneMolet(true);
		request.unbind(entity, model, "referenceNumber", "moment", "status", "statement", "skills", "qualifications", "messageRejected", "worker", "answerWorker", "keyPass");
		entity.setContieneMolet(true);
	}

	@Override
	public Application findOne(final Request<Application> request) {
		assert request != null;

		Application result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		result.setContieneMolet(true);
		return result;
	}

	@Override
	public void validate(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		int MIN_CARACTERES = 10;
		int MIN_LETRAS = 1;
		int MIN_DIGITOS = 1;
		int MIN_SIMBOLOS = 1;

		int tot_digitos = 0;
		int tot_letras = 0;
		int tot_caracteres = 0;
		int tot_simbolos = 0;

		List<String> list = Arrays.asList(",", ".", "'", ":", "-", "!", "¡", "?", "¿", "(", ")", ";");

		if (entity.getKeyPass().length() != 0) {
			for (int i = 0; i < entity.getKeyPass().length(); i++) {
				char a = entity.getKeyPass().charAt(i);

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
				errors.state(request, false, "key", "worker.application.confirmationPass");
				entity.setContieneMolet(true);
			}
		}
	}

	@Override
	public void update(final Request<Application> request, final Application entity) {
		assert request != null;
		assert entity != null;

		entity.setContieneMolet(true);
		this.repository.save(entity);
	}

}
