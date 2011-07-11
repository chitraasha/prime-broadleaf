package org.primefaces.examples.moviecollector.beans;


import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.examples.moviecollector.domain.Category;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean
@ViewScoped
public class CategoryBean implements Serializable {
	
	private TreeNode root;

	public CategoryBean() {
		root = new DefaultTreeNode("Root", null);
		
		Category cat1 = new Category("Food", null);
		Category cat2 = new Category("Drinks", null);
		
		Category cat11 = new Category("Starters", cat1);
		Category cat12 = new Category("Mains", cat1);
		Category cat13 = new Category("Deserts", cat1);
		
		Category cat21 = new Category("Beer", cat2);
		Category cat22 = new Category("Wine", cat2);
		Category cat23 = new Category("Spirits", cat2);
		
		
		TreeNode node0 = new DefaultTreeNode(cat1, root);
		TreeNode node1 = new DefaultTreeNode(cat2, root);
				
		TreeNode node00 = new DefaultTreeNode(cat11, node0);
		TreeNode node01 = new DefaultTreeNode(cat12, node0);
		TreeNode node02 = new DefaultTreeNode(cat13, node0);
		
		TreeNode node10 = new DefaultTreeNode(cat21, node1);
		TreeNode node11 = new DefaultTreeNode(cat22, node1);
		TreeNode node12 = new DefaultTreeNode(cat23, node1);

	}

	public TreeNode getRoot() {
		return root;
	}
}
