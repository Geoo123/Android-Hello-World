package com.example.hellogaf.DataStorage;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class ProjectAndAllTasksModel {
    @Embedded
    public ProjectModel project;

    @Relation(parentColumn = "id", entityColumn = "project_id", entity = TaskModel.class)
    public List<TaskModel> tasks;
}