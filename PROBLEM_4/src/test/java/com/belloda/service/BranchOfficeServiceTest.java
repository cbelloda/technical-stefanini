package com.belloda.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.Date;

import com.belloda.dao.BranchOfficeDao;
import com.belloda.dto.BranchOfficeDto;
import com.belloda.dto.ResponseError;
import com.belloda.dto.ResponseMaintenance;
import com.belloda.dto.ResponseOk;
import com.belloda.entity.BranchOffice;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

public class BranchOfficeServiceTest {

    BranchOfficeDao branchOfficeDao;
    BranchOfficeService branchOfficeService;

    @Before
    public void init() {
        branchOfficeDao = Mockito.mock(BranchOfficeDao.class);
        BranchOffice branchOffice = new BranchOffice("name", "address", new Date(), 1);
        when(branchOfficeDao.findById(eq(1))).thenReturn(branchOffice);
        when(branchOfficeDao.save(argThat(new ArgumentMatcher<BranchOffice>() {
            @Override
            public boolean matches(BranchOffice argument) {
                return argument.getName().equals("name");
            }

        }))).thenReturn(true);
        branchOfficeService = new BranchOfficeService(branchOfficeDao);
    }

    @Test
    public void should_return_invalid_branch() {

        assertTrue(branchOfficeService.invalidBranchOffice(10, 1));
    }

    @Test
    public void should_return_invalid_branch_by_bank() {

        assertTrue(branchOfficeService.invalidBranchOffice(1, 10));
    }

    @Test
    public void should_return_valid_branch() {

        assertFalse(branchOfficeService.invalidBranchOffice(1, 1));
    }

    @Test
    public void should_return_branch() {
        BranchOffice branch = branchOfficeService.getBranch(1);

        assertTrue(branch.getName().equals("name"));
    }

    @Test
    public void should_return_response_ok() {
        BranchOfficeDto branchOfficeDto= new BranchOfficeDto("name", "address");
        ResponseMaintenance response= branchOfficeService.save(1, branchOfficeDto);
        assertTrue(response instanceof ResponseOk);
    }

    @Test
    public void should_return_response_error() {
        BranchOfficeDto branchOfficeDto= new BranchOfficeDto("namex", "address");
        ResponseMaintenance response= branchOfficeService.save(1, branchOfficeDto);
        assertTrue(response instanceof ResponseError);
    }
    
}
