package bankApi.bank_api.services.interfacesUserService;

import bankApi.bank_api.controller.DTO.AdminDTO;
import bankApi.bank_api.controller.DTO.SavingDto;
import bankApi.bank_api.entities.accounts.*;

public interface AdminServiceInterface {

    //-->Create accounts

    Savings createSavingsAccount(SavingDto savingDto);

    Account createCheckingOrStudentAccount(AdminDTO adminDTO);

    CreditCard createCreditCard(AdminDTO adminDTO);

    //--> Modify accounts
    Account modifyBalance(Long accId, Money balance);

}
