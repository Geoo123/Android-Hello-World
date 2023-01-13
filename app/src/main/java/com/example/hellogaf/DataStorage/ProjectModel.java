package com.example.hellogaf.DataStorage;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "project")
public class ProjectModel {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "description")
    public String description;
    @ColumnInfo(name = "estimated_hours")
    public int estimatedHours;

    public ProjectModel() {

    }

    public ProjectModel(
            String name,
            String description,
            int estimated_hours) {
        this.name = name;
        this.description = description;
        this.estimatedHours = estimated_hours;
    }
}