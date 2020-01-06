
package acme.features.authenticated.worker.etiqueta1;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.etiqueta1.Etiqueta1;
import acme.entities.roles.Worker;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/worker/etiqueta1/")
public class WorkerEtiqueta1Controller extends AbstractController<Worker, Etiqueta1> {

	@Autowired
	private WorkerEtiqueta1ListService	listService;

	@Autowired
	private WorkerEtiqueta1ShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}
}
