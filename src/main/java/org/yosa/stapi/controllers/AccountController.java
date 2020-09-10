package org.yosa.stapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yosa.stapi.domain.Account;
import org.yosa.stapi.dtos.AccountReadDto;
import org.yosa.stapi.services.AccountService;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("signup")
    public ResponseEntity<Account> signup(@RequestBody AccountReadDto account){
        if(accountService.isAccountExist(account.username))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(accountService.save(account.username, account.password), HttpStatus.CREATED);
    }
}
