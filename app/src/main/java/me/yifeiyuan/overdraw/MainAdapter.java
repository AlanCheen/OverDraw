package me.yifeiyuan.overdraw;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by 程序亦非猿 on 16/12/13.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private static final String TAG = "MainAdapter";

    private ArrayList<String> mDatas;
    private Context mContext;

    public MainAdapter(Context context, ArrayList<String> datas) {
        mContext = context;
        mDatas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.coll_recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final int adapterPosition = holder.getAdapterPosition();
        final String entity = mDatas.get(adapterPosition);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mOnItemClickListener) {
                    mOnItemClickListener.onItemClick(holder, adapterPosition, entity);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public void setOnItemClickListener(onItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    private onItemClickListener mOnItemClickListener;

    public interface onItemClickListener {
        void onItemClick(ViewHolder holder, int position, String entity);
    }
}