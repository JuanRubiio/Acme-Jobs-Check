
package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {

	/**
	 *
	 */
	private static final long	serialVersionUID	= -2329799461280661125L;

	Integer						totalNumberCompanyRecords;
	Integer						totalNumberAnnonuncements;
	Integer						totalNumberInvestorRecords;
	Double						minRewardActiveRequest;
	Double						maxRewardActiveRequest;
	Double						avgRewardActiveRequest;
	Double						desvRewardActiveRequest;
	Double						minRewardActiveOffer;
	Double						maxRewardActiveOffer;
	Double						avgRewardActiveOffer;
	Double						desvRewardActiveOffer;
	Double						avgNumberJobOEmployer;
	Double						avgNumberApplEmployer;
	Double						avgNumberApplWorker;
	Double						ratioJobsEtiqueta1;
	Double						ratioApplicationAnswer;
	Double						ratioApplicationConfirmation;

}
