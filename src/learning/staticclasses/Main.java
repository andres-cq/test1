package learning.staticclasses;

public class Main {

    public static void main(String[] args){
        //Create instance of nested static class
        OuterClass.NestedStaticClass printer = new OuterClass.NestedStaticClass();

        //Call non static method of nested static class
        printer.printMessage();

        //In order to create instance of Inner class we need an Outer Class instance
        //Let us create outer class instance for creating non-static nested class
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();

        //calling non-static method of inner class
        inner.display();

        //We can also combine above steps in one step to create instance of inner class
        OuterClass.InnerClass innerObject = new OuterClass().new InnerClass();

        //Similarly we can now call inner class method
        innerObject.display();

    }
}
