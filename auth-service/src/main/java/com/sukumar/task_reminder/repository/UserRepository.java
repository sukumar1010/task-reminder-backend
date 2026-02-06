package com.sukumar.task_reminder.repository;

import com.sukumar.task_reminder.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*  This User Repository helps to automate the SQL queries by writing correct method names,
     and it has some in-built methods to query the data
 */
public interface UserRepository extends JpaRepository<Users,Long> {
    Optional<Users> findByEmail(String email);
}


