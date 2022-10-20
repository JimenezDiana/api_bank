package bankApi.bank_api.entities.accounts;

import bankApi.bank_api.entities.users.AccountHolder;
import bankApi.bank_api.status.Status;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.bytecode.Throw;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Savings extends Account{

    private Double interestRate = 0.0025;

    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "currency", column = @Column(name = "currency_minimum_balance")), @AttributeOverride(name = "amount", column = @Column(name = "amount_minumum_balance"))})
    private Money minimumBalance =  new Money(new BigDecimal(1000));;
    private String secretKey;

    private Status status;

    public Savings(Money balance, AccountHolder primaryOwner, BigDecimal penaltyFee, AccountHolder secondaryOwner, Double interestRate, Money minimumBalance, String secretKey) {
        super(balance, primaryOwner, penaltyFee, secondaryOwner);
        setInterestRate(interestRate);
        setMinimumBalance(minimumBalance);
        setSecretKey(secretKey);
        this.status = Status.ACTIVE;
    }



    public Savings() {
    }



    public void setBalance(Money balance){
        if(balance.getAmount().compareTo(minimumBalance.getAmount()) < 0){
            balance.getAmount().subtract(getPenaltyFee());
        }
        super.setBalance(balance);
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public Double setInterestRate(Double interestRate) /*Tengo que devolver el doble?*/{
        if(interestRate > 0.5){
            throw new IllegalArgumentException("Sorry, you're interest rate must be under of 0,5");
        }else{
            return this.interestRate = interestRate;
        }

    }

    public Money getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Money minimumBalance) {

        if(minimumBalance.getAmount().compareTo(new BigDecimal(100)) < 0){
            throw new IllegalArgumentException("You can't have less than 100eur");
        } else {
            this.minimumBalance = minimumBalance;
        }
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
