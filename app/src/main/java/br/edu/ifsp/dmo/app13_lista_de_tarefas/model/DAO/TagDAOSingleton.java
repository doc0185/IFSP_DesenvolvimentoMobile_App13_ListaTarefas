package br.edu.ifsp.dmo.app13_lista_de_tarefas.model.DAO;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dmo.app13_lista_de_tarefas.model.Entities.Tag;

public class TagDAOSingleton implements ITagDAO{
    private static TagDAOSingleton instance;
    private List<Tag> dataset;

    private TagDAOSingleton(){
        dataset = new ArrayList<>();
    }

    public static TagDAOSingleton getInstance(){
        if(instance == null)
            instance = new TagDAOSingleton();
        return instance;
    }

    @Override
    public void create(Tag tag) {
        if(tag != null){
            if(find(tag.getTagName()) == null){
                dataset.add(tag);
            }
        }
    }

    @Override
    public boolean delete(Tag tag) {
        return dataset.remove(tag);
    }

    @Override
    public Tag find(String tagName) {
        return dataset.stream()
                .filter(tag -> tag.getTagName().equals(tagName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Tag> findAll() {
        return dataset;
    }
}
