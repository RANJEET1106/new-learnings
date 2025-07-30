package com.infosys.DAO;

public interface ILoginDAO {
    public int authenticate(String username, String password);
    public int addUser(String username, String role);
}
