package mg.m1p9.kidsedu.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import mg.m1p9.kidsedu.R;
import mg.m1p9.kidsedu.activity.HomeActivity;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{

    Context context;
    int[] arrOfCategory;

    public HomeAdapter(Context context, int[] arrOfCategory) {
        this.context = context;
        this.arrOfCategory = arrOfCategory;
    }

    public int getItemCount() {
        return arrOfCategory.length;
    }


    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_list_start, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        Glide.with(context).load(arrOfCategory[i]).apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)).into(viewHolder.imgThumbnail);

        viewHolder.cVHomeCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, HomeActivity.class);
                intent1.putExtra("Type", 1);
                context.startActivity(intent1);
            }
        });
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        CardView cVHomeCategories;
        ImageView imgThumbnail;

        ViewHolder(@NonNull View view) {
            super(view);
            this.cVHomeCategories = view.findViewById(R.id.cVHomeCategories);
            this.imgThumbnail = view.findViewById(R.id.imgThumbnail);
        }
    }
}
