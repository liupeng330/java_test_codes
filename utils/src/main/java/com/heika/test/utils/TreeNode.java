package com.heika.test.utils;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T>
{
    private List<TreeNode> childs = new ArrayList<>();
    public List<TreeNode> getChilds()
    {
        return childs;
    }

    public TreeNode getChild(int index)
    {
        return this.childs.get(index);
    }

    private T element;
    public T getElement()
    {
        return element;
    }

    public TreeNode(T element)
    {
        this.element = element;
    }

    public void addNode(TreeNode node)
    {
        this.childs.add(node);
    }

    public boolean hasChild()
    {
        return this.childs.size() > 0;
    }

    public boolean equals(Object o)
    {
        if (this == o) return true;
        if ((o == null) || getClass() != o.getClass()) return false;

        TreeNode that = (TreeNode) o;
        if(this.getElement() != null ? !this.getElement().equals(that.getElement()) : that.getElement() != null)
        {
            return false;
        }
        if(this.getChilds() != null ? !this.getChilds().equals(that.getChilds()) : that.getChilds() != null)
        {
            return false;
        }

        return true;
    }

    private String print(int level)
    {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<level; i++)
        {
            sb.append("    ");
        }
        sb.append("TreeNode name is '" + this.element.toString() + "'.\n");
        if(this.hasChild())
        {
            for(TreeNode node: this.getChilds())
            {
                sb.append(node.print(level + 1));
            }
        }

        return sb.toString();
    }

    public String toString()
    {
        return print(0);
    }
}
