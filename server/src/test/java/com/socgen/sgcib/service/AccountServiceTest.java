package com.socgen.sgcib.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.socgen.sgcib.dao.IAccountDAO;
import com.socgen.sgcib.model.Account;

@SpringBootTest
public class AccountServiceTest {
	
	
	@Autowired
    private AccountService accountService;

    @MockBean
    private IAccountDAO accountDAO;
	
    @BeforeEach
    public void setUp() {
        Account account = new Account();
        account.setBalance(new Double(500));
        
        Mockito.when(accountDAO.findAll())
          .thenReturn(Arrays.asList(account));
        
        Mockito.when(accountDAO.findFirstByOrderByIdDesc())
        .thenReturn(account);
        
        Mockito.when(accountDAO.save(Mockito.any()))
        .thenReturn(account);
        
        Mockito.doNothing().when(accountDAO).flush();
    }
    
    @Test
    public void depositAmount_OK() {
        accountService.depositAmount(new Double(500));
        Mockito.verify(accountDAO, Mockito.times(1)).findFirstByOrderByIdDesc();
        Mockito.verify(accountDAO, Mockito.times(1)).save(Mockito.any());
        Mockito.verify(accountDAO, Mockito.times(1)).flush();
     }
    
    @Test
    public void withdrawalAmount_OK() {
        accountService.depositAmount(new Double(500));
        Mockito.verify(accountDAO, Mockito.times(1)).findFirstByOrderByIdDesc();
        Mockito.verify(accountDAO, Mockito.times(1)).save(Mockito.any());
        Mockito.verify(accountDAO, Mockito.times(1)).flush();
     }
    
    @Test
    public void getAll_OK() {
        accountService.getAll();
     }

}
