package examplelambda.dao;

import java.util.ArrayList;
import java.util.List;

import examplelambda.model.Invoice;
import examplelambda.model.Status;

public class InvoiceDAOL {
	
	public List<Invoice> invoicesDueList() {
		List<Invoice> invoices = new ArrayList<>();
		invoices.add(new Invoice(1L, "peter@email.com", 121.42f, false,
				Status.PENDING));
		invoices.add(new Invoice(2L, "john@omail.com", 45.92f, false,
				Status.PENDING));
		invoices.add(new Invoice(3L, "samuelpmail.com", 78.51f, false,
				Status.PENDING));
		return invoices;
	}
	
}
