package src.main.java.entities;

import javax.persistence.*;

@Entity
public class Endereco {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Long id;

  @Column private String logradouro;
  @Column private String endereco;
  @Column private String numero;
  @Column private String bairro;
  @Column private String cidade;
  @Column private String estado;
  @Column private Integer cep;

  public Endereco() {}

  public Endereco(
      Long id,
      String logradouro,
      String endereco,
      String numero,
      String bairro,
      String cidade,
      String estado,
      Integer cep) {
    this.id = id;
    this.logradouro = logradouro;
    this.endereco = endereco;
    this.numero = numero;
    this.bairro = bairro;
    this.cidade = cidade;
    this.estado = estado;
    this.cep = cep;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public Integer getCep() {
    return cep;
  }

  public void setCep(Integer cep) {
    this.cep = cep;
  }

  @Override
  public String toString() {
    return "MaterialCurso{"
        + "id="
        + id
        + ", logradouro='"
        + logradouro
        + '\''
        + ", endereco='"
        + endereco
        + '\''
        + ", numero='"
        + numero
        + '\''
        + ", bairro='"
        + bairro
        + '\''
        + ", cidade='"
        + cidade
        + '\''
        + ", estado='"
        + estado
        + '\''
        + ", cep="
        + cep
        + '}';
  }
}
