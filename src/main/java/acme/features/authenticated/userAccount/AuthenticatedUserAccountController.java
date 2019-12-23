/*
 * AuthenticatedUserAccountController.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.authenticated.userAccount;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;
import acme.framework.entities.UserAccount;

@Controller
@RequestMapping("/authenticated/user-account/")
public class AuthenticatedUserAccountController extends AbstractController<Authenticated, UserAccount> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedUserAccountUpdateService			updateService;

	@Autowired
	private AuthenticatedUserAccountListNonIncludeService	listNonIncludeService;

	@Autowired
	private AuthenticatedUserAccountListDeleteUserService	listDeleteUserService;


	// Constructors -----------------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addCustomCommand(CustomCommand.LIST_NON_INCLUDED, BasicCommand.LIST, this.listNonIncludeService);
		super.addCustomCommand(CustomCommand.LIST_DELETE_USER, BasicCommand.LIST, this.listDeleteUserService);

	}

}