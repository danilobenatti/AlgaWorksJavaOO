package registerclient.dao;

import java.util.List;

import registerclient.model.Client;

public interface ClientDAO {
	
	public void save(Client client);
	
	public void saveAll(List<Client> list);
	
	public Client searchById(Long id);
	
	public List<Client> searchAll();
	
}
