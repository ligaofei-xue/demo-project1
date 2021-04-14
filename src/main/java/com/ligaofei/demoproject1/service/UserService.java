package com.ligaofei.demoproject1.service;

import com.ligaofei.demoproject1.domain.User;

import java.util.List;

public interface UserService {
    String login(String username, String pwd);

    List<User> listUser();
}
