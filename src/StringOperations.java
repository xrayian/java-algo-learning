import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StringOperations {
    private final List<Character> openingBrackets = Arrays.asList('(', '[', '<', '{');
    private final List<Character> closingBrackets = Arrays.asList(')', ']', '>', '}');


    private boolean matchOpeningBracket(char ch) {
        return openingBrackets.contains(ch);
    }

    private boolean matchClosingBracket(char ch) {
        return closingBrackets.contains(ch);
    }

    private boolean validateBracketPair(char opening, char closing) {
        return openingBrackets.indexOf(opening) == closingBrackets.indexOf(closing);
    }

    public boolean isExpressionBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (matchOpeningBracket(ch))
                stack.push(ch);
            if (matchClosingBracket(ch)) {
                if (stack.empty()) return false;
                if (!validateBracketPair(stack.pop(), ch)) return false;
            }
        }
        return stack.empty();
    }
}
