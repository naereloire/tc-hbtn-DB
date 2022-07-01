package src.main.java.models;

import src.main.java.entities.Pessoa;
import src.main.java.entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class PessoaModel {
  EntityManagerFactory entityManagerFactory =
      Persistence.createEntityManagerFactory("administrativo-jpa");
  EntityManager entityManager = null;
  EntityTransaction entityTransaction = null;

  public void create(Pessoa p) {
    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityTransaction = entityManager.getTransaction();
      entityTransaction.begin();
      entityManager.persist(p);
      entityTransaction.commit();
    } catch (Exception e) {
      e.printStackTrace();
      if (entityTransaction != null) entityTransaction.rollback();
    } finally {
      if (entityManager != null) {
        entityManager.close();
      }
    }
  }

  public Pessoa findById(Pessoa p) {
    Pessoa pessoa = null;
    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityTransaction = entityManager.getTransaction();
      entityTransaction.begin();
      pessoa = entityManager.find(Pessoa.class, p.getId());
      entityTransaction.commit();
    } catch (Exception e) {
      e.printStackTrace();
      if (entityTransaction != null) entityTransaction.rollback();
    } finally {
      if (entityManager != null) entityManager.close();
    }
    return pessoa;
  }

  public List<Pessoa> findAll() {
    List<Pessoa> pessoas = null;
    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityTransaction = entityManager.getTransaction();
      entityTransaction.begin();
      pessoas =
          entityManager.createQuery("SELECT * FROM" + Pessoa.class.getName()).getResultList();
      entityTransaction.commit();
    } catch (Exception e) {
      e.printStackTrace();
      pessoas = null;
      if (entityTransaction != null) entityTransaction.rollback();
    } finally {
      if (entityManager != null) entityManager.close();
    }
    return pessoas;
  }

  public void update(Pessoa p) {
    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityTransaction = entityManager.getTransaction();
      entityTransaction.begin();
      entityManager.merge(p);
      entityTransaction.commit();
    } catch (Exception e) {
      e.printStackTrace();
      if (entityTransaction != null) entityTransaction.rollback();
    } finally {
      if (entityManager != null) entityManager.close();
    }
  }

  public void delete(Pessoa p) {
    Pessoa pessoaRemover;
    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityTransaction = entityManager.getTransaction();
      entityTransaction.begin();
      pessoaRemover = entityManager.find(Pessoa.class, p.getId());
      entityManager.remove(pessoaRemover);
      entityTransaction.commit();
    } catch (Exception e) {
      e.printStackTrace();
      if (entityTransaction != null) entityTransaction.rollback();
    } finally {
      if (entityManager != null) entityManager.close();
    }
  }
}
