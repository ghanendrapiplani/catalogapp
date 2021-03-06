package worldline.com.foldablelayout.demo.rtlpkg;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import worldline.com.foldablelayout.demo.CatModel;
import worldline.com.foldablelayout.demo.rtlpkg.CategoryAdapterRtl;
import worldline.com.foldablelayout.demo.R;

public class Act1rtl extends Activity {
    CategoryAdapterRtl mAdapter;
    RecyclerView recyclerView;
    List<CatModel> catlist = new ArrayList<CatModel>();

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

        setContentView(R.layout.rtl_firstact);

        ImageView backimg = (ImageView) findViewById(R.id.backimg);
        Glide.with(getApplicationContext()).load(R.drawable.greylinne).centerCrop().into(backimg);

        recyclerView = (RecyclerView) findViewById(R.id.rvfirst);

        mAdapter = new CategoryAdapterRtl(Act1rtl.this, catlist);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        mLayoutManager.set
        LinearLayoutManager  llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        llm.setReverseLayout(true);
        llm.setStackFromEnd(false);
        recyclerView.setLayoutManager(llm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareData();
    }

    public void prepareData() {
        CatModel cm = new CatModel("caeasrspasta1", "Italian");
        catlist.add(cm);
        cm = new CatModel("img1", "Indian");
        catlist.add(cm);
        cm = new CatModel("img2", "Sushi");
        catlist.add(cm);
        cm = new CatModel("appetizers", "Appetizers");
        catlist.add(cm);
        cm = new CatModel("sandwich", "Sandwiches");
        catlist.add(cm);
        cm = new CatModel("img4", "Drinks");
        catlist.add(cm);
        mAdapter.notifyDataSetChanged();
    }
}
