package com.edw.controller;

import com.edw.entity.Account;
import com.edw.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 *     com.edw.controller.AccountController
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 21 Jun 2020 22:07
 */
@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping(value="/{id}")
    public Account getAccount(@PathVariable("id") Integer id) {
        return accountRepository.findById(id).orElseThrow();
    }

}
