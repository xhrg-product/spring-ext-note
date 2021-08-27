package com.github.xhrg.spring.note.helper.tree;

import java.util.ArrayList;
import java.util.List;

import com.github.xhrg.spring.note.helper.Line;

public class LineNode {

    private Line line;

    private List<LineNode> child = new ArrayList<>();

    private LineNode parent;

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public List<LineNode> getChild() {
        return child;
    }

    public void setChild(List<LineNode> child) {
        this.child = child;
    }

    public LineNode getParent() {
        return parent;
    }

    public void setParent(LineNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return line.getClassName() + "#" + line.getMethod();
    }
}
