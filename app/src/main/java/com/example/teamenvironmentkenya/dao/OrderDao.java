package com.example.teamenvironmentkenya.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.teamenvironmentkenya.models.Order;

import java.util.List;

@Dao
public interface OrderDao {
    @Insert
    void addOrder(Order...orders);
    @Query("select * from orders")
    List<Order> getAllOrders();
    @Query("select * from orders where user_id == :id")
    List<Order> getUserOrders(int id);

}
