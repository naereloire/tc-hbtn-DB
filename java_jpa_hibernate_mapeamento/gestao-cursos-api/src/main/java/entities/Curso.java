package src.main.java.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Curso {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column private String nome;

  @Column private String sigla;

  @ManyToOne(
      optional = false,
      cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinColumn(name = "professor_id", referencedColumnName = "id")
  private Professor professor;

  @OneToOne(
      optional = false,
      cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.MERGE})
  @JoinColumn(name = "materialCurso_id", referencedColumnName = "id")
  private MaterialCurso materialCurso;

  @ManyToMany
  @JoinTable(
      name = "aluno_curso",
      joinColumns = @JoinColumn(name = "curso_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "aluno_id", referencedColumnName = "id"))
  private List<Aluno> alunoList;

  public Curso() {}

  public Curso(
      Long id,
      String nome,
      String sigla,
      Professor professor,
      MaterialCurso materialCurso,
      List<Aluno> alunoList) {
    this.id = id;
    this.nome = nome;
    this.sigla = sigla;
    this.professor = professor;
    this.materialCurso = materialCurso;
    this.alunoList = alunoList;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSigla() {
    return sigla;
  }

  public void setSigla(String sigla) {
    this.sigla = sigla;
  }

  public Professor getProfessor() {
    return professor;
  }

  public void setProfessor(Professor professor) {
    this.professor = professor;
  }

  public MaterialCurso getMaterialCurso() {
    return materialCurso;
  }

  public void setMaterialCurso(MaterialCurso materialCurso) {
    this.materialCurso = materialCurso;
  }

  public List<Aluno> getAlunoList() {
    return alunoList;
  }

  public void setAlunoList(List<Aluno> alunoList) {
    this.alunoList = alunoList;
  }

  @Override
  public String toString() {
    return "Curso{"
        + "id="
        + id
        + ", nome='"
        + nome
        + '\''
        + ", sigla='"
        + sigla
        + '\''
        + ", professor="
        + professor
        + ", materialCurso="
        + materialCurso
        + ", alunoList="
        + alunoList
        + '}';
  }
}
