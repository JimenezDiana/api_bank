package bankApi.bank_api.repositoryNoSirve.account;

import bankApi.bank_api.entities.accounts.Money;
import bankApi.bank_api.entities.accounts.StudentChecking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Repository
public interface StudentCheckingRepository extends JpaRepository<StudentChecking, Long> {
    StudentChecking findByBalanceAndPrimaryOwnerIdAndSecondaryOwnerIdAndPenaltyFeeAndCreationDate(Money balance, Long primaryId, Long secondaryId, BigDecimal penaltyFee, LocalDate localDate);
}
