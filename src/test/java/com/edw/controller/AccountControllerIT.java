package com.edw.controller;

import com.edw.Application;
import com.edw.entity.Account;
import com.edw.repository.AccountRepository;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
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

        accountRepository.deleteById(10);

        Account account = new Account();
        account.setId(10);
        account.setAccountNumber("ten ten");
        accountRepository.save(account);
    }

    @DisplayName("This is an integration test on http GET SUCCESS")
    @Test
    public void getSuccess() throws Exception {
        given()
                .when()
                .get("/10")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    @DisplayName("This is an integration test on http GET FAILED")
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
