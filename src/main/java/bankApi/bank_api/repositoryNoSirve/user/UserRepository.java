package bankApi.bank_api.repositoryNoSirve.user;

import bankApi.bank_api.entities.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
