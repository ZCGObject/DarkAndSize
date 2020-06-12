package com.ikang.mydark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class RecyclerviewSnapActivity extends AppCompatActivity {

    private List<Integer> list = new ArrayList<>();
    private RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_snap);


        rv = findViewById(R.id.rv);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 3; j++) {
                switch (j){
                    case 0:
                        list.add(R.drawable.guide_one);
                        break;
                    case 1:
                        list.add(R.drawable.guide_two);
                        break;
                    case 2:
                        list.add(R.drawable.guide_three);
                        break;
                }
            }
        }



        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(manager);

        LinearSnapHelper snapHelper = new LinearSnapHelper();
//        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(rv);

        rv.setAdapter(new RvAdapter(this, list));

    }


    public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder>{

        private Context context;
        private List<Integer> list;
        private View inflater;

        //构造方法，传入数据
        public RvAdapter(Context context, List<Integer> list){
            this.context = context;
            this.list = list;
        }


        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            inflater = LayoutInflater.from(context).inflate(R.layout.item_demo,parent,false);
            MyViewHolder myViewHolder = new MyViewHolder(inflater);
            return myViewHolder;
        }


        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.iv.setImageResource(list.get(position));
            holder.tv.setText("这是第" + position + "---" + position + "个图片");
        }


        @Override
        public int getItemCount() {
            return list.size();
        }

        //内部类，绑定控件
        class MyViewHolder extends RecyclerView.ViewHolder{
            ImageView iv;
            TextView tv;
            public MyViewHolder(View itemView) {
                super(itemView);
                iv = itemView.findViewById(R.id.iv);
                tv = itemView.findViewById(R.id.tv);
            }
        }
    }


}