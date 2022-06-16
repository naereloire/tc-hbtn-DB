package src.main.java.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Aluno {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column private String nomeCompleto;
  @Column private String matricula;
  @Column private Date nascimento;
  @Column private String email;

  @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
  @JoinColumn(name = "telefone_id", referencedColumnName = "id")
  private List<Telefone> telefoneList;

  @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
  @JoinColumn(name = "endereco_id", referencedColumnName = "id")
  private List<Endereco> enderecoList;

  public Aluno() {}

  public Aluno(
      Long id,
      String nomeCompleto,
      String matricula,
      Date nascimento,
      String email,
      List<Telefone> telefoneList,
      List<Endereco> enderecoList) {
    this.id = id;
    this.nomeCompleto = nomeCompleto;
    this.matricula = matricula;
    this.nascimento = nascimento;
    this.email = email;
    this.telefoneList = new ArrayList<>();
    this.enderecoList = new ArrayList<>();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNomeCompleto() {
    return nomeCompleto;
  }

  public void setNomeCompleto(String nomeCompleto) {
    this.nomeCompleto = nomeCompleto;
  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public Date getNascimento() {
    return nascimento;
  }

  public void setNascimento(Date nascimento) {
    this.nascimento = nascimento;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<Telefone> getTelefoneList() {
    return telefoneList;
  }

  public void setTelefoneList(List<Telefone> telefoneList) {
    this.telefoneList = telefoneList;
  }

  public List<Endereco> getEnderecoList() {
    return enderecoList;
  }

  public void setEnderecoList(List<Endereco> enderecoList) {
    this.enderecoList = enderecoList;
  }

  @Override
  public String toString() {
    return "Aluno{"
        + "id="
        + id
        + ", nomeCompleto='"
        + nomeCompleto
        + '\''
        + ", matricula='"
        + matricula
        + '\''
        + ", nascimento="
        + nascimento
        + ", email='"
        + email
        + '\''
        + ", telefoneList="
        + telefoneList
        + ", enderecoList="
        + enderecoList
        + '}';
  }
}
