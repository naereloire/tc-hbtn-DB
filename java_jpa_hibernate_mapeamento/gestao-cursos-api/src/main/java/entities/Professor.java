package src.main.java.entities;

import javax.persistence.*;

@Entity
public class Professor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column private String nomeCompleto;

  @Column private String matricula;

  @Column private String email;

  public Professor() {}

  public Professor(Long id, String nomeCompleto, String matricula, String email) {
    this.id = id;
    this.nomeCompleto = nomeCompleto;
    this.matricula = matricula;
    this.email = email;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Professor{"
        + "id="
        + id
        + ", nomeCompleto='"
        + nomeCompleto
        + '\''
        + ", matricula='"
        + matricula
        + '\''
        + ", email='"
        + email
        + '\''
        + '}';
  }
}
