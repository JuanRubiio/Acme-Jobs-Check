
package acme.features.authenticated.provider.employer.job;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.job.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class EmployerJobListMineService implements AbstractListService<Employer, Job> {

	@Autowired
	private EmployerJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "reference", "status", "salary", "link", "description", "active", "ayuda");

	}

	@Override
	public Collection<Job> findMany(final Request<Job> request) {
		assert request != null;

		int id = request.getPrincipal().getActiveRoleId();
		Collection<Job> result = this.repository.getJobsByEmployerId(id);

		return result;
	}

}
