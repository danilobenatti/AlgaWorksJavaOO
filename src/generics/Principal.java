package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {
	
	static Logger logger = Logger.getLogger("");
	
	public static void main(String[] args) {
		
		List<Object> list = new ArrayList<>();
		
		list.add("commit");
		list.add('C');
		list.add(123);
		list.add(true);
		list.add(new Client("John", 25));
		
		String msg = null;
		for (Object object : list) {
			msg = String.format("{0} - %s", object);
			logger.log(Level.INFO, msg, object.getClass().getSimpleName());
		}
		
	}
	
}
