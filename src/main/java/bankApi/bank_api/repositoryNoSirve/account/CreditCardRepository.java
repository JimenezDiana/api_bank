package bankApi.bank_api.repositoryNoSirve.account;

import bankApi.bank_api.entities.accounts.CreditCard;
import bankApi.bank_api.entities.accounts.Money;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
    CreditCard findByBalanceAndPrimaryOwnerIdAndSecondaryOwnerIdAndPenaltyFeeAndCreationDate(Money balance, Long primaryId, Long secondaryId, BigDecimal penaltyFee, LocalDate localDate);
}
