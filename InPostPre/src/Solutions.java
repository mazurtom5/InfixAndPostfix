import java.util.Scanner;
import java.util.Stack;

public class Solutions {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
        String input1 = "( ( 5.0 * 5 ) ^ ( 1 / 2 ) )";
        String input2 = "5 5 * 1 2 / ^";

        System.out.println(inFix(input1));
        System.out.println(postFix(input2));
    }

    public static double inFix(String input) {
        Stack<String> operator = new Stack<>();
        Stack<Double> operand = new Stack<>();
        double operand1;
        double operand2;
        String op;
        for ( String x : input.trim().split(" ") ) {
            try {
                operand.push(Double.parseDouble(x));
            }
            catch ( Exception e ) {
                switch (x) {
                    case "(":
                        break;
                    case ")": // end of parenthesis, operation must be conducted
                        operand2 = operand.pop();
                        operand1 = operand.pop();
                        op = operator.pop();
                            switch (op) {
                                case "^":
                                    operand.push(Math.pow(operand1, operand2));
                                    break;
                                case "*":
                                    operand.push(operand1 * operand2);
                                    break;
                                case "/":
                                    operand.push(operand1 / operand2);
                                    break;
                                case "+":
                                    operand.push(operand1 + operand2);
                                    break;
                                case "-":
                                    operand.push(operand1 - operand2);
                                    break;
                            }
                        break;
                    default :
                        operator.push(x);
                }
            }
        }

        return operand.pop();
    }



    public static double postFix( String input ) {
        Stack<String> operator = new Stack<>();
        Stack<Double> operand = new Stack<>();
        double operand1;
        double operand2;
        String op;
        for ( String x : input.trim().split(" ") ) {
            try {
                operand.push(Double.parseDouble(x));
            }
            catch ( Exception e ) {
                operand2 = operand.pop();
                operand1 = operand.pop();
                op = x;
                switch (op) {
                    case "^":
                        operand.push(Math.pow(operand1, operand2));
                        break;
                    case "*":
                        operand.push(operand1 * operand2);
                        break;
                    case "/":
                        operand.push(operand1 / operand2);
                        break;
                    case "+":
                        operand.push(operand1 + operand2);
                        break;
                    case "-":
                        operand.push(operand1 - operand2);
                        break;
                }
            }
        }

        return operand.pop();
    }
}
