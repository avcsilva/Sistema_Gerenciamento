package com.pbl.sistema_gerenciamento.dao.ordemservico;

import com.pbl.sistema_gerenciamento.model.OrdemServico;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa a interface OrdemServicoDAO. Implementa funcionalidades de criação,
 * armazenagem, atualização e remoção de Ordens de Serviço
 */
public class OrdemServicoListImpl implements OrdemServicoDAO{
    private ArrayList<OrdemServico> listaOrdem;
    private int nextID;

    /**
     * Cria um objeto com a lista vazia e id inicial 0
     */
    public OrdemServicoListImpl() {
        this.listaOrdem = new ArrayList<OrdemServico>();
        this.nextID = 0;
    }

    /**
     * Cria um objeto e insere na lista
     *
     * @param obj o objeto a ser criado
     * @return o objeto criado
     */
    @Override
    public OrdemServico criar(OrdemServico obj) {
        obj.setId(nextID);
        this.nextID++;
        this.listaOrdem.add(obj);
        return obj;
    }

    /**
     * Encontra um objeto por meio de seu id
     *
     * @param id o id do objeto a ser encontrado
     * @return o objeto encontrado
     */
    @Override
    public OrdemServico acharPorId(int id) {
        for(OrdemServico o: listaOrdem){
            if (o.getId() == id){
                return o;
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
    public List<OrdemServico> acharTodos() {
        return listaOrdem;
    }

    /**
     * Atualiza um objeto da lista
     *
     * @param obj o objeto a ser atualizado
     * @return o objeto atualizado
     */
    @Override
    public OrdemServico atualizar(OrdemServico obj) {
        for (OrdemServico o : listaOrdem){
            if (o.getId() == obj.getId()){
                this.listaOrdem.set(listaOrdem.indexOf(o), obj);
                return o;
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
        for (OrdemServico o : listaOrdem){
            if (o.getId() == id){
                this.listaOrdem.remove(o);
                return;
            }
        }
    }

    /**
     * Deleta a lista e cria uma nova. Redefine id inicial para 0
     */
    @Override
    public void deletarTodos() {
        this.listaOrdem.clear();
        this.nextID = 0;
    }

    /**
     * Encontra objetos por meio do id de seus Técnicos registrados
     *
     * @param tecnicoID o id de Técnico sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    @Override
    public List<OrdemServico> acharPorTecnico(int tecnicoID) {
        ArrayList<OrdemServico> listaTecnico = new ArrayList<OrdemServico>();
        for (OrdemServico o : listaOrdem){
            if (o.getTecnico().getId() == tecnicoID){
                listaTecnico.add(o);
            }
        }
        return listaTecnico;
    }

    /**
     * Encontra objetos por meio de seus status
     *
     * @param status o status sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    @Override
    public List<OrdemServico> acharPorStatus(String status) {
        ArrayList<OrdemServico> listaStatus = new ArrayList<OrdemServico>();
        for (OrdemServico o : listaOrdem){
            if (o.getStatus().equals(status)){
                listaStatus.add(o);
            }
        }
        return listaStatus;
    }

    /**
     * Encontra objetos por meio do id de seus Clientes registrados
     *
     * @param clienteID o id de Cliente sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    @Override
    public List<OrdemServico> acharPorCliente(int clienteID) {
        ArrayList<OrdemServico> listaCliente = new ArrayList<OrdemServico>();
        for (OrdemServico o : listaOrdem){
            if (o.getCliente().getId() == clienteID){
                listaCliente.add(o);
            }
        }
        return listaCliente;
    }

    /**
     * Encontra objetos por meio de suas datas
     *
     * @param comeco a data sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    @Override
    public List<OrdemServico> acharPorDataC(String comeco) {
        ArrayList<OrdemServico> listaCriacao = new ArrayList<OrdemServico>();
        for (OrdemServico o : listaOrdem){
            if (o.getCriacao().equals(comeco)){
                listaCriacao.add(o);
            }
        }
        return listaCriacao;
    }

    /**
     * Encontra objetos por meio de suas datas
     *
     * @param fim a data sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    @Override
    public List<OrdemServico> acharPorDataF(String fim) {
        ArrayList<OrdemServico> listaFim = new ArrayList<OrdemServico>();
        for (OrdemServico o : listaOrdem){
            if (o.getFinalizacao().equals(fim)){
                listaFim.add(o);
            }
        }
        return listaFim;
    }

    /**
     * Encontra objetos por meio de seus preços
     *
     * @param preco o preço sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    @Override
    public List<OrdemServico> acharPorPreco(Double preco) {
        ArrayList<OrdemServico> listaPreco = new ArrayList<OrdemServico>();
        for (OrdemServico o : listaOrdem){
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
    public List<OrdemServico> acharPorCusto(Double custo) {
        ArrayList<OrdemServico> listaCusto = new ArrayList<OrdemServico>();
        for (OrdemServico o : listaOrdem){
            if (o.getCusto().equals(custo)){
                listaCusto.add(o);
            }
        }
        return listaCusto;
    }

    /**
     * Encontra objetos por meio de seus métodos de pagamento
     *
     * @param mp o método de pagamento sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    @Override
    public List<OrdemServico> acharPorMetPag(String mp) {
        ArrayList<OrdemServico> listaMetPag = new ArrayList<OrdemServico>();
        for (OrdemServico o : listaOrdem){
            if (o.getMetodoPagamento().equals(mp)){
                listaMetPag.add(o);
            }
        }
        return listaMetPag;
    }

    /**
     * Encontra a próxima Ordem de Serviço em aberto
     *
     * @return a próxima Ordem de Serviço em aberto
     */
    @Override
    public OrdemServico proximaOrdem() {
        for (OrdemServico o : listaOrdem){
            if (o.getStatus().equals("em aberto")){
                return o;
            }
        }
        return null;
    }
}
