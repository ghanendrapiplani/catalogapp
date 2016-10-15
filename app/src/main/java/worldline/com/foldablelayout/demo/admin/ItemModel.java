package worldline.com.foldablelayout.demo.admin;

import android.net.Uri;

import com.orm.SugarRecord;

/**
 * Created by ghanendra on 16/10/2016.
 */
public class ItemModel extends SugarRecord {
    Uri image;
    String itemname,itemdescr,cat;

    public Uri getImage() {
        return image;
    }

    public ItemModel(Uri image, String itemname, String itemdescr,String cat) {
        this.image = image;
        this.itemname = itemname;
        this.itemdescr = itemdescr;
        this.cat=cat;
    }

    public void setImage(Uri image) {
        this.image = image;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getItemdescr() {
        return itemdescr;
    }

    public void setItemdescr(String itemdescr) {
        this.itemdescr = itemdescr;
    }

    public ItemModel() {
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }
}
