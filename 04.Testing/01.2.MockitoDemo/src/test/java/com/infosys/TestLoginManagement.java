package com.infosys;

import com.infosys.DAO.ILoginDAO;
import com.infosys.Entity.LoginServiceImpl;
import com.infosys.Service.ILoginMgmtService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestLoginManagement {
    private static ILoginMgmtService loginMgmtService;
    public static ILoginDAO loginDAO;

    @BeforeAll
    public static void setUpOnce(){
        loginDAO = Mockito.mock(ILoginDAO.class);
        loginMgmtService = new LoginServiceImpl(loginDAO);
    }

    @AfterAll
    public static void clearOnce(){
        loginDAO = null;
        loginMgmtService = null;
    }

    @Test
    public void testLoginWithValidCredentials() {
        Mockito.when(loginDAO.authenticate("user1","root"))
                .thenReturn(1);
        Assertions.assertTrue(loginMgmtService.login("user1","root"));
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        Mockito.when(loginDAO.authenticate("user1","root"))
                .thenReturn(0);
        Assertions.assertFalse(loginMgmtService.login("user1","root"));
    }

    @Test
    public void testLoginWithoutCredentials(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            loginMgmtService.login("","");
        });
    }

    @Test
    public void testRegisterWithSpy(){
        ILoginDAO loginDAOSpy = Mockito.spy(ILoginDAO.class);
        ILoginMgmtService loginMgmtService = new LoginServiceImpl(loginDAOSpy);
        loginMgmtService.registerUser("user1","root");
        loginMgmtService.registerUser("user2","visitor");
        loginMgmtService.registerUser("user3","");

        Mockito.verify(loginDAOSpy,Mockito.times(1))
                .addUser("user1","root");
        Mockito.verify(loginDAOSpy,Mockito.times(1))
                .addUser("user2","visitor");
        Mockito.verify(loginDAOSpy,Mockito.never())
                .addUser("user3","");
    }
}

