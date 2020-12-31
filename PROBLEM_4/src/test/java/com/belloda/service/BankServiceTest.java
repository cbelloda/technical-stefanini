package com.belloda.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.when;

import java.util.Date;

import com.belloda.dao.BankDao;
import com.belloda.dto.BankDto;
import com.belloda.dto.ResponseError;
import com.belloda.dto.ResponseMaintenance;
import com.belloda.dto.ResponseOk;
import com.belloda.entity.Bank;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

public class BankServiceTest {

    BankDao bankDao;

    BankService bankService;

    Bank bank;

    @Before
    public void setUp() {
        bankDao = Mockito.mock(BankDao.class);
        bank = new Bank("BBVA", "La dirección", new Date());

        when(bankDao.findById(1)).thenReturn(bank);
        when(bankDao.save(argThat(new ArgumentMatcher<Bank>() {
            @Override
            public boolean matches(Bank argument) {
                return argument.getName().equals("name");
            }

        }))).thenReturn(true);

        bankService = new BankService(bankDao);

    }

    @Test
    public void should_return_invalid_bank() {
        assertTrue(bankService.invalidBank(10));
    }

    @Test
    public void should_return_valid_bank() {
        assertFalse(bankService.invalidBank(1));
    }

    @Test
    public void should_return_response_ok() {
        BankDto bankDto = new BankDto("name", "address", new Date());

        ResponseMaintenance response = bankService.save(bankDto);
        assertTrue(response instanceof ResponseOk);
    }

    @Test
    public void should_return_response_error() {
        BankDto bankDto = new BankDto("namex", "address", new Date());

        ResponseMaintenance response = bankService.save(bankDto);
        assertTrue(response instanceof ResponseError);
    }

}
