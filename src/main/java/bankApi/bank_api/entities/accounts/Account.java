package bankApi.bank_api.entities.accounts;

import bankApi.bank_api.entities.users.AccountHolder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "currency", column = @Column(name = "balance")), @AttributeOverride(name = "amount", column = @Column(name = "amount_balance"))})
    private Money balance;

    @ManyToOne
    @JoinColumn(name = "id_primary_owner")
    private AccountHolder primaryOwner;
    private BigDecimal penaltyFee = new BigDecimal(40);

    @ManyToOne
    @JoinColumn(name = "id_secondary_owner")
    private AccountHolder secondaryOwner;

    private LocalDate creationDate;

    public Account(Money balance, AccountHolder primaryOwner, BigDecimal penaltyFee, AccountHolder secondaryOwner) {
        setBalance(balance);
        setPrimaryOwner(primaryOwner);
        setPenaltyFee(penaltyFee);
        setSecondaryOwner(secondaryOwner);
        this.creationDate = LocalDate.now();
    }

/*    public Account(Money balance, AccountHolder primaryOwner, BigDecimal penaltyFee, LocalDate creationDate) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.penaltyFee = penaltyFee;
        this.creationDate = creationDate;
    }*/

    public Account() {
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public AccountHolder getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(AccountHolder primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(BigDecimal penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public AccountHolder getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(AccountHolder secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }
}
