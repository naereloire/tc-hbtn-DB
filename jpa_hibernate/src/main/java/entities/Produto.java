package src.main.java.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {
  private static final long serialVersionUID = 2410616998900121992L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;

  String nome;
  int quantidade;
  double preco;
  Boolean status;

  public Produto() {}

  public Produto(int id, String nome, int quantidade, double preço, Boolean status) {
    this.id = id;
    this.nome = nome;
    this.quantidade = quantidade;
    this.preco = preço;
    this.status = status;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public double getPreço() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }
}
