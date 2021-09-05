package com.sharefullcode.cleancode.improve.encapsulationcollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Run {

   static List<Tree> initialValue(){
       Tree banana = new Tree("banana", 1);
       Tree apple = new Tree("apple", 2);
       Tree orange = new Tree("orange", 3);
       List<Tree> listTree = new ArrayList<>();
       listTree.add(banana);
       listTree.add(apple);
       listTree.add(orange);
       return listTree;
   }

   static void changeSomeThingOfList( List<Tree> listTree){

       Function<Tree,Tree> changeDirectIndexOfItem = (Tree tree) -> {
            if(tree.getIndex() == 1){
                tree.setIndex(555);
            }
            return tree;
       };

       Function<Tree,Tree> changeObjectCloneIndexOfItem = (Tree tree) -> {
           Tree treeClone = null;
           try {
               treeClone = (Tree) tree.clone();
           } catch (CloneNotSupportedException e) {
               e.printStackTrace();
           }
           if(treeClone != null && treeClone.getIndex() == 1){
               treeClone.setIndex(555);
           }
           return treeClone;
       };

       if(listTree != null && !listTree.isEmpty()){
           // change direct on list by map
           listTree.stream().map(changeDirectIndexOfItem).collect(Collectors.toList());

           // not change direct only give value return of collect();
           //List<Tree> trees = listTree.stream().map(changeObjectCloneIndexOfItem).collect(Collectors.toList());
           //System.out.println(trees);

           //getCollectionUnmodifyTree UnsupportedOperationException
           //listTree.remove(0);
       }
   }

    public static void main(String[] args) {
        List<Tree> listTree = initialValue();
        Garden garden = new Garden(listTree);

        //bad code get and change list collection
        List<Tree> trees = garden.getCollectionTree();
        changeSomeThingOfList(trees);
        System.out.println(trees);

        //good code get and not modify list collection
        List<Tree> treesUnableChange = garden.getCollectionUnmodifyTree();
        changeSomeThingOfList(treesUnableChange);
        System.out.println(treesUnableChange);
    }
}

class Tree implements Cloneable{
    private String name;
    private Integer index;

    public void setName(String name) {
        this.name = name;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public Integer getIndex() {
        return index;
    }

    public Tree(String name, Integer index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Tree tree = new Tree("",0);
        tree.setIndex(this.getIndex());
        tree.setName(this.getName());
        return tree;
    }
}

class Garden {

    private List<Tree> collectionTree;

    Garden(List<Tree> collectionTree){
        this.collectionTree = collectionTree;
    }

    public void setCollectionTree(List<Tree> collectionTree) {
        this.collectionTree = collectionTree;
    }

    public List<Tree> getCollectionTree() {
        return collectionTree;
    }

    public List<Tree> getCollectionUnmodifyTree() {
        return Collections.unmodifiableList(collectionTree);
    }
}