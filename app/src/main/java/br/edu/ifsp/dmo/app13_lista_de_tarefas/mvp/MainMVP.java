package br.edu.ifsp.dmo.app13_lista_de_tarefas.mvp;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import br.edu.ifsp.dmo.app13_lista_de_tarefas.model.Entities.Task;

public interface MainMVP {
    interface View{
        Context getContext();
    }

    interface Presenter{
        void deatach();

        void openDetails();

        void openDetails(Task task);

        void populateList(RecyclerView recyclerView);

        void favoriteTask(Task task);
    }
}
