package com.sharefullcode.cleancode.notuseif;

public class ProcessChoiceCake {

    // bad way
    public void doingTaskBad(String type) {
        if ("Biscuit".equals(type)) {
            // do somethings
            System.out.println("Biscuit to doing");
        } else if ("Bread".equals(type)) {
            // do somethings
            System.out.println("Bread to doing");
        } else {
            // nothing
        }
    }

    // good way use interface instead
    public void doingTaskGood(IBakery bakery) {
        bakery.doingBakary();
    }

    //use
    public static void main(String[] args) {
        ProcessChoiceCake processed = new ProcessChoiceCake();
        processed.doingTaskBad("Bread");
        IBakery bread = new Bread();
        processed.doingTaskGood(bread);
    }
}
