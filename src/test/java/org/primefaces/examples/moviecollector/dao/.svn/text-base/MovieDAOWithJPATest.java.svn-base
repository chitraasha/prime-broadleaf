package org.primefaces.examples.moviecollector.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.primefaces.examples.moviecollector.dao.MovieDAO;
import org.primefaces.examples.moviecollector.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*; 

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(transactionManager="txManager")
@ContextConfiguration(locations={"/applicationContext.xml"})
public class MovieDAOWithJPATest{

	private MovieDAO movieDAO;

	@Autowired
	public void setRepository(MovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}
	
	@Test
	public void shouldPersistNewMovie() {
		Movie movie = new Movie();
		movie.setTitle("Scarface");
		movie.setDiscs(new Integer(2));
		
		movieDAO.persist(movie);
		
		assertNotNull(movie.getId());
	}
	
	@Test
	public void shouldFindByTitle() {
		Movie movie = new Movie();
		movie.setTitle("Carlito's Way");
		movie.setDiscs(new Integer(1));
		
		movieDAO.persist(movie);
		assertNotNull(movie.getId());
		
		List<Movie> results = movieDAO.findByTitle("Carlito's Way");
		assertEquals(1, results.size());
		assertEquals("Carlito's Way", results.get(0).getTitle());
	}
	
	@Test
	public void shouldReadAllMovies() {
		Movie movie1 = new Movie();
		movie1.setTitle("Godfather Part I");
		movie1.setDiscs(new Integer(1));
		
		Movie movie2 = new Movie();
		movie2.setTitle("Godfather Part II");
		movie2.setDiscs(new Integer(1));
		
		movieDAO.persist(movie1);
		assertNotNull(movie1.getId());
		
		movieDAO.persist(movie2);
		assertNotNull(movie2.getId());
		
		List<Movie> results = movieDAO.loadAll();
		assertEquals(2, results.size());
	}
}
