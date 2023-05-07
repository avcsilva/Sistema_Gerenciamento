package com.pbl.sistema_gerenciamento.dao.ordemservico;

import com.pbl.sistema_gerenciamento.model.OrdemServico;
import com.pbl.sistema_gerenciamento.utils.ManipulaArquivo;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa a interface OrdemServicoDAO. Implementa funcionalidades de criação,
 * armazenagem, atualização e remoção de Ordens de Serviço
 */
public class OrdemServicoFileImpl implements OrdemServicoDAO{
    private ManipulaArquivo manipulaArquivo;
    private int nextID;

    /**
     * Cria um objeto com a lista vazia e id inicial 0
     */
    public OrdemServicoFileImpl() {
        this.manipulaArquivo = new ManipulaArquivo("ordemServico.dat");
        ArrayList<OrdemServico> listaOrdem = this.manipulaArquivo.retornar();
        if (listaOrdem.size() > 0) {
            this.nextID = listaOrdem.get(listaOrdem.size() - 1).getId() + 1;
        } else this.nextID = 0;
    }

    /**
     * Cria um objeto e insere na lista
     *
     * @param obj o objeto a ser criado
     * @return o objeto criado
     */
    @Override
    public OrdemServico criar(OrdemServico obj) {
        ArrayList<OrdemServico> listaOrdem = this.manipulaArquivo.retornar();
        obj.setId(nextID);
        this.nextID++;
        listaOrdem.add(obj);
        this.manipulaArquivo.guardar(listaOrdem);
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
        ArrayList<OrdemServico> listaOrdem = this.manipulaArquivo.retornar();
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
        return this.manipulaArquivo.retornar();
    }

    /**
     * Atualiza um objeto da lista
     *
     * @param obj o objeto a ser atualizado
     * @return o objeto atualizado
     */
    @Override
    public OrdemServico atualizar(OrdemServico obj) {
        ArrayList<OrdemServico> listaOrdem = this.manipulaArquivo.retornar();
        for (OrdemServico o : listaOrdem){
            if (o.getId() == obj.getId()){
                listaOrdem.set(listaOrdem.indexOf(o), obj);
                this.manipulaArquivo.guardar(listaOrdem);
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
        ArrayList<OrdemServico> listaOrdem = this.manipulaArquivo.retornar();
        for (OrdemServico o : listaOrdem){
            if (o.getId() == id){
                listaOrdem.remove(o);
                this.manipulaArquivo.guardar(listaOrdem);
                return;
            }
        }
    }

    /**
     * Deleta a lista e cria uma nova. Redefine id inicial para 0
     */
    @Override
    public void deletarTodos() {
        ArrayList<OrdemServico> listaOrdem = this.manipulaArquivo.retornar();
        listaOrdem.clear();
        this.manipulaArquivo.guardar(listaOrdem);
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
        ArrayList<OrdemServico> listaOrdem = this.manipulaArquivo.retornar();
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
        ArrayList<OrdemServico> listaOrdem = this.manipulaArquivo.retornar();
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
        ArrayList<OrdemServico> listaOrdem = this.manipulaArquivo.retornar();
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
        ArrayList<OrdemServico> listaOrdem = this.manipulaArquivo.retornar();
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
        ArrayList<OrdemServico> listaOrdem = this.manipulaArquivo.retornar();
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
        ArrayList<OrdemServico> listaOrdem = this.manipulaArquivo.retornar();
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
        ArrayList<OrdemServico> listaOrdem = this.manipulaArquivo.retornar();
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
        ArrayList<OrdemServico> listaOrdem = this.manipulaArquivo.retornar();
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
        ArrayList<OrdemServico> listaOrdem = this.manipulaArquivo.retornar();
        for (OrdemServico o : listaOrdem){
            if (o.getStatus().equals("em aberto")){
                return o;
            }
        }
        return null;
    }
}