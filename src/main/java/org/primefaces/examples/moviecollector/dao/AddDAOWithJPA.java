package org.primefaces.examples.moviecollector.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.primefaces.examples.moviecollector.domain.Add;
import org.springframework.stereotype.Repository;

@Repository
public class AddDAOWithJPA implements AddDAO {

	@PersistenceContext
	protected EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Add> findByHeadline(String headLine) {
		Query query = entityManager.createQuery("Select a from Add a where a.headLine LIKE :headLine");
		query.setParameter("headLine", headLine + "%");

		return query.getResultList();
	}

	public Add loadById(Long id) {
		return entityManager.find(Add.class, id);
	}

	public void persist(Add add) {
		entityManager.persist(add);
	}

	public void update(Add add) {
		entityManager.merge(add);
	}

	public void delete(Add add) {
		entityManager.createQuery("DELETE FROM Add a WHERE a.id=:id").setParameter("id", add.getId()).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Add> loadAll() {
		return entityManager.createQuery("Select a from Add a").getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}