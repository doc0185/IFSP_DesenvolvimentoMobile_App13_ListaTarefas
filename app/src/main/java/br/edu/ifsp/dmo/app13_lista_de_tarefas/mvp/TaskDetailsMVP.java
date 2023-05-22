package br.edu.ifsp.dmo.app13_lista_de_tarefas.mvp;

import android.content.Context;
import android.os.Bundle;

public interface TaskDetailsMVP {
    interface View{
        Context getContext();

        void updateUI(String title, String description, String creationDate);

        Bundle getBundle();

        void showToast(String message);

        void close();
    }

    interface Presenter{
        void deatach();

        void verifyUpdate();

        void saveTask(String title, String description);
    }
}
