package no.ciber;

import no.ciber.domain.User;
import no.ciber.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final UserRepository userRepository;

	@Autowired
	public DatabaseLoader(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
		this.userRepository.save(new User("Finn the Human", "male"));
		this.userRepository.save(new User("Jake the Dog", "male"));
	}
}
