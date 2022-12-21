package com.example.teamenvironmentkenya.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.teamenvironmentkenya.models.User;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void addUser(User...users);
    @Query("select * from users")
    List<User> allUsers();
}
