package com.example.hellogaf.curs9;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DataStorageHelper {
    public static String SHARED_PREFS_FILE = "data-storage-world";
    public static void saveValueInSharedPrefs (
        Context ctx,
        String key,
        String value
        ) {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String readValueInSharedPrefs (
            Context ctx,
            String key
    ) {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE);
       return sharedPreferences.getString(key, "");
    }

    public static void writeToFile(Context ctx, String filename, String content) {
        FileOutputStream  fos = null;
        try {
            fos = ctx.openFileOutput(filename, Context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        try {
            osw.write(content);
            osw.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

    }

    public static String readFromFile(Context ctx, String filename) {
        try {
            FileInputStream fis = ctx.openFileInput(filename);
            InputStreamReader isr = new InputStreamReader(fis);
            char []inputBuffer = new char[100];
            StringBuffer stringBuffer = new StringBuffer("");
            int charRead;
            while ((charRead = isr.read(inputBuffer)) > 0) {
                stringBuffer.append(String.copyValueOf(inputBuffer, 0, charRead));
            }
            String output = stringBuffer.toString();
            isr.close();
            return output;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";

    }
}
