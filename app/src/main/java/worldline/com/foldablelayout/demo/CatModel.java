package worldline.com.foldablelayout.demo;

import android.graphics.drawable.Drawable;

/**
 * Created by ghanendra on 14/10/2016.
 */
public class CatModel {
    String img,text;

    public CatModel(String img, String text) {
        this.img = img;
        this.text = text;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
