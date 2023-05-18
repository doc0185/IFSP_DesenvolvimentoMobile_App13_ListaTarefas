package br.edu.ifsp.dmo.app13_lista_de_tarefas.model.Entities;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task implements Comparable<Task>{
    private String title;
    private String description;
    private String creationDate;
    private boolean important;
    private List<Tag> tags;

    private void init(){
        tags = new ArrayList<>();
    }

    public Task(String title, String description, String creationDate){
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        init();
    }

    public Task(String title, String description, String creationDate, boolean important) {
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.important = important;
        init();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean isImportant() {
        return important;
    }

    public void setImportant(Boolean important) {
        this.important = important;
    }

    public void addTag(Tag tag){
        this.tags.add(tag);
    }

    public boolean removeTag(Tag tag){
        return this.tags.remove(tag);
    }

    public List<Tag> getTags() {
        return tags;
    }



    @NonNull
    @Override
    public String toString() {
        return "Title: " + title;
    }

    @Override
    public int compareTo(Task task) {
        //return this.isImportant().compareTo(task.isImportant());
        return Comparator.comparing(Task::isImportant).reversed().thenComparing(Task::getTitle).compare(this, task);
        //return this.title.compareTo(task.title);

    }
}
