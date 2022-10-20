package bankApi.bank_api.repositoryNoSirve.account;

import bankApi.bank_api.entities.accounts.Checking;
import bankApi.bank_api.entities.accounts.Money;
import bankApi.bank_api.entities.accounts.Savings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Repository
public interface CheckingRepository extends JpaRepository<Checking, Long> {

    Checking findByBalanceAndPrimaryOwnerIdAndSecondaryOwnerIdAndPenaltyFeeAndCreationDate(Money balance, Long primaryId, Long secondaryId, BigDecimal penaltyFee, LocalDate localDate);
}
