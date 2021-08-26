package com.github.xhrg.spring.tree;

import java.util.ArrayList;
import java.util.List;

import com.github.xhrg.spring.helper.Line;

public class TreeNode {

	private Line line;

	private List<TreeNode> child = new ArrayList<>();

	private TreeNode parent;

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	public List<TreeNode> getChild() {
		return child;
	}

	public void setChild(List<TreeNode> child) {
		this.child = child;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return line.getClassName() + "#" + line.getMethod();
	}
}
