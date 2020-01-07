
package acme.features.administrator.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	@Autowired
	AdministratorDashboardRepository repository;


	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "totalNumberCompanyRecords", "totalNumberAnnonuncements", "totalNumberInvestorRecords", "minRewardActiveRequest", "maxRewardActiveRequest", "avgRewardActiveRequest", "desvRewardActiveRequest", "minRewardActiveOffer",
			"maxRewardActiveOffer", "avgRewardActiveOffer", "desvRewardActiveOffer", "avgNumberJobOEmployer", "avgNumberApplEmployer", "avgNumberApplWorker", "ratioJobsEtiqueta1", "ratioApplicationAnswer", "ratioApplicationConfirmation");

	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {

		Dashboard res = new Dashboard();

		Integer totalNumberCompanyRecords = this.repository.getTotalNumberCompanyRecords();
		Integer totalNumberAnnouncements = this.repository.getTotalNumberAnnouncements();
		Integer totalNumberInvestorRecords = this.repository.getTotalNumberInvestorRecords();
		Double minRewardActiveOffer = this.repository.getMinRewardActiveOffer();
		Double maxRewardActiveOffer = this.repository.getMaxRewardActiveOffer();
		Double avgRewardActiveOffer = this.repository.getAvgRewardActiveOffer();
		Double desvRewardActiveOffer = this.repository.getAvgRewardActiveOffer();
		Double minRewardActiveRequest = this.repository.getMinRewardActiveRequest();
		Double maxRewardActiveRequest = this.repository.getMaxRewardActiveRequest();
		Double avgRewardActiveRequest = this.repository.getAvgRewardActiveRequest();
		Double desvRewardActiveRequest = this.repository.getAvgRewardActiveRequest();
		Double avgNumberJobOEmployer = this.repository.getavgNumberJobOEmployer();
		Double avgNumberApplEmployer = this.repository.getavgNumberApplEmployer();
		Double avgNumberApplWorker = this.repository.getavgNumberApplWorker();
		Double ratioJobsMolet = this.repository.getRatioJobsMolet();
		Double ratioApplicationAnswer = this.repository.getRatioMoletKey();
		Double ratioApplicationConfirmation = this.repository.getRatioApplicationConfirmation();

		res.setTotalNumberCompanyRecords(totalNumberCompanyRecords);
		res.setTotalNumberAnnonuncements(totalNumberAnnouncements);
		res.setTotalNumberInvestorRecords(totalNumberInvestorRecords);
		res.setMinRewardActiveOffer(minRewardActiveOffer);
		res.setMaxRewardActiveOffer(maxRewardActiveOffer);
		res.setAvgRewardActiveOffer(avgRewardActiveOffer);
		res.setDesvRewardActiveOffer(desvRewardActiveOffer);
		res.setMinRewardActiveRequest(minRewardActiveRequest);
		res.setMaxRewardActiveRequest(maxRewardActiveRequest);
		res.setAvgRewardActiveRequest(avgRewardActiveRequest);
		res.setDesvRewardActiveRequest(desvRewardActiveRequest);
		res.setAvgNumberJobOEmployer(avgNumberJobOEmployer);
		res.setAvgNumberApplEmployer(avgNumberApplEmployer);
		res.setAvgNumberApplWorker(avgNumberApplWorker);
		res.setRatioJobsEtiqueta1(ratioJobsMolet);
		res.setRatioApplicationAnswer(ratioApplicationAnswer);
		res.setRatioApplicationConfirmation(ratioApplicationConfirmation);

		return res;
	}

}
