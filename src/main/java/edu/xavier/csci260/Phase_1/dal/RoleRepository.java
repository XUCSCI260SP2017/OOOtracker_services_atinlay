package edu.xavier.csci260.atinlay.dal;

import edu.xavier.csci260.atinlay.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

    @Override
    void delete(Role role);

}
