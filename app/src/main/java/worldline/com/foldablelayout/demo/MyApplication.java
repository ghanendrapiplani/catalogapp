package worldline.com.foldablelayout.demo;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.orm.SugarContext;

/**
 * Created by ghanendra on 16/10/2016.
 */
public class MyApplication extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        SugarContext.init(this);
    }
}