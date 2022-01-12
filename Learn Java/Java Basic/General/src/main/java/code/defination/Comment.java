package code.defination;

import java.io.IOException;

/**
 * Single Line Comment use
 * Multi Line Comment
 * Documentation Comment is this tag
 */
public class Comment {

    public static void main(String[] args) {
        // Single Line Comment use
        //System.out.println("hello world");

        // Multi Line Comment
        /* System.out.println("hello world");
        System.out.println("hello world"); */

    }

}


/**
 * @author Peter
 * @since 2012-12-12
 * @see IOException
 */
class ExampleClassComment {


    /**
     *
     * @param param1
     * @param parma2
     * @param varg
     */
    void method(String param1, Integer parma2, String ...varg){

    }
}