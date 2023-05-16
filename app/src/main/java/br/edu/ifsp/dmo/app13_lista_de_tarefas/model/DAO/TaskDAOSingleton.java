package br.edu.ifsp.dmo.app13_lista_de_tarefas.model.DAO;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dmo.app13_lista_de_tarefas.model.Entities.Tag;
import br.edu.ifsp.dmo.app13_lista_de_tarefas.model.Entities.Task;

public class TaskDAOSingleton implements ITaskDAO{
    private static TaskDAOSingleton instance = null;
    private List<Task> dataset;

    private TaskDAOSingleton() {
        dataset = new ArrayList<>();
    }

    public static TaskDAOSingleton getInstance(){
        if(instance == null)
            instance = new TaskDAOSingleton();
        return instance;
    }



    @Override
    public void create(Task task) {
        if(task != null){
            dataset.add(task);
        }
    }

    @Override
    public boolean update(String oldTitle, Task task) {
        Task inDataset;
        inDataset = dataset.stream()
                .filter(task1 -> task1.getTitle().equals(oldTitle))
                .findAny()
                .orElse(null);
        if(inDataset != null){
            inDataset.setTitle(task.getTitle());
            inDataset.setDescription(task.getDescription());
            inDataset.setImportant(task.isImportant());
            inDataset.getTags().clear();
            inDataset.getTags().addAll(task.getTags());
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Task task) {
        return dataset.remove(task);
    }

    @Override
    public Task findByTitle(String title) {
        return dataset.stream()
                .filter(task -> task.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Task> findByTag(Tag tag) {
        List<Task> selection = new ArrayList<>();
        for(Task a : dataset){
            for(Tag t : a.getTags()){
                if(t.getTagName().equals(tag.getTagName())){
                    selection.add(a);
                }
            }
        }
        return selection;
    }

    @Override
    public List<Task> findAll() {
        return dataset;
    }
}
