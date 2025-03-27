package com.trabalho.ifood.services;

import com.trabalho.ifood.domains.*;
import com.trabalho.ifood.domains.enums.StatusPedido;
import com.trabalho.ifood.domains.enums.StatusProduto;
import com.trabalho.ifood.domains.enums.TipoEntrega;
import com.trabalho.ifood.domains.enums.TipoProduto;
import com.trabalho.ifood.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private EstabelecimentoRepository EstabelecimentoRepository;

    @Autowired
    private PedidoRepository PedidoRepository;

    @Autowired
    private ClienteRepository ClienteRepository;

    @Autowired
    private EntregadorRepository EntregadorRepository;

    @Autowired
    private ProdutoRepository ProdutoRepository;

    @Autowired
    private GrupoProdutoRepository GrupoProdutoRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    public void initDB() {
        Entregador Entregador01 = new Entregador(null, "Cadmiel", "Rua Severino Pai", "17994786539", "98778976587");
        Cliente Cliente01 = new Cliente(null, "Mateus", "Rua Amildo Filho", "17992868282", "12332112365");
        Entregador Entregador02 = new Entregador(null, "Vitin", "Rua Fernando Alonso", "1792347632", "23467890955");
        Cliente Cliente02 = new Cliente(null, "Pedro", "Rua Luis Hamilton", "17998653987", "12356789764");
        
        Estabelecimento Estabelecimento01 = new Estabelecimento(null, "11-111-1111111-11", "Vovó das Marmita", "Caseira", "5.0", new BigDecimal("2.99"));

        Estabelecimento Estabelecimento02 = new Estabelecimento(null, "22-222-2222222-22", "Burguer King", "Fast-Food", "4.5", new BigDecimal("13.90"));

        ClienteRepository.save(Cliente01);
        ClienteRepository.save(Cliente02);
        EntregadorRepository.save(Entregador01);
        EntregadorRepository.save(Entregador02);
        EstabelecimentoRepository.save(Estabelecimento01);
        EstabelecimentoRepository.save(Estabelecimento02);

        GrupoProduto grupo01 = new GrupoProduto(0,"Refrigerantes", TipoProduto.COMIDA);
        GrupoProduto grupo02 = new GrupoProduto(0,"Snacks", TipoProduto.BEBIDA);

        GrupoProdutoRepository.save(grupo01);
        GrupoProdutoRepository.save(grupo02);


        Produto produto01 = new Produto(null,"1111", "Coca Cola", new BigDecimal("10"), new BigDecimal("2.0"),
                LocalDate.now(),grupo01, StatusProduto.ATIVO);
        Produto produto02 = new Produto(null,"2222", "Guarana Antartica", new BigDecimal("20"), new BigDecimal("3.0"),
                LocalDate.now(),grupo01,StatusProduto.ATIVO);
        Produto produto03 = new Produto(null, "3333","Ruffles", new BigDecimal("30"), new BigDecimal("2.0"),
                LocalDate.now(),grupo02,StatusProduto.ATIVO);
        Produto produto04 = new Produto(null,"4444", "Doritos", new BigDecimal("20"), new BigDecimal("2.0"),
                LocalDate.now(),grupo02,StatusProduto.ATIVO);

        ProdutoRepository.save(produto01);
        ProdutoRepository.save(produto02);
        ProdutoRepository.save(produto03);
        ProdutoRepository.save(produto04);

        Pedido Pedido01 = new Pedido(null, "Pedido1", "15 minutos", new BigDecimal("99.90").setScale(2),
                StatusPedido.ENTREGUE,TipoEntrega.RETIRADA, Cliente01, Entregador01 , Estabelecimento01, produto01);

        Pedido Pedido02 = new Pedido(null, "Pedido1", "15 minutos", new BigDecimal("99.90").setScale(2),
                StatusPedido.ENTREGUE,TipoEntrega.RETIRADA, Cliente02, Entregador02 , Estabelecimento02, produto02);

        Pedido Pedido03 = new Pedido(null, "Pedido1", "15 minutos", new BigDecimal("99.90").setScale(2),
                StatusPedido.ENTREGUE,TipoEntrega.RETIRADA, Cliente01, Entregador02 , Estabelecimento01, produto03);
        
        PedidoRepository.save(Pedido01);
        PedidoRepository.save(Pedido02);
        PedidoRepository.save(Pedido03);

        Veiculo veiculo1 = new Veiculo(null,"carro vermelho", LocalDate.now(),10.00, "Victor", "34357890821");

        Veiculo veiculo2 = new Veiculo(null,"carro bmw", LocalDate.now(),20.00, "Gabriel", "123456");
        Veiculo veiculo3 = new Veiculo(null,"carro mercedes", LocalDate.now(),60.00, "João", "326598");
        Veiculo veiculo4 = new Veiculo(null,"camaro amarelo", LocalDate.now(),80.00, "David", "177777");

        veiculoRepository.save(veiculo1);
        veiculoRepository.save(veiculo2);
        veiculoRepository.save(veiculo3);
        veiculoRepository.save(veiculo4);



    }
}
