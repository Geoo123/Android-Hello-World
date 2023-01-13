package com.example.hellogaf.DataStorage;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;
import android.arch.persistence.room.Update;

@Dao
public interface RoomDao {
    /*@Query("SELECT * FROM Project")
    List<ProjectModel> getAllProjects();

    @Query("SELECT * FROM Task")
    List<TaskModel> getAllTasks();*/

    @Insert
    void insertProject(ProjectModel project);

    @Insert
    void insertTask(TaskModel task);

    @Update
    void updateProject(ProjectModel project);

    @Update
    void updateTask(TaskModel task);

    @Delete
    void deleteProject(ProjectModel project);

    @Delete
    void deleteTask(TaskModel task);

    @Transaction
    @Query("SELECT * FROM project WHERE id = :projectId")
    ProjectAndAllTasksModel loadProjectAndAllTasks(int projectId);

}