package org.yosa.stapi.controllers;

import com.auth0.jwt.JWT;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.*;
import org.yosa.stapi.domain.Account;
import org.yosa.stapi.dtos.AccountReadDto;
import org.yosa.stapi.dtos.AccountTokenDto;
import org.yosa.stapi.exceptions.BadRequestException;
import org.yosa.stapi.services.AccountService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static org.yosa.stapi.security.SecurityConstants.EXPIRATION_TIME;
import static org.yosa.stapi.security.SecurityConstants.SECRET;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("login")
    public AccountTokenDto login(@RequestBody AccountReadDto account) {
        Account user = accountService.getByUsername(account.username);

        List<String> user_roles = new ArrayList<String>();
        user.getRoles().forEach(e -> user_roles.add(e.name()));
        String roles = String.join(",", user_roles);

        String token = JWT.create()
                .withSubject(account.username).withClaim("Roles", roles)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(HMAC512(SECRET.getBytes()));
        user.setToken(token);

        return modelMapper.map(user, AccountTokenDto.class);
    }

    @PostMapping("signup")
    public ResponseEntity<Account> signup(@RequestBody AccountReadDto account){
        if(accountService.isAccountExist(account.username))
            throw new BadRequestException("Username is already in use");
        return new ResponseEntity<>(accountService.save(account.username, account.password), HttpStatus.CREATED);
    }
}
