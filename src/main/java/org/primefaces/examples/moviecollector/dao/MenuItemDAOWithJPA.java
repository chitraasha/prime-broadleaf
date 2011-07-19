package org.primefaces.examples.moviecollector.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.primefaces.examples.moviecollector.domain.MenuItem;
import org.springframework.stereotype.Repository;

@Repository
public class MenuItemDAOWithJPA implements MenuItemDAO {

	@PersistenceContext
	protected EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<MenuItem> findByHeadline(String headLine) {
		Query query = entityManager.createQuery("Select m from MenuItem m where m.headLine LIKE :headLine");
		query.setParameter("headLine", headLine + "%");

		return query.getResultList();
	}

	public MenuItem loadById(Long id) {
		return entityManager.find(MenuItem.class, id);
	}

	public void persist(MenuItem menuItem) {
		entityManager.persist(menuItem);
	}

	public void update(MenuItem menuItem) {
		entityManager.merge(menuItem);
	}

	public void delete(MenuItem menuItem) {
		entityManager.createQuery("DELETE FROM MenuItem m WHERE m.id=:id").setParameter("id", menuItem.getId()).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<MenuItem> loadAll() {
		return entityManager.createQuery("Select m from MenuItem m").getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}