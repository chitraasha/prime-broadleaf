package org.primefaces.examples.moviecollector.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.primefaces.examples.moviecollector.domain.Category;
import org.primefaces.examples.moviecollector.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("manageCategories")
@Scope("session")
public class ManageCategories implements Serializable{

	private List<Category> categories;
	
	private CategoryService categoryService;
	
	private String name;
	
	private Category category;

	public ManageCategories() {}

	@Autowired
	public ManageCategories(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public List<String> getCategoriesByName(String name) {
		List<Category> foundCategories = categoryService.findByName(name);
		List<String> names = new ArrayList<String>();
	
		for(Category c : foundCategories)
			names.add(c.getName());
		
		return names;
	}
		
	public void search(ActionEvent actionEvent) {
		categories = categoryService.findByName(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}