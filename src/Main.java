import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("Racecar"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Don't node"));
        System.out.println("==================================");
        System.out.println(checkForPalindrome2("I did, did I?"));
        System.out.println(checkForPalindrome2("Racecar"));
        System.out.println(checkForPalindrome2("hello"));
        System.out.println(checkForPalindrome2("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindrome2("abccba"));
        System.out.println(checkForPalindrome2("Don't node"));
        System.out.println("==================================");
        convertDecimalToBinary(5);
        System.out.println();
        convertDecimalToBinary(6);
        System.out.println();
        convertDecimalToBinary(13);
        System.out.println();
    }

    public static boolean checkForPalindrome(String text) {
        Stack<Character> stack = new Stack<>();
        String textWithoutPunctuation = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for (int i = 0; i < textWithoutPunctuation.length(); i++) {
            stack.push(textWithoutPunctuation.charAt(i));
        }
        String reversedText = "";

        while (!stack.isEmpty()) {
            reversedText += stack.pop();
        }

        return textWithoutPunctuation.equalsIgnoreCase(reversedText);
    }

    public static boolean checkForPalindrome2(String text) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        String textWithoutPunctuation = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for (int i = 0; i < textWithoutPunctuation.length(); i++) {
            queue.add(textWithoutPunctuation.charAt(i));
            stack.push(textWithoutPunctuation.charAt(i));
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.remove())) {
                return false;
            }
        }

        return true;
    }

    public static void convertDecimalToBinary(int number) {
        Stack<Integer> stack = new Stack<>();
        while (number > 0) {
            int remainder = number % 2;
            stack.push(remainder);
            number /= 2;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

}