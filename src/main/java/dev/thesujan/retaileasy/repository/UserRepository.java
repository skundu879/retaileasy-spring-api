package dev.thesujan.retaileasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dev.thesujan.retaileasy.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

    User findByUserName(String userName);

    boolean existsByEmail(String email);

    boolean existsByUserName(String userName);
}
