package src.main.java.models;

import src.main.java.entities.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class AlunoModel {
  EntityManagerFactory entityManagerFactory =
      Persistence.createEntityManagerFactory("gestao-cursos-jpa");
  EntityManager entityManager = null;
  EntityTransaction entityTransaction = null;

  public void create(Aluno aluno) {
    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityTransaction = entityManager.getTransaction();
      entityTransaction.begin();
      entityManager.persist(aluno);
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

  public Aluno findById(Aluno aluno) {
    Aluno alunoToFind = null;
    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityTransaction = entityManager.getTransaction();
      entityTransaction.begin();
      alunoToFind = entityManager.find(Aluno.class, aluno.getId());
      entityTransaction.commit();
    } catch (Exception e) {
      e.printStackTrace();
      alunoToFind = null;
      if (entityTransaction != null) entityTransaction.rollback();
    } finally {
      if (entityManager != null) entityManager.close();
    }
    return alunoToFind;
  }

  public List<Aluno> findAll() {
    List<Aluno> alunoList = null;
    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityTransaction = entityManager.getTransaction();
      entityTransaction.begin();
      alunoList =
          entityManager.createQuery("SELECT * FROM" + Aluno.class.getName()).getResultList();
      entityTransaction.commit();
    } catch (Exception e) {
      e.printStackTrace();
      alunoList = null;
      if (entityTransaction != null) entityTransaction.rollback();
    } finally {
      if (entityManager != null) entityManager.close();
    }
    return alunoList;
  }

  public void update(Aluno aluno) {
    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityTransaction = entityManager.getTransaction();
      entityTransaction.begin();
      entityManager.merge(aluno);
      entityTransaction.commit();
    } catch (Exception e) {
      e.printStackTrace();
      if (entityTransaction != null) entityTransaction.rollback();
    } finally {
      if (entityManager != null) entityManager.close();
    }
  }

  public void delete(Aluno aluno) {
    Aluno alunoToRemove;
    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityTransaction = entityManager.getTransaction();
      entityTransaction.begin();
      alunoToRemove = entityManager.find(Aluno.class, aluno.getId());
      entityManager.remove(alunoToRemove);
      entityTransaction.commit();
    } catch (Exception e) {
      e.printStackTrace();
      if (entityTransaction != null) entityTransaction.rollback();
    } finally {
      if (entityManager != null) entityManager.close();
    }
  }
}
