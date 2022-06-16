package src.main.java.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {
  private static final long serialVersionUID = 1891906287482577667L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "nome", nullable = false)
  private String nome;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "idade", nullable = false)
  private Integer idade;

  @Column(name = "cpf", nullable = false)
  private String cpf;

  @Column(name = "dataDeNascimento", nullable = false)
  private LocalDate dataDeNascimento;

  public Pessoa() {}

  public Pessoa(
      Integer id,
      String nome,
      String email,
      Integer idade,
      String cpf,
      LocalDate dataDeNascimento) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.idade = idade;
    this.cpf = cpf;
    this.dataDeNascimento = dataDeNascimento;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getIdade() {
    return idade;
  }

  public void setIdade(Integer idade) {
    this.idade = idade;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public LocalDate getDataDeNascimento() {
    return dataDeNascimento;
  }

  public void setDataDeNascimento(LocalDate dataDeNascimento) {
    this.dataDeNascimento = dataDeNascimento;
  }

  @Override
  public String toString() {
    return "Pessoa{"
        + "id="
        + id
        + ", nome='"
        + nome
        + '\''
        + ", email='"
        + email
        + '\''
        + ", idade="
        + idade
        + ", cpf='"
        + cpf
        + '\''
        + ", dataDeNascimento="
        + dataDeNascimento
        + '}';
  }
}
