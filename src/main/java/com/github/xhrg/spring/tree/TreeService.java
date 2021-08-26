package com.github.xhrg.spring.tree;

import java.util.List;

import com.github.xhrg.spring.helper.Line;

public class TreeService {

	private static TreeNode treeNode;

	public static void addTreeNode(List<Line> list) {
		if (list == null || list.isEmpty()) {
			return;
		}

		TreeNode curNode = treeNode;

		out: for (int i = 0; i < list.size(); i++) {
			Line line = list.get(i);
			if (treeNode == null) {
				treeNode = new TreeNode();
				treeNode.setLine(line);
				addNextList(treeNode, list.subList(1, list.size()));
				return;
			}
			boolean ok = isSame(line, curNode);
			if (ok) {
				if (curNode.getChild().isEmpty()) {
					addNextList(curNode, list.subList(i, list.size()));
					return;
				}
				curNode = curNode.getChild().get(0);
				continue;
			} else {
				List<TreeNode> child = curNode.getParent().getChild();
				if (child.size() <= 1) {
					addNextList(curNode.getParent(), list.subList(i, list.size()));
					return;
				}
				for (TreeNode t : child) {
					boolean ok1 = isSame(line, t);
					if (ok1) {
						curNode = t;
						i--;
						continue out;
					}
				}
				addNextList(curNode.getParent(), list.subList(i, list.size()));
				return;
			}
		}
	};

	private static boolean isSame(Line line, TreeNode treeNode2) {
		String key1 = line.getClassName() + line.getMethod();
		String key2 = treeNode2.getLine().getClassName() + treeNode2.getLine().getMethod();
		return key1.equals(key2);
	}

	private static void addNextList(TreeNode parent, List<Line> list) {
		for (Line line : list) {
			TreeNode treeNode = new TreeNode();
			treeNode.setLine(line);
			treeNode.setParent(parent);
			parent.getChild().add(treeNode);
			parent = treeNode;
		}
	}

	public static void printTreeNode() {
		printTreeNode(treeNode);
	}

	private static void printTreeNode(TreeNode treeNode2) {
		printLine(treeNode2.getLine());
		for (TreeNode t : treeNode2.getChild()) {
			printTreeNode(t);
		}
	}

	private static void printLine(Line line) {
		String str = nkk(line.getNum()) + line.getClassName() + "::" + line.getMethod();
		if (str.contains("com.github")) {
			str = str + "【自定义扩展点】";
		}
		System.out.println(str);
	}

	public static String nkk(int i) {
		i = i * 4;
		StringBuilder sb = new StringBuilder();
		while (i-- > 0) {
			sb.append(" ");
		}
		return sb.toString();
	}

}
