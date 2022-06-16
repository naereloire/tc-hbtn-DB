package src.main.java.demo;

import src.main.java.entities.Pessoa;
import src.main.java.entities.Produto;
import src.main.java.models.PessoaModel;
import src.main.java.models.ProdutoModel;

import java.time.LocalDate;
import java.util.List;

public class AdministrativoApp {

  public static void main(String[] args) {
    ProdutoModel produtoModel = new ProdutoModel();

    Produto p1 = new Produto();
    p1.setNome("TV");
    p1.setPreco(300.0);
    p1.setQuantidade(100);
    p1.setStatus(true);

    Produto prod2 = new Produto();
    prod2.setNome("Lava Louças");
    prod2.setPreco(4000.0);
    prod2.setQuantidade(1);
    prod2.setStatus(true);

    // 1) Criando um produto
    produtoModel.create(prod2);
    System.out.printf(
        String.format(
            "Produto registrado com sucesso: %n Nome: %s %n Preço: %f %n Quantidade: %d %n Status: %s",
            prod2.getNome(), prod2.getPreço(), prod2.getQuantidade(), prod2.getStatus()));

    // 2) Buscando todos os produtos na base de dados
    List<Produto> produtos = produtoModel.findAll();
    System.out.println("Qtde de produtos encontrados : " + produtos.size());

    // 3) Buscando produto pelo id na base de dados
    prod2.setId(22);
    Produto produto = new Produto();
    produto = produtoModel.findById(prod2);
    System.out.println("Id do produto:" + produto.getId());

    // 4) Atualizando um produto na base de dados
    prod2.setStatus(false);
    produtoModel.update(prod2);
    System.out.println("novo status:" + produto.getStatus());

    // 4) Deletando um produto na base de dados
    prod2.setId(33);
    produtoModel.delete(prod2);

    PessoaModel pessoaModel = new PessoaModel();

    Pessoa p2 = new Pessoa();
    p2.setNome("Luke");
    p2.setEmail("juca@juca.com");
    p2.setIdade(22);
    p2.setCpf("11122233344");
    p2.setDataDeNascimento(LocalDate.of(2000, 10, 7));

    Pessoa p3 = new Pessoa();
    p3.setNome("Leia");
    p3.setEmail("leia@leia.com");
    p3.setIdade(22);
    p3.setCpf("44433355566");
    p3.setDataDeNascimento(LocalDate.of(2000, 10, 7));

    // 1) Criando uma pessoa:
    pessoaModel.create(p2);
    System.out.printf(
        String.format(
            "Pessoa registrada com sucesso! %n Nome: %s %n Email: %s %n Idade: %d %n CPF: %s %n Data de Nascimento: %s",
            p2.getNome(), p2.getEmail(), p2.getIdade(), p2.getCpf(), p2.getDataDeNascimento()));

    // 1) Criando outra pessoa:
    pessoaModel.create(p3);
    System.out.printf(
        String.format(
            "Pessoa registrado com sucesso! %n Nome: %s %n Email: %s %n Idade: %d %n CPF: %s %n Data de Nascimento: %s",
            p3.getNome(), p3.getEmail(), p3.getIdade(), p3.getCpf(), p3.getDataDeNascimento()));

    // 2) Buscando todas as pessoas na base de dados:
    List<Pessoa> pessoa = pessoaModel.findAll();
    System.out.println("Qtde de pessoas encontradas : " + produtos.size());

    // 3) Buscando pessoa pelo id na base de dados:
    p2.setId(55);
    Pessoa pess = new Pessoa();
    pess = pessoaModel.findById(p2);
    System.out.println(pess.getId());

    // 4) Atualizando uma pessoa na base de dados:
    p3.setEmail("p2@p2.com");
    pessoaModel.update(p3);
    System.out.println(p3.getEmail());
  }
}
