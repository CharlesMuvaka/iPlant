package com.example.teamenvironmentkenya.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "vendors")
public class Vendor implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "vendor_name")
    private String name;
    @ColumnInfo(name = "vendor_location")
    private String location;
    @ColumnInfo(name = "vendor_phone")
    private String phoneNumber;
    @ColumnInfo(name = "vendor_email")
    private String userEmail;

    public Vendor(){}
    public Vendor(String name, String phone, String email, String location){
        this.name = name;
        this.phoneNumber = phone;
        this.location = location;
        this.userEmail = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
