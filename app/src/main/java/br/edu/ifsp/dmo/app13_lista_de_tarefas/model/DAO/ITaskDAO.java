package br.edu.ifsp.dmo.app13_lista_de_tarefas.model.DAO;

import java.util.List;

import br.edu.ifsp.dmo.app13_lista_de_tarefas.model.Entities.Tag;
import br.edu.ifsp.dmo.app13_lista_de_tarefas.model.Entities.Task;

public interface ITaskDAO {
    void create(Task task);

    boolean update(String oldTitle, Task task);

    boolean delete(Task task);

    Task findByTitle(String title);

    List<Task> findByTag(Tag tag);

    List<Task> findAll();
}
