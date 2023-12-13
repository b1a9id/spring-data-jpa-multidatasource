package com.b1a9idps.multidatasource.repository.second;

import org.springframework.data.jpa.repository.JpaRepository;

import com.b1a9idps.multidatasource.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
