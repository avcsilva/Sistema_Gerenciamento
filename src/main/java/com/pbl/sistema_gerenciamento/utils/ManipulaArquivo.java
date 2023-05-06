package com.pbl.sistema_gerenciamento.utils;

import java.io.*;
import java.util.ArrayList;

public class ManipulaArquivo {
    private String nomeArquivo;

    /**
     *
     * @param nome
     */
    public ManipulaArquivo(String nome){
        this.nomeArquivo = nome;
    }

    /**
     *
     * @param objeto
     * @param <T>
     */
    public <T> void guardar(ArrayList<T> objeto){
        try {
            FileOutputStream fileStream = new FileOutputStream(this.nomeArquivo);
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(objeto);
            os.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @return
     * @param <T>
     */
    public <T> ArrayList<T> retornar(){
        try {
        ArrayList<T> objeto;

        File arquivo = new File(nomeArquivo);
        if (!arquivo.exists()){
            guardar(new ArrayList<T>());
        }

        FileInputStream fileStream = new FileInputStream(this.nomeArquivo);
        ObjectInputStream os = new ObjectInputStream(fileStream);
        objeto = (ArrayList<T>) os.readObject();
        os.close();
        return objeto;
        }
        catch (IOException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
