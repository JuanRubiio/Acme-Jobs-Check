
package acme.features.authenticated.provider.employer.molet;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.molet.Molet;
import acme.entities.roles.Employer;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/employer/molet/")
public class EmployerMoletController extends AbstractController<Employer, Molet> {

	@Autowired
	private EmployerMoletListService	listService;

	@Autowired
	private EmployerMoletCreateService	createService;

	@Autowired
	private EmployerMoletDeleteService	deleteService;

	@Autowired
	private EmployerMoletUpdateService	updateService;

	@Autowired
	private EmployerMoletShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}
}
