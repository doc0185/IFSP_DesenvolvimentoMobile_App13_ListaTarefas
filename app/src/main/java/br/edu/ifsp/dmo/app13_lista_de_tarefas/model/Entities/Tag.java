package br.edu.ifsp.dmo.app13_lista_de_tarefas.model.Entities;

public class Tag {
    private String tagName;

    public Tag(String tagName){
        this.tagName = tagName;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
