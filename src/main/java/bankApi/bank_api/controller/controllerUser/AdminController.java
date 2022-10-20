package bankApi.bank_api.controller.controllerUser;

import bankApi.bank_api.controller.DTO.AccountDTO;
import bankApi.bank_api.controller.DTO.AdminDTO;
import bankApi.bank_api.controller.DTO.SavingDto;
import bankApi.bank_api.controller.interfaceUserController.AdminControllerInterface;
import bankApi.bank_api.entities.accounts.*;
import bankApi.bank_api.entities.users.AccountHolder;
import bankApi.bank_api.services.interfacesUserService.AdminServiceInterface;
import bankApi.bank_api.services.userService.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController implements AdminControllerInterface {

    @Autowired
    AdminService adminService;

    @PostMapping("/create-saving-account")
    @ResponseStatus(HttpStatus.CREATED)
    public Savings createSavingsAccount(@RequestBody AccountDTO savings) {
        return adminService.createSavingsAccount(savings);
    }

    @PatchMapping("/create-holder-account")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder createHolderAccount(AdminDTO adminDTO) {
        return adminService.createHolderAccount(adminDTO);
    }

    @PostMapping("/student-or-checking-account")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createCheckingAccount(AccountDTO checkingDTO) {
        return adminService.createCheckingAccount(checkingDTO);
    }

    @PostMapping("/create-credit-card")
    public CreditCard createCreditCard(AccountDTO creditDTO) {
        return adminService.createCreditCard(creditDTO);
    }



    @PatchMapping("/change-balance/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Account modifyBalance(@RequestParam Long accId,@RequestBody Money balance) {
        return null;
    }
}
