package com.example.teamenvironmentkenya.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.teamenvironmentkenya.models.Vendor;

import java.util.List;

@Dao
public interface VendorDao {
    @Insert
    void addVendor(Vendor...vendors);
    @Query("select * from vendors")
    List<Vendor> getAllVendors();
}
