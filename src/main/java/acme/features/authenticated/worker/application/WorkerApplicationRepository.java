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

package acme.features.authenticated.worker.application;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.aolet.Aolet;
import acme.entities.applications.Application;
import acme.entities.job.Job;
import acme.entities.roles.Worker;
import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface WorkerApplicationRepository extends AbstractRepository {

	@Query("select a from Application a")
	Collection<Application> findAllApplications();

	@Query("select a from Application a where a.id = ?1")
	Application findOneById(int id);

	@Query("select count(a) from Application a")
	Integer numberApplications();

	@Query("select a from Application a where a.worker.id = ?1")
	Collection<Application> findAllApplicationToWorker(int id);

	@Query("select ua from UserAccount ua where ua.id = ?1")
	UserAccount findOneUserAccountById(int id);

	@Query("select j from Job j where j.id = ?1")
	Job findJobById(int id);

	@Query("select a.worker from Application a where a.worker.userAccount.id = ?1")
	Worker findWorker(int id);

	@Query("select a.id from Job a where a.deadline > now() and a.status = 'published'")
	List<Integer> findIdJobsActive();

	@Query("select a from Aolet a where a.job.id =?1")
	Aolet findAoletToThisJob(int id);

	@Query("select ua from Application ua where ua.referenceNumber = ?1")
	Application findByReference(String reference);
}
