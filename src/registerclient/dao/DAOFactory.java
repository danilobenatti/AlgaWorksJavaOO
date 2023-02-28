package registerclient.dao;

import registerclient.dao.jdbc.JdbcDAOFactory;

public abstract class DAOFactory {
	
	public static DAOFactory getDAOFactory() {
		return new JdbcDAOFactory();
	}
	
	public abstract ClientDAO getClientDAO();
	
	public abstract AddressDAO getAddressDAO();
	
	public abstract PhoneDAO getPhoneDAO();
	
}
