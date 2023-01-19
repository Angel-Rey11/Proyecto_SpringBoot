package restfull.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restfull.model.Client;
import restfull.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository repository;
	
	public Client createOrUpdateClient(Client client) {
		if (client.getId() != null) {
			try {
				Optional<Client> c = repository.findById(client.getId());
				if (c.isPresent()) {
					client = repository.save(client);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			client = repository.save(client);
		}
		return client;
	}
	
	public void removeClient(Long id) {
		try {
			Optional<Client> c = repository.findById(id);
			if (c.isPresent()) {
				repository.deleteById(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Client getClientById(Long id) {
		Client client = new Client();
		try {
			Optional<Client> c = repository.findById(id);
			client = c.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return client;
	}
	
	public List<Client> getAllClient() {
		return repository.findAll();
	}
}
