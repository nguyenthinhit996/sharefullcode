package com.sharefullcode.cleancode.improve.factory_contructor_was_replace;

import org.jetbrains.annotations.Contract;

import java.time.LocalDate;

// example class tree use constructor overloaded
public class Tree {
    private String name;
    private String type;
    private String root;
    private String body;
    private String bough; // cành cây
    private String leaf; // lá cây

    public Tree() {
    }
    private Tree(String name) {
        this.name = name;
    }
    private Tree(String name, String type) {
        this.name = name;
        this.type = type;
    }
    private Tree(String name, String type, String root) {
        this.name = name;
        this.type = type;
        this.root = root;
    }
    private Tree(Tree other) {
        this.name = other.name;
        this.type = other.type;
        this.root = other.root;
    }

    public static Tree of(String name) {
        return new Tree(name);
    }
    public static Tree of(String name, String type) {
        return new Tree(name, type);
    }
    public static Tree of(String name, String type, String root) {
        return new Tree(name, type, root);
    }
    public static Tree from(Tree otherTree) {
        return new Tree(otherTree);
    }

}
