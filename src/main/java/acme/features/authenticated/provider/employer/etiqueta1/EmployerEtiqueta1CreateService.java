
package acme.features.authenticated.provider.employer.etiqueta1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.etiqueta1.Etiqueta1;
import acme.entities.job.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerEtiqueta1CreateService implements AbstractCreateService<Employer, Etiqueta1> {

	@Autowired
	private EmployerEtiqueta1Repository repository;


	@Override
	public boolean authorise(final Request<Etiqueta1> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Etiqueta1> request, final Etiqueta1 entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Etiqueta1> request, final Etiqueta1 entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "atributoEtiqueta1");
		model.setAttribute("id", entity.getJob().getId());

	}

	@Override
	public Etiqueta1 instantiate(final Request<Etiqueta1> request) {
		Etiqueta1 res;
		res = new Etiqueta1();
		int idJob = request.getModel().getInteger("id");
		Job job = this.repository.findJobById(idJob);
		if (job != null) {
			res.setJob(job);
		}

		return res;
	}

	@Override
	public void validate(final Request<Etiqueta1> request, final Etiqueta1 entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (entity.getText().length() > 100) {
			errors.state(request, false, "text", "The text must be lower than 100 words");
		}

	}

	@Override
	public void create(final Request<Etiqueta1> request, final Etiqueta1 entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
