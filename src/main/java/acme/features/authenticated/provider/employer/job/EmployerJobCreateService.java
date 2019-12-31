
package acme.features.authenticated.provider.employer.job;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.job.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerJobCreateService implements AbstractCreateService<Employer, Job> {

	@Autowired
	private EmployerJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Job> request, final Job entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "active", "ayuda");
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "reference", "status", "salary", "link", "description");

	}

	@Override
	public Job instantiate(final Request<Job> request) {
		Job res;
		int employerId = request.getPrincipal().getAccountId();
		Employer employer = this.repository.findEmployerById(employerId);

		res = new Job();
		res.setEmployer(employer);
		res.setActive(false);
		res.setAyuda(false);

		return res;
	}

	@Override
	public void validate(final Request<Job> request, final Job entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		boolean isDuplicated, isFuture = false;

		isDuplicated = this.repository.findByReference(entity.getReference()) != null;
		errors.state(request, !isDuplicated, "reference", "employer.job.duplicatedReference");

		if (entity.getDeadline() != null) {
			if (entity.getDeadline().before(new Date())) {
				isFuture = false;
			} else {
				isFuture = true;
			}
			errors.state(request, isFuture, "deadline", "authenticated.consumer.deadlinepast");

		}

	}

	@Override
	public void create(final Request<Job> request, final Job entity) {
		//		Date date = new Date();
		//		CustomisationParameters custom = this.repository.findCustomParameters();
		//
		//		double contSpam = 0.0;
		//		if (custom != null && StringUtils.isNotBlank(custom.getSpamWordsEn())) {
		//			String engSpam = custom.getSpamWordsEn();
		//			String[] arraySpam = engSpam.split(",");
		//			List<String> listSpamEn = Arrays.asList(arraySpam);
		//			for (String s : listSpamEn) {
		//				if (entity.getDescription().contains(s) || entity.getTitle().contains(s)) {
		//					contSpam++;
		//				}
		//
		//			}
		//		}
		//		if (custom != null && StringUtils.isNotBlank(custom.getSpamWordsEs())) {
		//			String esSpam = custom.getSpamWordsEs();
		//			String[] arraySpam = esSpam.split(",");
		//			List<String> listSpamEs = Arrays.asList(arraySpam);
		//			for (String s : listSpamEs) {
		//				if (entity.getDescription().contains(s) || entity.getTitle().contains(s)) {
		//					contSpam++;
		//				}
		//
		//			}
		//		}
		//
		//		if (entity.getDeadline().after(date) && "Published".equals(entity.getStatus()) && contSpam < custom.getSpamThreshold()) {
		//			entity.setActive(true);
		//		}

		this.repository.save(entity);
	}

}
