package com.infosys.Entity;

import com.infosys.DAO.ILoginDAO;
import com.infosys.Service.ILoginMgmtService;

public class LoginServiceImpl implements ILoginMgmtService {

    private ILoginDAO loginDAO;

    public LoginServiceImpl(ILoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    @Override
    public boolean login(String username, String password) {
        if(username.equals("") || password.equals(""))
            throw new IllegalArgumentException("Username or password is empty");

        int count=loginDAO.authenticate(username, password);
        if(count==0) return false;
        else return true;

//        return false;
    }

    @Override
    public int addUser(String username, String role) {
        return 0;
    }

    @Override
    public String registerUser(String username, String role) {
        if((!role.equalsIgnoreCase("")) && (!role.equalsIgnoreCase(""))) {
            loginDAO.addUser(username, role);
            return "User registered successfully";
        }
        else return "Username or password is empty";
    }


}
