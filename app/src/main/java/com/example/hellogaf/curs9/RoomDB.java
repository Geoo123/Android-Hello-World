package com.example.hellogaf.curs9;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;

import java.util.concurrent.ExecutionException;

@Database(entities = {ProjectModel.class, TaskModel.class}, version = 1)
public abstract class RoomDB extends RoomDatabase {
    private static RoomDB INSTANCE;

    public abstract RoomDao roomDao();

    public static RoomDB getInstance(Context ctx) {
        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                    ctx.getApplicationContext(),
                    RoomDB.class,
                    "room-db"
            ).fallbackToDestructiveMigration().build();
        }
        return INSTANCE;
    }

    public void insertTask(final TaskModel task) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                INSTANCE.roomDao().insertTask(task);
                return null;
            }
        }.execute();
    }

    public void insertProject(final ProjectModel project) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                INSTANCE.roomDao().insertProject(project);
                return null;
            }
        }.execute();
    }

    public ProjectAndAllTasksModel loadProject(final int projectId) {
        try {
            return new AsyncTask<Void, Void, ProjectAndAllTasksModel>() {
                @Override
                protected ProjectAndAllTasksModel doInBackground(Void... voids) {
                    return INSTANCE.roomDao().loadProjectAndAllTasks(projectId);
                }
            }.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }


}