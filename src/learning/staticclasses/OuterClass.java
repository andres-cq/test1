package learning.staticclasses;

// Java program to demonstrate how to
// implement static and non-static
// classes in a Java program.
public class OuterClass {
    private static String msg = "GeeksForGeeks";
    private String msg2 = "message2";

    //Static nested class
    public static class NestedStaticClass {

        //Only static members of outer class
        //is directly accessible in nested static class
        public void printMessage() {

            //Try making 'message' a non-static
            //variable, there will be compiler error
            System.out.println("Message from nested static class: " + msg);

        }
    }

    //Non-static nested class
    //also called inner class
    public class InnerClass {

        //Both static and non-static members
        //of outer class are accessible in this inner class
        public void display() {
            System.out.println("Message from non-static nested class: " + msg);
            System.out.println("message2: " + msg2);
        }
    }
}
