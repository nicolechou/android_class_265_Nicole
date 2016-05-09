package com.example.user.simpleui;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;

/**
 * Created by user on 2016/4/28.
 */
public class Utils {

    public static void writeFile(Context context, String fileName, String content)
    {
        try {
            FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_APPEND);
            fos.write(content.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFile(Context context, String fileName)
    {
        try {
            FileInputStream fis = context.openFileInput(fileName);
            byte[] buffer = new byte[1024];
            fis.read(buffer, 0, buffer.length);
            fis.close();
            return new String(buffer);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static Uri getPhotoURI()
    {
        //宣告路徑
        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        //無資料夾就，建立他
        if(dir.exists() == false)
        {
            dir.mkdir();
        }

        File file = new File(dir, "simpleUI_photo.pg");
        return Uri.fromFile(file);



    }

}
