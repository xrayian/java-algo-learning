public class Main {

    public static void main(String[] args) {
        String expression = "[{(5) + ]3[}<5>>";
        StringOperations operations = new StringOperations();

        System.out.println(operations.isExpressionBalanced(expression));
    }
}