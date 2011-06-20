package org.primefaces.examples.moviecollector.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.primefaces.examples.moviecollector.domain.Add;
import org.primefaces.examples.moviecollector.domain.Movie;
import org.primefaces.examples.moviecollector.service.AddService;
import org.primefaces.examples.moviecollector.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("manageAdds")
@Scope("session")
public class ManageAdds implements Serializable{

	private List<Add> adds;
	
	private AddService addService;
	
	private String headLine;
	
	private Add add;

	public ManageAdds() {}

	@Autowired
	public ManageAdds(AddService addService) {
		this.addService = addService;
	}

	public List<Add> getAdds() {
		return adds;
	}
	public void setAdds(List<Add> adds) {
		this.adds = adds;
	}
	
	
	public Add getAdd() {
		return add;
	}

	public void setAdd(Add add) {
		this.add = add;
	}
	
	public List<String> getAddsByHeadline(String headLine) {
		List<Add> foundAdds = addService.findByHeadline(headLine);
		List<String> titles = new ArrayList<String>();
	
		for(Add m : foundAdds)
			titles.add(m.getHeadLine());
		
		return titles;
	}
		
	public void search(ActionEvent actionEvent) {
		adds = addService.findByHeadline(headLine);
	}

	public void setHeadLine(String headLine) {
		this.headLine = headLine;
	}

	public String getHeadLine() {
		return headLine;
	}
}