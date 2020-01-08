
package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("Select Count(ua) from CompanyRecord ua")
	Integer getTotalNumberCompanyRecords();

	@Query("Select Count(ua) from Announcement ua")
	Integer getTotalNumberAnnouncements();

	@Query("Select Count(ua) from InvestorRecord ua")
	Integer getTotalNumberInvestorRecords();

	@Query("select min(o.reward.amount) from Request o where o.deadline > now()")
	Double getMinRewardActiveRequest();

	@Query("select max(o.reward.amount) from Request o where o.deadline > now()")
	Double getMaxRewardActiveRequest();

	@Query("select avg(o.reward.amount) from Request o where o.deadline > now()")
	Double getAvgRewardActiveRequest();

	@Query("select stddev(o.reward.amount) from Request o where o.deadline > now()")
	Double getDesvRewardActiveRequest();

	@Query("select min(o.reward.amount) from Offer o where o.deadline > now()")
	Double getMinRewardActiveOffer();

	@Query("select max(o.reward.amount) from Offer o where o.deadline > now()")
	Double getMaxRewardActiveOffer();

	@Query("select avg(o.reward.amount) from Offer o where o.deadline > now()")
	Double getAvgRewardActiveOffer();

	@Query("select stddev(o.reward.amount) from Offer o where o.deadline > now()")
	Double getDesvRewardActiveOffer();

	@Query("select avg(select count(j) from Job j where j.employer.id = ua.id) from Employer ua")
	Double getavgNumberJobOEmployer();

	@Query("select avg(select count(a) from Application a where a.job.employer.id = e.id) from Employer e")
	Double getavgNumberApplEmployer();

	@Query("select avg(select count(j) from Application j where j.worker.id = ua.id) from Worker ua")
	Double getavgNumberApplWorker();

	@Query("select avg(select count(j) from Molet j where j.job.id = ua.id) from Job ua")
	Double getRatioJobsMolet();

	@Query("select avg(select j.keyAt from Molet j where j.id = ua.id) from Molet ua")
	Double getRatioMoletKey();

	@Query("select avg(select a.keyPass !='' from Application a where a.id = ua.id) from Application ua")
	Double getRatioApplicationConfirmation();

	//	@Query("select avg(select count(a.confirmation) from Application a where a.id = ua.id) from Application ua")
	//	Double getRatioApplicationConfirmation();
}
