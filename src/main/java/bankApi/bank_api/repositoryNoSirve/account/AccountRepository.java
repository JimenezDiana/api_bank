package bankApi.bank_api.repositoryNoSirve.account;

import bankApi.bank_api.entities.accounts.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
