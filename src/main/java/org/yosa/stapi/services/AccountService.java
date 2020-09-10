package org.yosa.stapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.yosa.stapi.domain.Account;
import org.yosa.stapi.repositories.AccountRepository;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Account save(String username, String password){
        Account account = new Account(username, password);
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.save(account);
    }

    public boolean isAccountExist(String username){
        return accountRepository.findByUsername(username) != null;
    }
}
