package com.javarush.test.level36.lesson04.big01.model;

import com.javarush.test.level36.lesson04.big01.bean.User;
import com.javarush.test.level36.lesson04.big01.model.service.UserService;
import com.javarush.test.level36.lesson04.big01.model.service.UserServiceImpl;

import java.util.List;

/**
 * Created by Flex on 04.04.2016.
 */
public class MainModel implements Model
{
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    @Override
    public ModelData getModelData()
    {
        return modelData;
    }

    @Override
    public void loadUsers()
    {
        modelData.setUsers(userService.filterOnlyActiveUsers(loadAllUsers()));
        modelData.setDisplayDeletedUserList(false);


    }

    public void loadDeletedUsers()
    {
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
        modelData.setDisplayDeletedUserList(true);
    }

    public void loadUserById(long userId)
    {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);

    }

    public void deleteUserById(long id)
    {
        userService.deleteUser(id);
    }

    private List<User> loadAllUsers()
    {
        return userService.getUsersBetweenLevels(1, 100);
    }

    public void changeUserData(String name, long id, int level)
    {
        User user = userService.createOrUpdateUser(name, id, level);
        modelData.setActiveUser(user);
    }
}
