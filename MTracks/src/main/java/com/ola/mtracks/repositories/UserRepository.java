package com.ola.mtracks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ola.mtracks.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
