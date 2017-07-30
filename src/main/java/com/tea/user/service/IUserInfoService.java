package com.tea.user.service;

import java.util.List;

import com.tea.user.entity.User;

public interface IUserInfoService {
    public List<User> getUsers(String phone);
    public User getUserById(long id);
    public boolean addUser(User user);
}
