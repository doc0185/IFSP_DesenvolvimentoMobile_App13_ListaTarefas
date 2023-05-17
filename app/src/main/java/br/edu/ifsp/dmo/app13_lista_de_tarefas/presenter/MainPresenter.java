package br.edu.ifsp.dmo.app13_lista_de_tarefas.presenter;

import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import br.edu.ifsp.dmo.app13_lista_de_tarefas.model.DAO.ITaskDAO;
import br.edu.ifsp.dmo.app13_lista_de_tarefas.model.DAO.TaskDAOSingleton;
import br.edu.ifsp.dmo.app13_lista_de_tarefas.model.Entities.Task;
import br.edu.ifsp.dmo.app13_lista_de_tarefas.mvp.MainMVP;
import br.edu.ifsp.dmo.app13_lista_de_tarefas.utils.Constant;
import br.edu.ifsp.dmo.app13_lista_de_tarefas.view.RecyclerViewItemClickListener;
import br.edu.ifsp.dmo.app13_lista_de_tarefas.view.TasksDetailsActivity;
import br.edu.ifsp.dmo.app13_lista_de_tarefas.view.adapter.ItemPocketRecyclerAdapter;

public class MainPresenter implements MainMVP.Presenter{
    private MainMVP.View view;
    private ITaskDAO dao;
    Task task;

    public MainPresenter(MainMVP.View view) {
        this.view = view;
        dao = TaskDAOSingleton.getInstance();
    }


    @Override
    public void deatach() {
        view = null;
    }

    @Override
    public void openDetails() {
        Intent intent = new Intent(view.getContext(), TasksDetailsActivity.class);
        view.getContext().startActivity(intent);
    }

    @Override
    public void openDetails(Task task) {
        Intent intent = new Intent(view.getContext(), TasksDetailsActivity.class);
        intent.putExtra(Constant.ATTR_TITLE, task.getTitle());
        view.getContext().startActivity(intent);
    }

    @Override
    public void populateList(RecyclerView recyclerView) {

        ItemPocketRecyclerAdapter adapter = new
                ItemPocketRecyclerAdapter(view.getContext(), dao.findAll(), this);
        /*
        adapter.setClickListener(new RecyclerViewItemClickListener() {
            @Override
            public void onItemClick(int position) {
                task = dao.findAll().get(position);
                openDetails(task);
            }
        }); */
        RecyclerView.LayoutManager layoutManager = new
                LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void favoriteTask(Task task) {
        task.setImportant(!task.isImportant());
        dao.update(task.getTitle(), task);
    }

    public void deleteTask(Task task){
        dao.delete(task);
    }
}
