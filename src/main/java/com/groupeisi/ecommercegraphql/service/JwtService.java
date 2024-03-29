package com.groupeisi.ecommercegraphql.service;

import java.util.Map;

public interface JwtService {
    Map<String,String> generate(String username);
}
