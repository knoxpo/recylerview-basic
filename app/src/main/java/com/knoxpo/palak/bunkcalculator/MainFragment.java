package com.knoxpo.palak.bunkcalculator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    private RecyclerView mListRV;

    private List<Bunk> mBunks;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container,false);
        init(v);

        BunkAdapter adapter = new BunkAdapter();
        mListRV.setAdapter(adapter);
        mListRV.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;
    }

    private void init(View v){
        mListRV = v.findViewById(R.id.rv_list);
        mBunks = new ArrayList<>();


        for(int i=0;i<100;i++){
            mBunks.add(new Bunk());
        }
    }

    private class BunkAdapter extends RecyclerView.Adapter<BunkVH>{

        private LayoutInflater mLayoutInflater;

        BunkAdapter(){
            mLayoutInflater = LayoutInflater.from(getActivity());
        }

        @NonNull
        @Override
        public BunkVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = mLayoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            return new BunkVH(view);
        }

        @Override
        public void onBindViewHolder(@NonNull  BunkVH holder, int position) {
            holder.bindBunk(mBunks.get(position));
        }

        @Override
        public int getItemCount() {
            return mBunks.size();
        }
    }

    private class BunkVH extends RecyclerView.ViewHolder{

        public BunkVH(View itemView) {
            super(itemView);
        }

        public void bindBunk(Bunk bunk){
            ((TextView)itemView).setText(bunk.getDate().toString());
        }
    }
}