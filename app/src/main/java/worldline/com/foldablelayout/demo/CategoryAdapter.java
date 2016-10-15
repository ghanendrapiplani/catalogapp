package worldline.com.foldablelayout.demo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.util.List;

/**
 * Created by ghanendra on 13/10/2016.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.RvCircleCatergoryViewHolder> {
    List<CatModel> catList;
    Context mContext;

    public CategoryAdapter(Context mContext, List<CatModel> catList) {
        this.mContext = mContext;
        this.catList = catList;
    }

    @Override
    public CategoryAdapter.RvCircleCatergoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_firstpage, parent, false);
        RvCircleCatergoryViewHolder pvh = new RvCircleCatergoryViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(final CategoryAdapter.RvCircleCatergoryViewHolder holder, int position) {
//        Picasso.with(mContext).load(getDrawable(catList.get(position).getImg())).transform(new CircleTransform()).into(holder.img);
        Glide.with(mContext).load(getDrawable(catList.get(position).getImg())).asBitmap().centerCrop().into(new BitmapImageViewTarget(holder.img) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                holder.img.setImageDrawable(circularBitmapDrawable);
            }
        });
        holder.tv.setText(catList.get(position).getText());
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext,ItemsListActivity.class));
            }
        });
    }

    private int getDrawable(String img) {
        int resourceId = mContext.getResources().getIdentifier(img, "drawable", mContext.getPackageName());
        return resourceId;
    }

    @Override
    public int getItemCount() {
        return catList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class RvCircleCatergoryViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv;
        RvCircleCatergoryViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img1);
            tv=(TextView) itemView.findViewById(R.id.tvr);
        }

    }
}
