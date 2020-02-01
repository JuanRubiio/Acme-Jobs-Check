
package acme.features.authenticated.provider.employer.aolet;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.aolet.Aolet;
import acme.entities.roles.Employer;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/employer/aolet/")
public class EmployerAoletController extends AbstractController<Employer, Aolet> {

	@Autowired
	private EmployerAoletListService	listService;

	@Autowired
	private EmployerAoletCreateService	createService;

	@Autowired
	private EmployerAoletDeleteService	deleteService;

	@Autowired
	private EmployerAoletUpdateService	updateService;

	@Autowired
	private EmployerAoletShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}
}
