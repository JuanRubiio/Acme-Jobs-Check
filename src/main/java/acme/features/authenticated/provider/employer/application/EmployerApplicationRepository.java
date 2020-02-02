/*
 * AnonymousUserAccountRepository.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.authenticated.provider.employer.application;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerApplicationRepository extends AbstractRepository {

	@Query("select a from Application a")
	Collection<Application> findAllApplications();

	@Query("select a from Application a where a.id = ?1")
	Application findOneById(int id);

	@Query("select count(a) from Application a")
	Integer numberApplications();

	@Query("select a from Application a where a.worker.id = ?1")
	Collection<Application> findAllApplicationPerWorker(int id);

	@Query("select a from Application a where a.job.id = (select j.id from Job j where j.id= ?1)")
	Collection<Application> findAllApplicationToThisJob(int id);

	@Query("select a from Application a where a.job.employer.id = ?1")
	Collection<Application> findAllApplicationToThisEmployer(int id);

	@Query("select a from Application a where a.job.employer.id = ?1 order by a.status asc")
	List<Application> orderApplicationToThisEmployer(int id);

	@Query("select m.job.id from Molet m")
	List<Integer> findIdJobFromMolet();
}
