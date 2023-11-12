package com.happytrip.petcargo.dao;

import java.util.List;

import com.happytrip.petcargo.model.*;

public interface UserDao {
     public boolean createUser(User user);
     public boolean updateUser(User user);
     public boolean deleteUser(User user);
     public User fetchUser(int userId);
     public List<User> fetchAllUser();
}
