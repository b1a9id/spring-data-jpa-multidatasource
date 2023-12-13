package com.b1a9idps.multidatasource.repository.first;

import org.springframework.data.jpa.repository.JpaRepository;

import com.b1a9idps.multidatasource.entity.Shop;
import com.b1a9idps.multidatasource.entity.User;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
}
