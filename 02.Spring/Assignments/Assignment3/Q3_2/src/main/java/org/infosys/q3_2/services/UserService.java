package org.infosys.q3_2.services;

import org.infosys.q3_2.beans.Profile;
import org.infosys.q3_2.beans.User;
import org.infosys.q3_2.repo.ProfileRepo;
import org.infosys.q3_2.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterrface {
    @Autowired
    UserRepo userRepo;
    @Autowired
    ProfileRepo profileRepo;

    @Override
    public void addUser(User user, Profile profile) {
        User savedUser = userRepo.save(user);
        profile.setUser(savedUser);
        profileRepo.save(profile);
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).get();
    }
}
