package registerclient.dao.jdbc;

public class ConnectionException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ConnectionException(String message, Throwable ex) {
		super(message, ex);
	}
	
}
