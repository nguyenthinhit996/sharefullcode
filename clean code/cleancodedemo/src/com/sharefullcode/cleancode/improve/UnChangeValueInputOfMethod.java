package com.sharefullcode.cleancode.improve;

public class UnChangeValueInputOfMethod {

    //bad
    void takeCareOfPlant(Tree tree){
        if("n".equals(tree.getTakeCareStatus())){
            tree.setTakeCareStatus("y");
        }
    }
    //good
    Tree takeCareOfPlantGood(Tree tree) throws CloneNotSupportedException {
        Tree treeClone = tree.clone();
        if("n".equals(tree.getTakeCareStatus())){
            treeClone.setTakeCareStatus("y");
        }
        return treeClone;
    }
    public static void main(String[] args) throws CloneNotSupportedException {
        UnChangeValueInputOfMethod unChangeValueInputOfMethod = new UnChangeValueInputOfMethod();
        Tree treeInSideChange = new Tree();
        Tree treeChangeFromCloneObject  = new Tree();
        unChangeValueInputOfMethod.takeCareOfPlant(treeInSideChange);
        unChangeValueInputOfMethod.takeCareOfPlantGood(treeChangeFromCloneObject);
        System.out.println(treeInSideChange.toString());
        System.out.println(treeChangeFromCloneObject.toString());
    }
}

class Tree implements Cloneable{
    private String name;
    private String type;
    private String takeCareStatus;

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getTakeCareStatus() {
        return takeCareStatus;
    }

    public void setTakeCareStatus(String takeCareStatus) {
        this.takeCareStatus = takeCareStatus;
    }

    @Override
    protected Tree clone() throws CloneNotSupportedException {
        return (Tree) super.clone();
    }

    public Tree() {
        this.setTakeCareStatus("n");
    }

    @Override
    public String toString() {
        return "Tree{" +
                "takeCareStatus='" + takeCareStatus + '\'' +
                '}';
    }
}