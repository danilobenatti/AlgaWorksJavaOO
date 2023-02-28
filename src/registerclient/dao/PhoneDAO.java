package registerclient.dao;

import java.util.Set;

import registerclient.model.Phone;

public interface PhoneDAO {
	
	public void save(Phone phone);
	
	public void saveAll(Set<Phone> phones);
}
