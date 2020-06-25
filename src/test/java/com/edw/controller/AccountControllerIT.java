package com.edw.controller;

import com.edw.entity.Account;
import com.edw.repository.AccountRepository;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static io.restassured.RestAssured.given;

/**
 * <pre>
 *     com.edw.controller.AccountControllerIT
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 21 Jun 2020 22:16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class AccountControllerIT {
    @LocalServerPort
    private int port;

    @Autowired
    private AccountRepository accountRepository;

    @Before
    public void setup() {
        RestAssured.port = this.port;

        accountRepository.delete(new Account(10));

        Account account = new Account();
        account.setId(10);
        account.setAccountNumber("ten ten");
        accountRepository.save(account);
    }

    @Test
    public void getSuccess() throws Exception {
        given()
                .when()
                .get("/10")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getFailed() throws Exception {
        given()
                .when()
                .get("/7")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }
}
