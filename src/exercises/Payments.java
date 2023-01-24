package exercises;

import java.text.NumberFormat;

public class Payments {
	
	NumberFormat currency = NumberFormat.getCurrencyInstance();
	
	public String executePayment(Account account) {
		String result = null;
		switch (account.getAccountStatus()) {
			case PAID:
				result = String.format("%s -> %s, has already been paid.",
						account.getSupplier().getName(),
						account.getDescription());
				break;
			case CANCELED:
				result = String.format("%s -> %s, has already been cancel.",
						account.getSupplier().getName(),
						account.getDescription());
				break;
			case PENDING:
				result = String.format("%s -> Making payment: %s, value: %s",
						account.getSupplier().getName(),
						account.getDescription(),
						currency.format(account.getValue()));
				account.setAccountStatus(AccountStatus.PAID);
				break;
			default:
				result = "-- ? --";
				break;
		}
		return result;
	}
	
	public String cancelPayment(Account account) {
		String result = switch (account.getAccountStatus()) {
			case PAID -> String.format("%s - > %s, has already been paid.",
					account.getSupplier().getName(), account.getDescription());
			case CANCELED -> String.format("%s -> %s, has already been cancel.",
					account.getSupplier().getName(), account.getDescription());
			case PENDING -> String.format("%s -> Cancel payment: %s, value: %s",
					account.getSupplier().getName(), account.getDescription(),
					currency.format(account.getValue()));
			default -> "-- ? --";
		};
		if (account.getAccountStatus().equals(AccountStatus.PENDING)) {
			account.setAccountStatus(AccountStatus.CANCELED);
		}
		return result;
	}
	
}
