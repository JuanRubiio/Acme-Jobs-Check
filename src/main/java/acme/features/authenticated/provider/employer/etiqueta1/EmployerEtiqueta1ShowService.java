
package acme.features.authenticated.provider.employer.etiqueta1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.etiqueta1.Etiqueta1;
import acme.entities.job.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EmployerEtiqueta1ShowService implements AbstractShowService<Employer, Etiqueta1> {

	@Autowired
	EmployerEtiqueta1Repository repository;


	@Override
	public boolean authorise(final Request<Etiqueta1> request) {
		assert request != null;
		boolean result;
		int id;
		Etiqueta1 et1;
		Job job;
		Principal principal;
		Employer employer;

		String[] aux = request.getServletRequest().getQueryString().trim().split("=");
		id = Integer.parseInt(aux[1]);
		et1 = this.repository.findEtiqueta1ToThisJob(id);
		job = et1.getJob();
		employer = job.getEmployer();
		principal = request.getPrincipal();

		result = employer.getUserAccount().getId() == principal.getAccountId();

		return result;
	}
	@Override
	public void unbind(final Request<Etiqueta1> request, final Etiqueta1 entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "atributoEtiqueta1");
		model.setAttribute("finalMode", entity.getJob().getActive());
	}
	@Override
	public Etiqueta1 findOne(final Request<Etiqueta1> request) {
		assert request != null;

		Etiqueta1 result;
		int id;

		String[] aux = request.getServletRequest().getQueryString().trim().split("=");
		id = Integer.parseInt(aux[1]);

		result = this.repository.findEtiqueta1ToThisJob(id);

		return result;
	}
}
