package bankApi.bank_api;

import bankApi.bank_api.entities.users.AccountHolder;
import bankApi.bank_api.entities.users.Adress;
import bankApi.bank_api.repositoryNoSirve.user.HolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class BankApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BankApiApplication.class, args);
	}

	@Autowired
	HolderRepository holderRepository;

	@Override
	public void run(String... args) throws Exception {

	//	Adress adress = new Adress("calle","ciudad","pais","0800");
	//	AccountHolder accountHolder = new AccountHolder("random", LocalDate.of(1990, 3,31),adress);
	//	holderRepository.save(accountHolder);
	}
}
