package com.example.teamenvironmentkenya.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.teamenvironmentkenya.models.Tree;

import java.util.List;

@Dao
public interface TreeDao {
    @Insert
    void addTree(Tree...trees);

    @Query("select * from trees")
    List<Tree> getAllTrees();
}
