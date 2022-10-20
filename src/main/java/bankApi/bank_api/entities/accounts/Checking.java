package bankApi.bank_api.entities.accounts;

import bankApi.bank_api.entities.users.AccountHolder;
import bankApi.bank_api.status.Status;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Checking extends Account{

    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "currency", column = @Column(name = "currency_minimum_balance")), @AttributeOverride(name = "amount", column = @Column(name = "amount_minimum_balance"))})
    private Money minimumBalance = new Money(new BigDecimal(250));
    private BigDecimal monthlyMaintanceFee = new BigDecimal(12);
    private String secretKey;
    private Status status;

    public Checking(Money balance, AccountHolder primaryOwner, BigDecimal penaltyFee, AccountHolder secondaryOwner, Money minimumBalance, BigDecimal monthlyMaintanceFee, String secretKey, Status status) {
        super(balance, primaryOwner, penaltyFee, secondaryOwner);
        setMinimumBalance(minimumBalance);
        setMonthlyMaintanceFee(monthlyMaintanceFee);
        setSecretKey(secretKey);
        setStatus(status);
    }

    public Checking(Money balance, AccountHolder primaryOwner, BigDecimal penaltyFee, AccountHolder secondaryOwner) {
        super(balance, primaryOwner, penaltyFee, secondaryOwner);
    }

    public Checking() {
    }

    public void setPrimaryOwner(AccountHolder accountHolder){
        if(accountHolder.getDateOfBirth().minusYears(24) == accountHolder.getDateOfBirth()){

        }
    }

    public Money getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Money minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public BigDecimal getMonthlyMaintanceFee() {
        return monthlyMaintanceFee;
    }

    public void setMonthlyMaintanceFee(BigDecimal monthlyMaintanceFee) {
        this.monthlyMaintanceFee = monthlyMaintanceFee;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
