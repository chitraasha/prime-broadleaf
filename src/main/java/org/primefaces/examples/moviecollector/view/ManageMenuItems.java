package org.primefaces.examples.moviecollector.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.primefaces.examples.moviecollector.domain.MenuItem;
import org.primefaces.examples.moviecollector.domain.Movie;
import org.primefaces.examples.moviecollector.service.MenuItemService;
import org.primefaces.examples.moviecollector.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("manageMenuItems")
@Scope("session")
public class ManageMenuItems implements Serializable{

	private List<MenuItem> menuItems;
	
	private MenuItemService menuItemService;
	
	private String headLine;
	
	private MenuItem menuItem;

	public ManageMenuItems() {}

	@Autowired
	public ManageMenuItems(MenuItemService menuItemService) {
		this.menuItemService = menuItemService;
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	
	
	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}
	
	public List<String> getMenuItemsByHeadline(String headLine) {
		List<MenuItem> foundMenuItems = menuItemService.findByHeadline(headLine);
		List<String> titles = new ArrayList<String>();
	
		for(MenuItem m : foundMenuItems)
			titles.add(m.getHeadLine());
		
		return titles;
	}
		
	public void search(ActionEvent actionEvent) {
		menuItems = menuItemService.findByHeadline(headLine);
	}

	public void setHeadLine(String headLine) {
		this.headLine = headLine;
	}

	public String getHeadLine() {
		return headLine;
	}
}