
package acme.features.authenticated.companyrecord;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.companyrecord.CompanyRecord;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/company-record/")
public class AuthenticatedCompanyRecordController extends AbstractController<Authenticated, CompanyRecord> {

	@Autowired
	private AuthenticatedCompanyRecordShowService	showService;

	@Autowired
	private AuthenticatedCompanyRecordListService	listService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.LIST, this.listService);
	}
}
