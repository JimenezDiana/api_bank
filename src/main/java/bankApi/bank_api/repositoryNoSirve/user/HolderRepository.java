package bankApi.bank_api.repositoryNoSirve.user;

import bankApi.bank_api.entities.users.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface HolderRepository extends JpaRepository<AccountHolder, Long> {
}
