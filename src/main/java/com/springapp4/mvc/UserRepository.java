package com.springapp4.mvc;

import com.springapp4.mvc.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Person, Long> {
}