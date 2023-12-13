package com.b1a9idps.multidatasource.response;

public record ShopResponse(int id, String name, UserResponse user) {

    public record UserResponse(int id, String name, Integer age) {
    }
}
