package bankApi.bank_api.services.userService;

import bankApi.bank_api.controller.DTO.AccountDTO;
import bankApi.bank_api.controller.DTO.AdminDTO;
import bankApi.bank_api.controller.DTO.SavingDto;
import bankApi.bank_api.entities.accounts.*;
import bankApi.bank_api.entities.users.AccountHolder;
import bankApi.bank_api.repositoryNoSirve.account.*;
import bankApi.bank_api.repositoryNoSirve.user.HolderRepository;
import bankApi.bank_api.repositoryNoSirve.user.UserRepository;
import bankApi.bank_api.services.interfacesUserService.AdminServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

@Service
public class AdminService {

    @Autowired
    SavingRepository savingRepository;
    @Autowired
    CheckingRepository checkingRepository;
    @Autowired
    CreditCardRepository creditCardRepository;
    @Autowired
    StudentCheckingRepository studentCheckingRepository;
    @Autowired
    HolderRepository holderRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    UserRepository userRepository;

    public AccountHolder createHolderAccount(AdminDTO adminDTO){
        AccountHolder accountHolder = new AccountHolder(adminDTO.getName(), adminDTO.getDateOfBirth(), adminDTO.getAdress());
        return userRepository.save(accountHolder);
    }

    public Savings createSavingsAccount(AccountDTO savingDto) {
        if(holderRepository.findById(savingDto.getPrimaryOwnerId()).isPresent()){

            Money balance = new Money(new BigDecimal(savingDto.getBalance()));
            AccountHolder primaryOwner = holderRepository.findById(savingDto.getPrimaryOwnerId()).get();
            AccountHolder secondaryOwner = null;
            if(savingDto.getSecondaryOwnerId() != null && holderRepository.findById(savingDto.getSecondaryOwnerId()).isPresent()){
                secondaryOwner = holderRepository.findById(savingDto.getSecondaryOwnerId()).get();
            }
            BigDecimal penaltyFee = new BigDecimal(savingDto.getPenaltyFee());
            Money minimumBalance = new Money(new BigDecimal(savingDto.getMinimumBalance()));

            return savingRepository.save(new Savings(balance,primaryOwner, penaltyFee, secondaryOwner, savingDto.getInterestRate(), minimumBalance, savingDto.getSecretKey() ));
        }
        throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "primary holder does not exist");


 //       AccountHolder accountHolder = holderRepository.findById(savingDto.getPrimaryOwner()).get();
 //       Savings savings = new Savings(savingDto.getBalance(), accountHolder,savingDto.getPenaltyFee(), LocalDate.now(), savingDto.getInterestRate(), savingDto.getMinimumBalance(), savingDto.getSecretKey());
 //       return savingRepository.save(savings);
    }

    public Account createCheckingAccount(AccountDTO checkingDTO){
        if(accountRepository.findById(checkingDTO.getPrimaryOwnerId()).isPresent()){
            Money balance = new Money(new BigDecimal(checkingDTO.getBalance()));
            AccountHolder primaryOwner = holderRepository.findById(checkingDTO.getPrimaryOwnerId()).get();
            AccountHolder secondaryOwner = null;

            if(checkingDTO.getPrimaryOwnerId() != null && accountRepository.findById(checkingDTO.getSecondaryOwnerId()).isPresent()){
                secondaryOwner = holderRepository.findById(checkingDTO.getSecondaryOwnerId()).get();
            }
            BigDecimal penaltyFee = new BigDecimal(checkingDTO.getPenaltyFee());


       if(Period.between(primaryOwner.getDateOfBirth(), LocalDate.now()).getYears() >= 24 && Period.between(secondaryOwner.getDateOfBirth(), LocalDate.now()).getYears() >= 24) {
           return accountRepository.save(new Checking(balance, primaryOwner, penaltyFee, secondaryOwner));
       }
       return accountRepository.save(new StudentChecking(balance, primaryOwner, penaltyFee, secondaryOwner));
    }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "it can't resolve");
    }



    public CreditCard createCreditCard(AccountDTO creditDTO) {
        if(holderRepository.findById(creditDTO.getPrimaryOwnerId()).isPresent()){
            Money balance = new Money(new BigDecimal(creditDTO.getBalance()));
            AccountHolder primaryOwner = holderRepository.findById(creditDTO.getPrimaryOwnerId()).get();
            AccountHolder secondaryOwner = null;

            if(creditDTO.getSecondaryOwnerId() != null && holderRepository.findById(creditDTO.getSecondaryOwnerId()).isPresent()){
                secondaryOwner = holderRepository.findById(creditDTO.getSecondaryOwnerId()).get();
            }
            BigDecimal penaltyFee = new BigDecimal(creditDTO.getPenaltyFee());
            Money creditLimit = new Money(new BigDecimal(creditDTO.getCreditLimit()));
            BigDecimal interestRate = new BigDecimal(creditDTO.getInterestRate());
            return creditCardRepository.save(new CreditCard(balance,primaryOwner, penaltyFee, secondaryOwner, creditLimit, interestRate));
        }
        throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "primary holder does not exist");
    }

}
