package registerclient.dao;

public class DAOException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public DAOException(String message, Throwable ex) {
		super(message, ex);
	}
	
}
