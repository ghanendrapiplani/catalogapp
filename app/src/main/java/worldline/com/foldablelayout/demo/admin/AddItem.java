package worldline.com.foldablelayout.demo.admin;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import gun0912.tedbottompicker.TedBottomPicker;
import worldline.com.foldablelayout.demo.R;

/**
 * Created by ghanendra on 15/10/2016.
 */
public class AddItem extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    @Bind(R.id.dishname)
    EditText etname;
    @Bind(R.id.dishdescr)
    EditText etdescr;
    @Bind(R.id.img1)
    ImageView imgv;
    @Bind(R.id.catId)
    Spinner spinner;

    String cat;
    Uri urimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_additem);
        ButterKnife.bind(this);

        spinner.setOnItemSelectedListener(AddItem.this);
        List<String> categories = new ArrayList<String>();
        categories.add("Appetizers");
        categories.add("Averages");
        categories.add("Burgers");
        categories.add("Deserts");
        categories.add("Kids");
        categories.add("Maincourse");
        categories.add("Salads");
        categories.add("Sandwiches");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    public void chooseImg(View view){
        TedBottomPicker tedBottomPicker = new TedBottomPicker.Builder(AddItem.this)
                .setOnImageSelectedListener(new TedBottomPicker.OnImageSelectedListener() {
                    @Override
                    public void onImageSelected(Uri uri) {
                        Glide.with(AddItem.this).load(uri).into(imgv);
                        urimg=uri;
                    }
                })
                .create();

        tedBottomPicker.show(getSupportFragmentManager());
    }

    public void submit(View view){
        ItemModel im = new ItemModel(urimg,etname.getText().toString(),etdescr.getText().toString(),cat);
        im.save();
        startActivity(new Intent(this, AddItem.class));
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        cat=parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
