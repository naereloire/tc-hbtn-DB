package src;

public class Cliente {
  private Integer id;
  private String nome;
  private Integer idade;
  private String cpf;
  private String Rg;

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

  public String getRg() {
    return Rg;
  }

  public void setRg(String rg) {
    this.Rg = rg;
  }
}
