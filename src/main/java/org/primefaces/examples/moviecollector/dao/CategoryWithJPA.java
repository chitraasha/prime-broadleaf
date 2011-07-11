package org.primefaces.examples.moviecollector.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.primefaces.examples.moviecollector.domain.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryWithJPA implements CategoryDAO {

	@PersistenceContext
	protected EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Category> findByName(String name) {
		Query query = entityManager.createQuery("Select c from Category c where c.name LIKE :name");
		query.setParameter("name", name + "%");

		return query.getResultList();
	}

	public Category loadById(Long id) {
		return entityManager.find(Category.class, id);
	}

	public void persist(Category category) {
		entityManager.persist(category);
	}

	public void update(Category category) {
		entityManager.merge(category);
	}

	public void delete(Category category) {
		entityManager.createQuery("DELETE FROM Category c WHERE c.id=:id").setParameter("id", category.getId()).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Category> loadAll() {
		return entityManager.createQuery("Select c from Category c").getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Category> findRootNodes() {
		Query query = entityManager.createQuery("Select c from Category c where c.parent is null");
		return query.getResultList();
	}

	@Override
	public List<Category> findAllChildren(Category category) {
		Query query = entityManager.createQuery("Select c from Category c where c.parent = :category");
		query.setParameter("category", category);

		return query.getResultList();
	}
}
