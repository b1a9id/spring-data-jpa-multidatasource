package com.b1a9idps.multidatasource.repository.second;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.b1a9idps.multidatasource.entity.second.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAllByShopId(int shopId);
}
