package bankApi.bank_api.entities.accounts;

import bankApi.bank_api.entities.users.AccountHolder;
import bankApi.bank_api.status.Status;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class StudentChecking extends Account{

    private String secretKey;

    private Status status;

    public StudentChecking(Money balance, AccountHolder primaryOwner, BigDecimal penaltyFee, AccountHolder secondaryOwner, String secretKey, Status status) {
        super(balance, primaryOwner, penaltyFee, secondaryOwner);
        setSecretKey(secretKey);
        setStatus(status);
    }

    public StudentChecking(Money balance, AccountHolder primaryOwner, BigDecimal penaltyFee, AccountHolder secondaryOwner) {
        super(balance, primaryOwner, penaltyFee, secondaryOwner);
    }

    public StudentChecking(String secretKey, Status status) {
        setSecretKey(secretKey);
        setStatus(status);
    }

    public StudentChecking() {
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
