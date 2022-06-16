package src.main.java.models;

import src.main.java.entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ProdutoModel {

  EntityManagerFactory entityManagerFactory =
      Persistence.createEntityManagerFactory("administrativo-jpa");
  EntityManager entityManager = null;
  EntityTransaction entityTransaction = null;

  public void create(Produto p) {
    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityTransaction = entityManager.getTransaction();
      entityTransaction.begin();
      entityManager.persist(p);
      entityTransaction.commit();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (entityManager != null) {
        entityManagerFactory.close();
        entityManager.close();
      }
    }
  }

  public Produto findById(Produto p) {
    Produto produto = null;
    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityTransaction = entityManager.getTransaction();
      entityTransaction.begin();
      produto = entityManager.find(Produto.class, p.getId());
      entityTransaction.commit();
    } catch (Exception e) {
      e.printStackTrace();
      if (entityTransaction != null) entityTransaction.rollback();
    } finally {
      if (entityManager != null) entityManager.close();
    }
    return produto;
  }

  public List<Produto> findAll() {
    List<Produto> produtos = null;
    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityTransaction = entityManager.getTransaction();
      entityTransaction.begin();
      produtos =
          entityManager.createQuery("SELECT * FROM" + Produto.class.getName()).getResultList();
      entityTransaction.commit();
    } catch (Exception e) {
      e.printStackTrace();
      produtos = null;
      if (entityTransaction != null) entityTransaction.rollback();
    } finally {
      if (entityManager != null) entityManager.close();
    }
    return produtos;
  }

  public void update(Produto p) {
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

  public void delete(Produto p) {
    Produto produtoParaDeletar;
    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityTransaction = entityManager.getTransaction();
      entityTransaction.begin();
      produtoParaDeletar = entityManager.find(Produto.class, p.getId());
      entityManager.remove(produtoParaDeletar);
      entityTransaction.commit();
    } catch (Exception e) {
      e.printStackTrace();
      if (entityTransaction != null) entityTransaction.rollback();
    } finally {
      if (entityManager != null) entityManager.close();
    }
  }
}
