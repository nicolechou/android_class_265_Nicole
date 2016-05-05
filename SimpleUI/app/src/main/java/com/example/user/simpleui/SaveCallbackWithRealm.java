package com.example.user.simpleui;

import com.parse.ParseObject;
import com.parse.SaveCallback;

import java.text.ParseException;

import io.realm.Realm;
import io.realm.RealmObject;

/**
 * Created by user on 2016/5/5.
 *
 */
public class SaveCallbackWithRealm implements SaveCallback{
    RealmObject realmObject;
    SaveCallback saveCallback;

    public SaveCallbackWithRealm(RealmObject realmObject, SaveCallback callback)
    {
        this.realmObject = realmObject;
        this.saveCallback = callback;
    }

    @Override
    public void done(com.parse.ParseException e) {
        if (e == null)
        {
            Realm realm = Realm.getDefaultInstance();

            realm.beginTransaction();
            realm.copyToRealm(realmObject);
            realm.commitTransaction();

            realm.close();
        }
        saveCallback.done(e);

    }
}

