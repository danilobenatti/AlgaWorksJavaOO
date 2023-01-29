package exerciseinterfaces;

import java.text.NumberFormat;

public class InsuranceAgent {
	
	public String insuranceProposal(Insurable insurable) {
		StringBuilder builder = new StringBuilder();
		builder.append("\n###############################");
		builder.append("\n Insurance Brokerage - Proposal");
		builder.append("\n-------------------------------");
		builder.append(insurable.getDescription());
		builder.append("\nPolicy value: " + NumberFormat.getCurrencyInstance()
				.format(insurable.calculatePolicyValue()));
		builder.append("\n-------------------------------");
		return builder.toString();
	}
	
}
