package cn.edu.guet.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 树：自关联
 */
public class Tree {
    private String treeId;
    private String parentTreeId;
    private String title;
    private String url;
    private String treeDesc;

//    private Tree parentTree;
//    private List<Tree> childTrees=new ArrayList<Tree>();

    public String getTreeId() {
        return treeId;
    }

    public void setTreeId(String treeId) {
        this.treeId = treeId;
    }

    public String getParentTreeId() {
        return parentTreeId;
    }

    public void setParentTreeId(String fatherTreeId) {
        this.parentTreeId = fatherTreeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTreeDesc() {
        return treeDesc;
    }

    public void setTreeDesc(String treeDesc) {
        this.treeDesc = treeDesc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String treeConeect) {
        this.url = treeConeect;
    }
}
