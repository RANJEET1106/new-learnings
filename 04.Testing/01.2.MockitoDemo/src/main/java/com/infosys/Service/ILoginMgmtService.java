package com.infosys.Service;

public interface ILoginMgmtService {
    public boolean login(String username, String password);
    public int addUser(String username, String role);
    public String registerUser(String username, String role);
}
