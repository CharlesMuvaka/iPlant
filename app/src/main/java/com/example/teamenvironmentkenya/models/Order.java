package com.example.teamenvironmentkenya.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "orders")
public class Order implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "user_id")
    private int userId;
    @ColumnInfo(name = "item_id")
    private int item_id;
    @ColumnInfo(name = "vendor_id")
    private int vendorId;
    @ColumnInfo(name = "placed_at")
    private String placedTime;

    public Order(){}
    public Order(int userId, int itemId, int vendorId){
        this.userId = userId;
        this.item_id = itemId;
        this.vendorId = vendorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getPlacedTime() {
        return placedTime;
    }

    public void setPlacedTime(String placedTime) {
        this.placedTime = placedTime;
    }
}
