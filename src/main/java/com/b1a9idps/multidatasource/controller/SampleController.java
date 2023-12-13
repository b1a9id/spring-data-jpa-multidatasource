package com.b1a9idps.multidatasource.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b1a9idps.multidatasource.entity.first.Shop;
import com.b1a9idps.multidatasource.request.ShopCreateRequest;
import com.b1a9idps.multidatasource.response.ShopResponse;
import com.b1a9idps.multidatasource.service.ShopService;
import com.b1a9idps.multidatasource.service.UserService;

@RestController
@RequestMapping("/")
public class SampleController {

    private final ShopService shopService;
    private final UserService userService;

    public SampleController(ShopService shopService, UserService userService) {
        this.shopService = shopService;
        this.userService = userService;
    }

    @GetMapping
    public List<ShopResponse> list() {
        var shops = shopService.list();

        List<ShopResponse> shopResponses = new ArrayList<>();
        for (Shop shop : shops) {
            var users = userService.findAllByShopId(shop.getId()).stream()
                    .map(user -> new ShopResponse.UserResponse(user.getId(), user.getName(), user.getAge()))
                    .toList();
            shopResponses.add(new ShopResponse(shop.getId(), shop.getName(), users));
        }

        return shopResponses;
    }

    @PostMapping("/shops")
    public ShopResponse createShop(@RequestBody ShopCreateRequest request) {
        var shop = shopService.createShop(request);
        var users = userService.createUsers(shop.getId()).stream()
                .map(user -> new ShopResponse.UserResponse(user.getId(), user.getName(), user.getAge()))
                .toList();
        return new ShopResponse(shop.getId(), shop.getName(), users);
    }
}
