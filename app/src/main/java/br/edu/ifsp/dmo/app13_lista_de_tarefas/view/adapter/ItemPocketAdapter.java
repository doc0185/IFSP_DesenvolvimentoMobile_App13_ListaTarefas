package br.edu.ifsp.dmo.app13_lista_de_tarefas.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import java.util.List;

import br.edu.ifsp.dmo.app13_lista_de_tarefas.R;
import br.edu.ifsp.dmo.app13_lista_de_tarefas.model.Entities.Task;
import br.edu.ifsp.dmo.app13_lista_de_tarefas.mvp.MainMVP;

public class ItemPocketAdapter extends ArrayAdapter {
    private LayoutInflater inflater;
    private MainMVP.Presenter presenter;

    public ItemPocketAdapter(Context context, List<Task> data, MainMVP.Presenter presenter){
        super(context, R.layout.recycledview_item, data);
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.presenter = presenter;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final ViewHolder holder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.recycledview_item, null);
            holder = new ViewHolder();
            holder.titleTextView = convertView.findViewById(R.id.text_title_listitem);
            holder.starImageView = convertView.findViewById(R.id.imageView);
            holder.pencilImageView = convertView.findViewById(R.id.imageView2);

            holder.starImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    starClick(position);
                }
            });

            holder.pencilImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pencilClick(position);
                }
            });

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Task task = (Task) getItem(position);
        holder.titleTextView.setText(task.getTitle());

        if(task.isImportant()){
            holder.starImageView.setColorFilter(getContext().getColor(R.color.white));
        }else{
            holder.starImageView.setColorFilter(getContext().getColor(R.color.black));
        }

        return convertView;
    }

    private void starClick(int position){
        Task task = (Task) getItem(position);
        presenter.favoriteTask(task);
        notifyDataSetChanged();
    }

    private void pencilClick(int position){
        Task task = (Task) getItem(position);
        presenter.openDetails(task);
        notifyDataSetChanged();
    }

    private static class ViewHolder{
        public TextView titleTextView;
        public ImageView starImageView;
        public ImageView pencilImageView;
    }
}
