
package acme.features.authenticated.provider.employer.etiqueta1;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.etiqueta1.Etiqueta1;
import acme.entities.roles.Employer;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/employer/etiqueta1/")
public class EmployerEtiqueta1Controller extends AbstractController<Employer, Etiqueta1> {

	@Autowired
	private EmployerEtiqueta1ListService	listService;

	@Autowired
	private EmployerEtiqueta1CreateService	createService;

	@Autowired
	private EmployerEtiqueta1DeleteService	deleteService;

	@Autowired
	private EmployerEtiqueta1UpdateService	updateService;

	@Autowired
	private EmployerEtiqueta1ShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}
}
