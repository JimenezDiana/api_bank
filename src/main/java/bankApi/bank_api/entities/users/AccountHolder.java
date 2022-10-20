package bankApi.bank_api.entities.users;

import bankApi.bank_api.entities.accounts.Account;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class AccountHolder extends User{
    private LocalDate dateOfBirth;

    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "street", column = @Column(name ="street_mail")), @AttributeOverride(name = "city", column = @Column(name = "city_mail")),@AttributeOverride(name = "country", column = @Column(name = "country_mail")), @AttributeOverride(name = "zipCode", column = @Column(name = "zip_code_mail"))})
    private Adress mailing;

    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "street", column = @Column(name = "street_adress")),@AttributeOverride(name = "city", column = @Column(name = "city_adress")), @AttributeOverride(name = "country", column = @Column(name = "country_adress")), @AttributeOverride(name = "zipCode", column = @Column(name = "zip_code_adress"))})
    private Adress adress;
    @OneToMany(mappedBy = "primary_owner")
    List<Account> accountListPrimaryOwner;

    @OneToMany(mappedBy = "secondary_Owner")
    List<Account> accountListSecondaryOwner;

    public AccountHolder(String name, LocalDate dateOfBirth, List<Account> accountListPrimaryOwner, List<Account> accountListSecondaryOwner, Adress mailing, Adress adress) {
        super(name);
        this.dateOfBirth = dateOfBirth;
        this.accountListPrimaryOwner = accountListPrimaryOwner;
        this.accountListSecondaryOwner = accountListSecondaryOwner;
        this.mailing = mailing;
        this.adress = adress;
    }

    public AccountHolder(String name, LocalDate dateOfBirth, Adress adress) {
        super(name);
        this.dateOfBirth = dateOfBirth;
        this.adress = adress;
    }

    public AccountHolder(LocalDate dateOfBirth, List<Account> accountListPrimaryOwner, List<Account> accountListSecondaryOwner, Adress mailing, Adress adress) {
        this.dateOfBirth = dateOfBirth;
        this.accountListPrimaryOwner = accountListPrimaryOwner;
        this.accountListSecondaryOwner = accountListSecondaryOwner;
        this.mailing = mailing;
        this.adress = adress;
    }

    public AccountHolder() {
    }

    public List<Account> getAccountListPrimaryOwner() {
        return accountListPrimaryOwner;
    }

    public void setAccountListPrimaryOwner(List<Account> accountListPrimaryOwner) {
        this.accountListPrimaryOwner = accountListPrimaryOwner;
    }

    public List<Account> getAccountListSecondaryOwner() {
        return accountListSecondaryOwner;
    }

    public void setAccountListSecondaryOwner(List<Account> accountListSecondaryOwner) {
        this.accountListSecondaryOwner = accountListSecondaryOwner;
    }

    public Adress getMailing() {
        return mailing;
    }

    public void setMailing(Adress mailing) {
        this.mailing = mailing;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
