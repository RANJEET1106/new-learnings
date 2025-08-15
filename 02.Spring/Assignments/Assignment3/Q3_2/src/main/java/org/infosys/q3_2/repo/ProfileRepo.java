package org.infosys.q3_2.repo;

import org.infosys.q3_2.beans.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepo extends JpaRepository<Profile,Long> {
}
