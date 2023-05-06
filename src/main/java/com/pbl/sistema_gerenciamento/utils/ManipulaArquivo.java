package com.pbl.sistema_gerenciamento.utils;

import java.io.*;
import java.util.List;

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
    public <T> void guardar(List<T> objeto){
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
    public <T> List<T> retorna(){
        try {
        List<T> objeto;
        FileInputStream fileStream = new FileInputStream(this.nomeArquivo);
        ObjectInputStream os = new ObjectInputStream(fileStream);
        objeto = (List<T>) os.readObject();
        os.close();
        return objeto;
        }
        catch (IOException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
