package com.cs79_1.interactive_dashboard.Repository;

import com.cs79_1.interactive_dashboard.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
