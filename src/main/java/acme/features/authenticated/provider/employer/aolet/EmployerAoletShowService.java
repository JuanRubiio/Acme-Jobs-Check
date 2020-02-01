
package acme.features.authenticated.provider.employer.aolet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.aolet.Aolet;
import acme.entities.job.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EmployerAoletShowService implements AbstractShowService<Employer, Aolet> {

	@Autowired
	EmployerAoletRepository repository;


	@Override
	public boolean authorise(final Request<Aolet> request) {
		assert request != null;
		boolean result;
		int id;
		Aolet et1;
		Job job;
		Principal principal;
		Employer employer;

		String[] aux = request.getServletRequest().getQueryString().trim().split("=");
		id = Integer.parseInt(aux[1]);
		et1 = this.repository.findAoletToThisJob(id);
		job = et1.getJob();
		employer = job.getEmployer();
		principal = request.getPrincipal();

		result = employer.getUserAccount().getId() == principal.getAccountId();

		return result;
	}
	@Override
	public void unbind(final Request<Aolet> request, final Aolet entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "badge");
		model.setAttribute("finalMode", entity.getJob().getActive());
	}
	@Override
	public Aolet findOne(final Request<Aolet> request) {
		assert request != null;

		Aolet result;
		int id;

		String[] aux = request.getServletRequest().getQueryString().trim().split("=");
		id = Integer.parseInt(aux[1]);

		result = this.repository.findAoletToThisJob(id);

		return result;
	}
}
