package adapter;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.design.material.materialdesign.DetailActivity;
import com.design.material.materialdesign.MainActivity;
import com.design.material.materialdesign.R;
import com.design.material.materialdesign.widgets.SquareImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import global.GlobalApplication;
import utils.LogUtils;

/**
 * Created by Administrator on 2016/7/1.
 */
public class ImageRecyAdapter extends RecyclerView.Adapter<ImageRecyAdapter.MyViewHolder> implements View.OnClickListener {
    Context context;
    private List<ViewModel> list;

    Bitmap bitmap;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public ImageRecyAdapter(Context context,List<ViewModel> list){
        this.context=context;
        this.list=list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.imagerecyitem, parent, false);
        v.setOnClickListener(this);
        return new MyViewHolder(v);
      //  MyViewHolder holder = new MyViewHolder(View.inflate(parent.getContext(), R.layout.imagerecyitem, null));

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        ViewModel viewModel=list.get(position);
        //holder.sdvImage.setImageURI(Uri.parse(viewModel.getImage()));
        holder.sdvImage.setImageBitmap(null);
        Picasso.with(holder.sdvImage.getContext()).load(Uri.parse(viewModel.getImage())).into(holder.sdvImage);
        holder.itemView.setTag(list.get(position));
       /* Palette.generateAsync(convertViewToBitmap(holder.sdvImage,30),24,
                new Palette.PaletteAsyncListener() {
                    @Override
                    public void onGenerated(Palette palette) {
                        Palette.Swatch vibrant =
                                palette.getVibrantSwatch();
                        LogUtils.e(getClass(),"vibrant颜色值是"+vibrant.toString());
                        if(vibrant!=null){
                            // If we have a vibrant color
                            // update the title TextView
                            holder.ll_color.setBackgroundColor(
                                    vibrant.getRgb());
                            LogUtils.e(getClass(),"背景颜色是："+vibrant.getRgb());
                            holder.tv_color.setTextColor(
                                    vibrant.getTitleTextColor());
                            LogUtils.e(getClass(),"文字颜色是："+vibrant.getTitleTextColor());
                        }
                    }
                });*/
    }
    public static Bitmap convertViewToBitmap(View view,int targetMaxDimension){
        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();
        final int maxDimension = Math.max(bitmap.getWidth(), bitmap.getHeight());
        if (maxDimension <= targetMaxDimension) {
            return bitmap;
        }
        final float scaleRatio = targetMaxDimension / (float) maxDimension;
        return Bitmap.createScaledBitmap(bitmap,
                Math.round(bitmap.getWidth() * scaleRatio),
                Math.round(bitmap.getHeight() * scaleRatio),
                false);
    }
    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    @Override
    public void onClick(final View v) {
        onItemClickListener.onItemClick(v,(ViewModel) v.getTag());
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        SquareImageView sdvImage;
        LinearLayout ll_color;
        TextView tv_color;
        public MyViewHolder(View itemView) {
            super(itemView);
            sdvImage= (SquareImageView) itemView.findViewById(R.id.image);
            ll_color= (LinearLayout) itemView.findViewById(R.id.ll_color);
            tv_color= (TextView) itemView.findViewById(R.id.tv_color);
        }

    }
    public interface OnItemClickListener {

        void onItemClick(View view,ViewModel viewModel);

    }
}
