package org.primefaces.examples.moviecollector.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.examples.moviecollector.domain.Category;
import org.primefaces.examples.moviecollector.service.CategoryService;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("categoryBean")
@ViewScoped
public class CategoryBean implements Serializable {

	private TreeNode root;

	private TreeNode selectedNode;

	private CategoryService categoryService;

	@Autowired
	public CategoryBean(CategoryService categoryService) {
		this.categoryService = categoryService;
		root = new DefaultTreeNode("Root", null);

		List<Category> categories = categoryService.findRootNodes();

		for (Category category : categories) {
			new DefaultTreeNode(category, root);
		}
		
	}

	public CategoryBean() {
		
	}

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

	public TreeNode getRoot() {
		return root;
	}

	public void addNewRootNode(ActionEvent actionEvent) {
		
	}
	
	public void addChildNode(ActionEvent actionEvent) {
		System.out.println("Selected Node: " + getSelectedNode().toString());
		TreeNode newNode = new DefaultTreeNode("Node New", getSelectedNode());
		getSelectedNode().setExpanded(true);
	}

	public void addTopicBelow(ActionEvent actionEvent) {
		TreeNode newNode = new DefaultTreeNode("Node New", getSelectedNode()
				.getParent());
	}

	public void deleteNode(ActionEvent actionEvent) {
		System.out.println("Node to be deleted: "
				+ getSelectedNode().toString());
		// getSelectedNode().
	}
}
