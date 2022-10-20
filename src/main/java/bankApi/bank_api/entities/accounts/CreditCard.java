package bankApi.bank_api.entities.accounts;

import bankApi.bank_api.entities.users.AccountHolder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class CreditCard extends Account{

    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "currency", column = @Column(name = "currency_minim_balance")), @AttributeOverride(name = "amount", column = @Column(name = "amount_minimum_balance"))})
    private Money creditLimit = new Money(new BigDecimal(100));

    @Embedded
    private BigDecimal interestRate = new BigDecimal(0.2);

    public CreditCard(Money balance, AccountHolder primaryOwner, BigDecimal penaltyFee, AccountHolder secondaryOwner, Money creditLimit, BigDecimal interestRate) {
        super(balance, primaryOwner, penaltyFee, secondaryOwner);
        this.creditLimit = creditLimit;
        setInterestRate(interestRate);
    }

    public CreditCard(Money balance, AccountHolder primaryOwner, BigDecimal penaltyFee, AccountHolder secondaryOwner) {
        super(balance, primaryOwner, penaltyFee, secondaryOwner);
    }

    public CreditCard(Money creditLimit, BigDecimal interestRate) {
        this.creditLimit = creditLimit;
        setInterestRate(interestRate);
    }

    public CreditCard() {
    }

    public Money getCreditLimit() {
        return this.creditLimit;
    }

    public void setCreditLimit(Money creditLimit) {
        if (creditLimit.getAmount().compareTo(new BigDecimal(100000)) > 0) {
            throw new IllegalArgumentException("You can't hava more than 100000");
        } else if (creditLimit.getAmount().compareTo(new BigDecimal(0)) < 0) {
            throw new IllegalArgumentException("You can't have less than 1eur");
        } else {
            this.creditLimit = creditLimit;
        }
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        if (interestRate.compareTo(new BigDecimal(0.1)) < 0) {
            throw new IllegalArgumentException("The interest rate can not be less than 0.1");
        } else if (interestRate.compareTo(new BigDecimal(0.2)) > 0) {
            throw new IllegalArgumentException("The interest rate must be between 0.2 ant 0.1");
        } else {
            this.interestRate = interestRate;
        }
    }
}
