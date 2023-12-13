package com.b1a9idps.multidatasource.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.b1a9idps.multidatasource.annocation.SecondDBTransactional;
import com.b1a9idps.multidatasource.entity.second.User;
import com.b1a9idps.multidatasource.repository.second.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @SecondDBTransactional
    public List<User> createUsers(int shopId) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("user-" + shopId);
            user.setShopId(shopId);
            user.setAge(i + 1);

            users.add(userRepository.save(user));
        }
        return users;

    }

    public List<User> findAllByShopId(int shopId) {
        return userRepository.findAllByShopId(shopId);
    }
}
