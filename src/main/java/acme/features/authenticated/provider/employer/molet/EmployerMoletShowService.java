
package acme.features.authenticated.provider.employer.molet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.job.Job;
import acme.entities.molet.Molet;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EmployerMoletShowService implements AbstractShowService<Employer, Molet> {

	@Autowired
	EmployerMoletRepository repository;


	@Override
	public boolean authorise(final Request<Molet> request) {
		assert request != null;
		boolean result;
		int id;
		Molet et1;
		Job job;
		Principal principal;
		Employer employer;

		String[] aux = request.getServletRequest().getQueryString().trim().split("=");
		id = Integer.parseInt(aux[1]);
		et1 = this.repository.findMoletToThisJob(id);
		job = et1.getJob();
		employer = job.getEmployer();
		principal = request.getPrincipal();

		result = employer.getUserAccount().getId() == principal.getAccountId();

		return result;
	}
	@Override
	public void unbind(final Request<Molet> request, final Molet entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "_key");
		model.setAttribute("finalMode", entity.getJob().getActive());
	}
	@Override
	public Molet findOne(final Request<Molet> request) {
		assert request != null;

		Molet result;
		int id;

		String[] aux = request.getServletRequest().getQueryString().trim().split("=");
		id = Integer.parseInt(aux[1]);

		result = this.repository.findMoletToThisJob(id);

		return result;
	}
}
