package com.example.intermove.Repositories.User;
import java.util.Optional;

import com.example.intermove.Entities.User.Role;
import com.example.intermove.Entities.User.roletype;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByroletype(roletype name);
}
