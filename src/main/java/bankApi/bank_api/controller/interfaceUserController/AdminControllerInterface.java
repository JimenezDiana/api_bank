package bankApi.bank_api.controller.interfaceUserController;


import bankApi.bank_api.controller.DTO.AccountDTO;
import bankApi.bank_api.controller.DTO.AdminDTO;
import bankApi.bank_api.entities.accounts.*;
import bankApi.bank_api.entities.users.AccountHolder;
import bankApi.bank_api.entities.users.Admin;

public interface AdminControllerInterface {
    Savings createSavingsAccount(AccountDTO adminDTO);

    AccountHolder createHolderAccount(AdminDTO adminDTO);

    Account createCheckingAccount(AccountDTO checkingDTO);


    CreditCard createCreditCard(AccountDTO creditDTO);
    Account modifyBalance(Long accId, Money balance);
}
