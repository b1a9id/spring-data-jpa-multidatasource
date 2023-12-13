package com.b1a9idps.multidatasource.service;

import org.springframework.stereotype.Service;

import com.b1a9idps.multidatasource.entity.second.User;
import com.b1a9idps.multidatasource.repository.second.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByShopId(int shopId) {
        return userRepository.findByShopId(shopId).orElseThrow();
    }
}
