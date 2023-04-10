package com.pbl.sistema_gerenciamento.dao.instalacao;

import com.pbl.sistema_gerenciamento.model.Instalacao;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa a interface InstalacaoDAO. Implementa funcionalidades de criação,
 * armazenagem, atualização e remoção de Instalações
 */
public class InstalacaoListImpl implements InstalacaoDAO{
    private ArrayList<Instalacao> listaInstalacao;
    private int nextID;

    /**
     * Cria um objeto com a lista vazia e id inicial 0
     */
    public InstalacaoListImpl() {
        this.listaInstalacao = new ArrayList<Instalacao>();
        this.nextID = 0;
    }

    /**
     * Cria um objeto e insere na lista
     *
     * @param obj o objeto a ser criado
     * @return o objeto criado
     */
    @Override
    public Instalacao criar(Instalacao obj) {
        obj.setId(nextID);
        this.nextID++;
        this.listaInstalacao.add(obj);
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
        for(Instalacao i: listaInstalacao){
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
        return listaInstalacao;
    }

    /**
     * Atualiza um objeto da lista
     *
     * @param obj o objeto a ser atualizado
     * @return o objeto atualizado
     */
    @Override
    public Instalacao atualizar(Instalacao obj) {
        for (Instalacao i : listaInstalacao){
            if (i.getId() == obj.getId()){
                this.listaInstalacao.set(listaInstalacao.indexOf(i), obj);
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
        for (Instalacao i: listaInstalacao){
            if(i.getId() == id){
                this.listaInstalacao.remove(i);
                return;
            }
        }
    }

    /**
     * Deleta a lista e cria uma nova. Redefine id inicial para 0
     */
    @Override
    public void deletarTodos() {
        this.listaInstalacao.clear();
        this.nextID = 0;
    }

    /**
     * Encontra objetos por meio de seus sistemas operacionais
     *
     * @param sist o sistema operacional sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    @Override
    public List<Instalacao> acharPorSO(String sist) {
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
        ArrayList<Instalacao> listaPreco = new ArrayList<Instalacao>();
        for (Instalacao o : listaInstalacao){
            if (o.getPreco().equals(preco)){
                listaPreco.add(o);
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
        ArrayList<Instalacao> listaCusto = new ArrayList<Instalacao>();
        for (Instalacao o : listaInstalacao){
            if (o.getCusto().equals(custo)){
                listaCusto.add(o);
            }
        }
        return listaCusto;
    }
}
