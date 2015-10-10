package com.heika.test.ui.elements.widget;

import com.heika.test.ui.elements.base.ElementImpl;
import com.heika.test.ui.verify.page.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import com.heika.test.utils.TreeNode;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import sun.reflect.generics.tree.Tree;

/**
<ul id="navTree" class="navStyle tree">
<li>
<div id="_easyui_tree_1" class="tree-node">
<span class="tree-hit tree-expanded"></span>
<span class="tree-icon tree-folder tree-folder-open "></span>
<span class="tree-title">用户查询</span>
</div>
<ul style="display:block">
<li>
<div id="_easyui_tree_2" class="tree-node">
<span class="tree-indent"></span>
<span class="tree-indent"></span>
<span class="tree-icon tree-file "></span>
<span class="tree-title">用户查询</span>
</div></li>
<li>
<div id="_easyui_tree_3" class="tree-node">
<span class="tree-indent"></span>
<span class="tree-indent"></span>
<span class="tree-icon tree-file "></span>
<span class="tree-title">PDF征信报告</span>
</div></li>
</ul></li>
<li>
<div id="_easyui_tree_4" class="tree-node">
<span class="tree-hit tree-expanded"></span>
<span class="tree-icon tree-folder tree-folder-open "></span>
<span class="tree-title">调查</span>
</div>
<ul style="display:block">
<li>
<div id="_easyui_tree_5" class="tree-node">
<span class="tree-indent"></span>
<span class="tree-indent"></span>
<span class="tree-icon tree-file "></span>
<span class="tree-title">普通用户</span>
</div></li>
<li>
<div id="_easyui_tree_6" class="tree-node">
<span class="tree-indent"></span>
<span class="tree-indent"></span>
<span class="tree-icon tree-file "></span>
<span class="tree-title">BD渠道用户</span>
</div></li>
</ul></li>
<li>
<div id="_easyui_tree_7" class="tree-node">
<span class="tree-indent"></span>
<span class="tree-icon tree-file "></span>
<span class="tree-title">一审</span>
</div></li>
<li>
<div id="_easyui_tree_8" class="tree-node">
<span class="tree-indent"></span>
<span class="tree-icon tree-file "></span>
<span class="tree-title">二审</span>
</div></li>
<li>
<div id="_easyui_tree_9" class="tree-node">
<span class="tree-hit tree-expanded"></span>
<span class="tree-icon tree-folder tree-folder-open "></span>
<span class="tree-title">权限管理</span>
</div>
<ul style="display:block">
<li>
<div id="_easyui_tree_10" class="tree-node">
<span class="tree-indent"></span>
<span class="tree-indent"></span>
<span class="tree-icon tree-file "></span>
<span class="tree-title">用户列表</span>
</div></li>
</ul></li>
</ul>
*/
public class NavTreeImpl extends ElementImpl implements NavTree
{
    private TreeNode<WebElement> root;
    public NavTreeImpl(WebElement element)
    {
        super(element);
        populateTree();
    }

    public NavTreeImpl(WebElement element, ElementLocator locator)
    {
        super(element, locator);
        populateTree();
    }

    private TreeNode<WebElement> populateTree(TreeNode<WebElement> root, boolean isRoot)
    {
        if(root == null)
        {
            return root;
        }
        List<WebElement> all_li = null;
        if(isRoot)
        {
            all_li = root.getElement().findElements(By.xpath("child::li"));
        }
        else
        {
            List<WebElement> temp = root.getElement().findElements(By.xpath("../child::ul"));
            if(temp.size() > 0)
            {
                all_li =  temp.get(0).findElements(By.xpath("child::li"));
            }
            else
            {
                return root;
            }
        }
        for(WebElement element: all_li)
        {
            WebElement treeNodeSpan = element.findElement(By.className("tree-node"));
            TreeNode<WebElement> treeNode = new TreeNode<>(treeNodeSpan);
            System.out.println(treeNodeSpan.getText());
            root.addNode(treeNode);
            populateTree(treeNode, false);
        }
        return root;
    }

    @Override
    public void populateTree()
    {
        TreeNode<WebElement> treeRoot = new TreeNode<>(this.getWrappedElement());
        populateTree(treeRoot, true);
        this.root = treeRoot;
    }

    @Override
    public void clickTreeNodeByTitle(String title)
    {
        List<TreeNode<WebElement>> allLeafNodes = TreeNode.getAllLeafNode(this.root);
        for(TreeNode<WebElement> leafNode: allLeafNodes)
        {
            WebElement span = leafNode.getElement().findElement(By.className("tree-title"));
            if(span.getText().equals(title))
            {
                span.click();
                return;
            }
        }
    }

    @Override
    public boolean existTitleInTree(String title)
    {
        return false;
    }
}
