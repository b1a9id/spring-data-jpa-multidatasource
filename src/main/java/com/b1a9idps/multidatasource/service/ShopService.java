package com.b1a9idps.multidatasource.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.b1a9idps.multidatasource.annocation.FirstDBTransactional;
import com.b1a9idps.multidatasource.entity.first.Shop;
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

    @FirstDBTransactional
    public Shop createShop(ShopCreateRequest request) {
        var shop = new Shop();
        shop.setName(request.name());
        return shopRepository.save(shop);
    }

}
