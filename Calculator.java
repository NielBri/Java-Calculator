public class Calculator {
    // make a pointer for the given expression that checks for each character
    private static String input; // Stores input current character
    private static int position; // Stores position 

    public static double evaluate(String expression) {

        input = expression.replace(" ", ""); // Checks if the current position is a space or not and become the current head
        position = 0; // Defaults at the start: "2+4/7" no. 2 would be position 0

        return expression(); // Saves the character at the input
    }

    // Add checker for + and -
    private static double expression() { // Makes current expression into a double

        double result = term();

        while (position < input.length()) {

            char operator = input.charAt(position); // Checks the input character at the position if it is not an integer
            // Check if + or - and move position up and then does the operation for result and the new term 
            if (operator == '+') {
                position++;
                result = result + term();

            } else if (operator == '-') {
                position++;
                result = result - term();

            } else {
                break;
            }
        }
        return result;
    }

    // Add a checker for * and /

    private static double term() { // Gets prioritized first to check * and / before + or - 

        double result = prioritizeTerm();

        while (position < input.length()) {

            char operator = input.charAt(position);

            if (operator == '*') {
                position++;
                result = result * prioritizeTerm();

            } else if (operator == '/') {
                position++;
                result = result / prioritizeTerm();

            } else {
                break;
            }
        }
        return result;
    }
    // Checker for parenthesis ()
     private static double prioritizeTerm() { // Skips the * and / Checker first to see the given

        if (input.charAt(position) == '(') {

            position++; // Moves to next to character
            double result = expression(); // Does the checks for the characters inside the parenthesis
            position++; // After all the checks it goes to ) and then skips it

            return result;
        }

        // This is the number checker for the current position
        int start = position;

        while (position < input.length()) {

            char current = input.charAt(position);

            if ((current >= '0' && current <= '9') || current == '.') {
                position++; // Checks to see if current number is a number or a decimal point and moves to the next number
            } else {
                break;
            }
        }

        return Double.parseDouble(input.substring(start, position)); // Makes the string into a Double especially for numbers with decimals
    }

   private static void assertEquals(String expression, double expected) {
       double actual = evaluate(expression); //TODO: Call your method here
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
