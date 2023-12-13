package com.b1a9idps.multidatasource.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.b1a9idps.multidatasource.entity.Shop;
import com.b1a9idps.multidatasource.repository.first.ShopRepository;

@Service
public class ShopService {
    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<Shop> list() {
        return shopRepository.findAll();
    }

}
