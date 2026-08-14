public class Calculator {

   private static void assertEquals(String expression, double expected) {
       double actual = 0; //TODO: Call your method here
       double tolerance = 0.000001;
       if (Math.abs(actual - expected) < tolerance) {
           System.out.println("[PASS] " + expression + " = " + actual);
       } else {
           System.out.println("[FAIL] " + expression);
           System.out.println("  Expected: " + expected);
           System.out.println("  Actual:   " + actual);
       }
   }
   public static void main(String[] args) {
       assertEquals("(2*3)+(7/3)", 8.333333333333334);
       assertEquals("2+3*4", 14);
       assertEquals("(5+3)*(8-2)", 48);
       assertEquals("10/2+6*3", 23);
       assertEquals("100/(5*2)", 10);
       assertEquals("(2+3)*(4+5)-6/3", 43);
       assertEquals("7+8/4*5", 17);
       assertEquals("3.5*2+1.5", 8.5);
       // Expressions with spaces
       assertEquals("( 2 * 3 ) + ( 7 / 3 )", 8.333333333333334);
       assertEquals(" 2 + 3 * 4 ", 14);
       assertEquals(" (5 + 3) * (8 - 2) ", 48);
       System.out.println("\nAll tests completed.");
   }
 }
