package enset.dimba.ebankservice.controllers;

import enset.dimba.ebankservice.entities.BankAccount;
import enset.dimba.ebankservice.service.EBankService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@RestController
public class EBankRestController {

    private EBankService eBankService;

    private EBankRestController(EBankService eBankService){
        this.eBankService = eBankService;
    }

    @GetMapping("/accounts")
    public List<BankAccount> getAllBankAccount(){
        return  eBankService.getAllBankAccount();
    }

    @GetMapping("/accounts/{id}")
    public BankAccount getBankAccountById(@PathVariable String id){
        return  eBankService.getBankAccountById(id);
    }

    @PostExchange("/accounts")
    public BankAccount save(@RequestBody BankAccount bankAccount){
        return eBankService.save(bankAccount);
    }
}
