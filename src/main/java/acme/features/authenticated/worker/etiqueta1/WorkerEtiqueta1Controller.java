
package acme.features.authenticated.worker.etiqueta1;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.aolet.Aolet;
import acme.entities.roles.Worker;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/worker/aolet/")
public class WorkerEtiqueta1Controller extends AbstractController<Worker, Aolet> {

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
