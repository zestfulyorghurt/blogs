package com.zestfulYoghurt.zy.services.baseService.userService;

import com.zestfulYoghurt.zy.pojos.basePojo.User;

/**
 * zestfulY
 * 2021.9.14
 */
public interface UserService {

    void addUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

    void selectUser(User user);

}
