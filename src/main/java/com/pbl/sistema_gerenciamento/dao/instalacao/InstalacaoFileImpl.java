package com.pbl.sistema_gerenciamento.dao.instalacao;


import com.pbl.sistema_gerenciamento.model.ComponenteOutro;
import com.pbl.sistema_gerenciamento.model.Instalacao;
import com.pbl.sistema_gerenciamento.utils.ManipulaArquivo;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa a interface InstalacaoDAO. Implementa funcionalidades de criação,
 * armazenagem, atualização e remoção de Instalações
 */
public class InstalacaoFileImpl implements InstalacaoDAO{
    private ManipulaArquivo manipulaArquivos;
    private int nextID;

    /**
     * Cria um objeto com a lista vazia e id inicial 0
     */
    public InstalacaoFileImpl() {
        this.manipulaArquivos = new ManipulaArquivo("instalacao.dat");
        ArrayList<Instalacao> lista = manipulaArquivos.retornar();
        this.nextID = lista.get(lista.size() - 1).getId() + 1;
    }

    /**
     * Cria um objeto e insere na lista
     *
     * @param obj o objeto a ser criado
     * @return o objeto criado
     */
    @Override
    public Instalacao criar(Instalacao obj) {
        ArrayList<Instalacao> lista = this.manipulaArquivos.retornar();

        obj.setId(nextID);
        this.nextID++;
        lista.add(obj);

        this.manipulaArquivos.guardar(lista);
        return obj;
    }

    /**
     * Encontra um objeto por meio de seu id
     *
     * @param id o id do objeto a ser encontrado
     * @return o objeto encontrado
     */
    @Override
    public Instalacao acharPorId(int id) {
        ArrayList<Instalacao> listaInstalacao = this.manipulaArquivos.retornar();
        for (Instalacao i : listaInstalacao){
            if (i.getId() == id){
                return i;
            }
        }
        return null;
    }

    /**
     * Encontra todos os objetos registrados
     *
     * @return a lista de objetos encontrados
     */
    @Override
    public List<Instalacao> acharTodos() {
        return manipulaArquivos.retornar();
    }

    /**
     * Atualiza um objeto da lista
     *
     * @param obj o objeto a ser atualizado
     * @return o objeto atualizado
     */
    @Override
    public Instalacao atualizar(Instalacao obj) {
        ArrayList<Instalacao> listaInstalacao = this.manipulaArquivos.retornar();
        for (Instalacao i : listaInstalacao){
            if (i.getId() == obj.getId()){
                listaInstalacao.set(listaInstalacao.indexOf(i), obj);
                this.manipulaArquivos.guardar(listaInstalacao);
                return i;
            }
        }
        return null;
    }

    /**
     * Deleta um objeto da lista por meio de seu id
     *
     * @param id o id do objeto a ser deletado
     */
    @Override
    public void deletar(int id) {
        ArrayList<Instalacao> listaInstalacao = this.manipulaArquivos.retornar();
        for (Instalacao i : listaInstalacao){
            if (i.getId() == id){
                listaInstalacao.remove(i);
                this.manipulaArquivos.guardar(listaInstalacao);
                return;
            }
        }
    }

    /**
     * Deleta a lista e cria uma nova. Redefine id inicial para 0
     */
    @Override
    public void deletarTodos() {
        ArrayList<Instalacao> listaInstalacao = this.manipulaArquivos.retornar();
        listaInstalacao.clear();
        this.nextID = 0;
        this.manipulaArquivos.guardar(listaInstalacao);
    }

    /**
     * Encontra objetos por meio de seus sistemas operacionais
     *
     * @param sist o sistema operacional sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    @Override
    public List<Instalacao> acharPorSO(String sist) {
        ArrayList<Instalacao> listaInstalacao = this.manipulaArquivos.retornar();
        ArrayList<Instalacao> listaSO = new ArrayList<Instalacao>();
        for (Instalacao i : listaInstalacao){
            if (i.getSistemaOperacional().equals(sist)){
                listaSO.add(i);
            }
        }
        return listaSO;
    }

    /**
     * Encontra objetos por meio de seus preços
     *
     * @param preco o preço sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    @Override
    public List<Instalacao> acharPorPreco(Double preco) {
        ArrayList<Instalacao> listaInstalacao = this.manipulaArquivos.retornar();
        ArrayList<Instalacao> listaPreco = new ArrayList<Instalacao>();
        for (Instalacao i : listaInstalacao){
            if (i.getPreco().equals(preco)){
                listaPreco.add(i);
            }
        }
        return listaPreco;

    }

    /**
     * Encontra objetos por meio de seus custos
     *
     * @param custo o custo sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    @Override
    public List<Instalacao> acharPorCusto(Double custo) {
        ArrayList<Instalacao> listaInstalacao = this.manipulaArquivos.retornar();
        ArrayList<Instalacao> listaCusto = new ArrayList<Instalacao>();
        for (Instalacao i : listaInstalacao){
            if (i.getCusto().equals(custo)){
                listaCusto.add(i);
            }
        }
        return listaCusto;
    }
}
