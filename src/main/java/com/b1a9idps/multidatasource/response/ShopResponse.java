package com.b1a9idps.multidatasource.response;

import java.util.List;

public record ShopResponse(int id, String name, List<UserResponse> users) {

    public record UserResponse(int id, String name, Integer age) {
    }
}
