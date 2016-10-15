package worldline.com.foldablelayout.demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ghanendra on 13/10/2016.
 */
public class DescriptionAdapter extends RecyclerView.Adapter<DescriptionAdapter.RvDishViewHolder> {
    List<String> paidlist;
    Context mContext;

    public DescriptionAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public DescriptionAdapter.RvDishViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dish_row_item, parent, false);
        RvDishViewHolder pvh = new RvDishViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(DescriptionAdapter.RvDishViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class RvDishViewHolder extends RecyclerView.ViewHolder {
        RvDishViewHolder(View itemView) {
            super(itemView);
        }
    }
}
