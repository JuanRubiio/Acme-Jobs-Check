
package acme.features.administrator.companyrecord;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.companyrecord.CompanyRecord;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/company-record/")
public class AdministratorCompanyRecordController extends AbstractController<Administrator, CompanyRecord> {

	@Autowired
	private AdministratorCompanyRecordShowService	showService;

	@Autowired
	private AdministratorCompanyRecordListService	listService;

	@Autowired
	private AdministratorCompanyRecordCreateService	createService;

	@Autowired
	private AdministratorCompanyRecordDeleteService	deleteService;

	@Autowired
	private AdministratorCompanyRecordUpdateService	updateService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);

	}
}
