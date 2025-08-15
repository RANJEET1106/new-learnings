package org.infosys.q3_2.services;

import org.infosys.q3_2.beans.Profile;
import org.infosys.q3_2.beans.User;

public interface UserServiceInterrface {
    public void addUser(User user, Profile profile);
    public User getUserById(Long id);
}
