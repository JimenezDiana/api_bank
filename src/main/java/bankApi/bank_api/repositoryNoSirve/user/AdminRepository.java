package bankApi.bank_api.repositoryNoSirve.user;

import bankApi.bank_api.entities.users.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
