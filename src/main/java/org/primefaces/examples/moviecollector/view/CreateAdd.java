package org.primefaces.examples.moviecollector.view;

import java.io.Serializable;
import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.examples.moviecollector.domain.Add;
import org.primefaces.examples.moviecollector.domain.Movie;
import org.primefaces.examples.moviecollector.service.AddService;
import org.primefaces.examples.moviecollector.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("createAdd")
@Scope("request")
public class CreateAdd implements Serializable {

	private Add add = new Add();

	private AddService addService;

	public CreateAdd() {
	}

	@Autowired
	public CreateAdd(AddService addService) {
		this.addService = addService;
	}

	public void save(ActionEvent actionEvent) {
		if (add.getCategory().isEmpty()) {
			FacesMessage facesMsg = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "No category selected",
					"No category selected");
			FacesContext context = FacesContext.getCurrentInstance();
			UIComponent category = findComponent(context.getViewRoot(),
					"category");
			context.addMessage(category.getClientId(context), facesMsg);

		} else {

			addService.createNew(add);
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Info", "Add is saved");
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			add = new Add();
		}
	}

	private UIComponent findComponent(UIComponent parent, String id) {
		if (id.equals(parent.getId())) {
			return parent;
		}
		Iterator<UIComponent> kids = parent.getFacetsAndChildren();
		while (kids.hasNext()) {
			UIComponent kid = kids.next();
			UIComponent found = findComponent(kid, id);
			if (found != null) {
				return found;
			}
		}
		return null;
	}

	public void setAdd(Add add) {
		this.add = add;
	}

	public Add getAdd() {
		return add;
	}
}