
package acme.features.authenticated.provider.employer.etiqueta1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.etiqueta1.Etiqueta1;
import acme.entities.job.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractDeleteService;

@Service
public class EmployerEtiqueta1DeleteService implements AbstractDeleteService<Employer, Etiqueta1> {

	@Autowired
	EmployerEtiqueta1Repository repository;


	@Override
	public boolean authorise(final Request<Etiqueta1> request) {
		assert request != null;
		boolean result;
		int jobId;
		Etiqueta1 et1;
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

	}

	@Override
	public Etiqueta1 findOne(final Request<Etiqueta1> request) {
		assert request != null;

		Etiqueta1 result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

	@Override
	public void validate(final Request<Etiqueta1> request, final Etiqueta1 entity, final Errors errors) {

		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void delete(final Request<Etiqueta1> request, final Etiqueta1 entity) {

		assert request != null;
		assert entity != null;

		this.repository.delete(entity);
	}

}
