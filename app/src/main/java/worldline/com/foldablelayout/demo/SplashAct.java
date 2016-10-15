package worldline.com.foldablelayout.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import worldline.com.foldablelayout.demo.admin.AddItem;
import worldline.com.foldablelayout.demo.rtlpkg.Act1rtl;

/**
 * Created by ghanendra on 15/10/2016.
 */
public class SplashAct extends Activity {
    Button english,arabic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = this.getWindow();

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        window.setStatusBarColor(this.getResources().getColor(R.color.mycolor));

        setContentView(R.layout.splashact);
        ImageView backimg = (ImageView) findViewById(R.id.backimg);
        Glide.with(getApplicationContext()).load(R.drawable.greylinne).centerCrop().into(backimg);

    }

    public void arab(View view){
        startActivity(new Intent(SplashAct.this, Act1rtl.class));
    }
    public void eng(View view){
        startActivity(new Intent(SplashAct.this, Act1.class));
    }
    public void gotoAdmin(View view){
        startActivity(new Intent(SplashAct.this,AddItem.class));
    }
}
