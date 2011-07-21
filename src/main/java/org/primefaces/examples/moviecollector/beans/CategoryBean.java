package org.primefaces.examples.moviecollector.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.NodeExpandEvent;
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
			TreeNode newNode = new DefaultTreeNode(category, root);
			List<Category> children = categoryService.findChildren(category);
			
			for (Category child : children) {
				new DefaultTreeNode(child,newNode);
			}
		}
		root.setExpanded(false);
		
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

	
	public void onNodeExpand(NodeExpandEvent event) {
		
		List<TreeNode> nodes = event.getTreeNode().getChildren();
		
		for (TreeNode treeNode : nodes) {
			Category category = (Category) treeNode.getData();
			List<Category> children = categoryService.findChildren(category);
			
			for (Category child : children) {
				new DefaultTreeNode(child,treeNode);
			}
		}
	}
	
	public void deleteNode(ActionEvent actionEvent) {
		System.out.println("Node to be deleted: "
				+ getSelectedNode().toString());
		// getSelectedNode().
	}
}
