package src.main.java.models;

import src.main.java.entities.Aluno;
import src.main.java.entities.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class CursoModel {
  EntityManagerFactory entityManagerFactory =
      Persistence.createEntityManagerFactory("gestao-cursos-jpa");
  EntityManager entityManager = null;
  EntityTransaction entityTransaction = null;

  public void create(Curso curso) {
    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityTransaction = entityManager.getTransaction();
      entityTransaction.begin();
      entityManager.persist(curso);
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

  public Curso findById(Curso curso) {
    Curso cursoToFind = null;
    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityTransaction = entityManager.getTransaction();
      entityTransaction.begin();
      cursoToFind = entityManager.find(Curso.class, curso.getId());
      entityTransaction.commit();
    } catch (Exception e) {
      e.printStackTrace();
      cursoToFind = null;
      if (entityTransaction != null) entityTransaction.rollback();
    } finally {
      if (entityManager != null) entityManager.close();
    }
    return cursoToFind;
  }

  public List<Curso> findAll() {
    List<Curso> cursoList = null;
    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityTransaction = entityManager.getTransaction();
      entityTransaction.begin();
      cursoList =
          entityManager.createQuery("SELECT * FROM" + Curso.class.getName()).getResultList();
      entityTransaction.commit();
    } catch (Exception e) {
      e.printStackTrace();
      cursoList = null;
      if (entityTransaction != null) entityTransaction.rollback();
    } finally {
      if (entityManager != null) entityManager.close();
    }
    return cursoList;
  }

  public void update(Curso curso) {
    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityTransaction = entityManager.getTransaction();
      entityTransaction.begin();
      entityManager.merge(curso);
      entityTransaction.commit();
    } catch (Exception e) {
      e.printStackTrace();
      if (entityTransaction != null) entityTransaction.rollback();
    } finally {
      if (entityManager != null) entityManager.close();
    }
  }

  public void delete(Curso curso) {
    Curso cursoToRemove;
    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityTransaction = entityManager.getTransaction();
      entityTransaction.begin();
      cursoToRemove = entityManager.find(Curso.class, curso.getId());
      entityManager.remove(cursoToRemove);
      entityTransaction.commit();
    } catch (Exception e) {
      e.printStackTrace();
      if (entityTransaction != null) entityTransaction.rollback();
    } finally {
      if (entityManager != null) entityManager.close();
    }
  }
}
