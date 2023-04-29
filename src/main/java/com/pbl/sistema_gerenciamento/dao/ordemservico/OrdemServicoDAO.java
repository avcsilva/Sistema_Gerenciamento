package com.pbl.sistema_gerenciamento.dao.ordemservico;

import com.pbl.sistema_gerenciamento.dao.CRUD;
import com.pbl.sistema_gerenciamento.model.OrdemServico;

import java.util.List;

/**
 * Interface DAO que extende CRUD para ser implementada em classes de manipulação de objetos Ordens de Serviço
 */
public interface OrdemServicoDAO extends CRUD<OrdemServico> {

    /**
     * Encontra objetos por meio do id de seus Técnicos registrados
     *
     * @param tecnicoID o id de Técnico sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    public List<OrdemServico> acharPorTecnico(int tecnicoID);

    /**
     * Encontra objetos por meio de seus status
     *
     * @param status o status sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    public List<OrdemServico> acharPorStatus(String status);

    /**
     * Encontra objetos por meio do id de seus Clientes registrados
     *
     * @param clienteID o id de Cliente sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    public List<OrdemServico> acharPorCliente(int clienteID);

    /**
     * Encontra objetos por meio de suas datas
     *
     * @param comeco a data sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    public List<OrdemServico> acharPorDataC(String comeco);

    /**
     * Encontra objetos por meio de suas datas
     *
     * @param fim a data sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    public List<OrdemServico> acharPorDataF(String fim);

    /**
     * Encontra objetos por meio de seus preços
     *
     * @param preco o preço sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    public List<OrdemServico> acharPorPreco(Double preco);

    /**
     * Encontra objetos por meio de seus custos
     *
     * @param custo o custo sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    public List<OrdemServico> acharPorCusto(Double custo);

    /**
     * Encontra objetos por meio de seus métodos de pagamento
     *
     * @param mp o método de pagamento sobre os quais objetos devem ser encontrados
     * @return a lista de objetos encontrados
     */
    public List<OrdemServico> acharPorMetPag(String mp);

    /**
     * Encontra a próxima Ordem de Serviço em aberto
     */
    public OrdemServico proximaOrdem();
}
