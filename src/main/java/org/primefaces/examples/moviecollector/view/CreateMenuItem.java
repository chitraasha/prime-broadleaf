package org.primefaces.examples.moviecollector.view;

import java.io.Serializable;
import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.examples.moviecollector.domain.Category;
import org.primefaces.examples.moviecollector.domain.MenuItem;
import org.primefaces.examples.moviecollector.service.MenuItemService;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("createMenuItem")
@Scope("request")
public class CreateMenuItem implements Serializable {

	private MenuItem menuItem = new MenuItem();

	private TreeNode selectedNode;
	
	private MenuItemService addService;

	public CreateMenuItem() {
	}

	@Autowired
	public CreateMenuItem(MenuItemService addService) {
		this.addService = addService;
	}

	public void save(ActionEvent actionEvent) {
		if (selectedNode == null) {
			FacesMessage facesMsg = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "No category selected",
					"No category selected");
			FacesContext context = FacesContext.getCurrentInstance();
			UIComponent category = findComponent(context.getViewRoot(),
					"category");
			context.addMessage(category.getClientId(context), facesMsg);

		} else {
			Category category = (Category) selectedNode.getData();
			menuItem.setCategory(category);
			addService.createNew(menuItem);
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Info", "MenuItem is saved");
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			menuItem = new MenuItem();
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

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

	public TreeNode getSelectedNode() {
		return selectedNode;
	}
}