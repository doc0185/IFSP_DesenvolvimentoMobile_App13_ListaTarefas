package br.edu.ifsp.dmo.app13_lista_de_tarefas.model.DAO;

import java.util.List;

import br.edu.ifsp.dmo.app13_lista_de_tarefas.model.Entities.Tag;

public interface ITagDAO {
    void create(Tag tag);

    boolean delete(Tag tag);

    Tag find(String tagName);

    List<Tag> findAll();
}
