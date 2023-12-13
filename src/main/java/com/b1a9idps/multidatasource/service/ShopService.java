package com.b1a9idps.multidatasource.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.b1a9idps.multidatasource.entity.Shop;
import com.b1a9idps.multidatasource.repository.first.ShopRepository;
import com.b1a9idps.multidatasource.request.ShopCreateRequest;

@Service
public class ShopService {
    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<Shop> list() {
        return shopRepository.findAll();
    }

    @Transactional
    public Shop createShop(ShopCreateRequest request) {
        var shop = new Shop();
        shop.setName(request.name());
        return shopRepository.save(shop);
    }

}
