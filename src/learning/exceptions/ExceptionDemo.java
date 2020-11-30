package learning.exceptions;

public class ExceptionDemo {

    public static void main(String[] args) {
        int i;
        int j;
        i = 8;
        j = 9;

        try {
            int k = i / j;

            if (k == 0) {
                throw new MyCustomException("NOT POSSIBLE ZERO");
            }
            System.out.println(k);
        } catch (ArithmeticException e) {
            System.out.println("Error arithmetic exc " + e.getMessage());
        } catch (MyCustomException e) {
            System.out.println("My exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error exception: " + e.getMessage());
        }
    }
}
