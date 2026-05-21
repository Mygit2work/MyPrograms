

public class Palindrom {

    /**
     * Check if a string is a palindrome
     * Ignores spaces, special characters, and case
     *
     * @param input the string to check
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindromeOptimized(String input) {
        // Null check BEFORE processing
        if (input == null || input.trim().isEmpty()) {
            return false;
        }

        // Remove non-alphanumeric characters and convert to lowercase
        String cleaned = input.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        // Handle edge cases
        if (cleaned.length() <= 1) {
            return true;
        }

        // Check palindrome using two pointers
        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    /**
     * Alternative method using StringBuilder (More concise)
     */
    public static boolean isPalindromeSimple(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }

        String cleaned = input.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }

    /**
     * Main method - Entry point of the program
     */
    public static void main(String[] args) {
        System.out.println("=== Java Programs Practice ===\n");

        // Test Palindrome - Optimized Method
        testPalindromeOptimized();

        // Test Palindrome - Simple Method
        testPalindromeSimple();
    }

    /**
     * Test the optimized palindrome method using two-pointer approach
     */
    private static void testPalindromeOptimized() {
        System.out.println("--- Palindrome Check (Two-Pointer Method) ---");

        String[] testCases = {
                "Na  #$yan",
                "racecar",
                "hello",
                "A man a plan a canal Panama",
                "12321",
                "12345",
                "",
                null
        };

        for (String test : testCases) {
            try {
                boolean result = isPalindromeOptimized(test);
                System.out.println("\"" + test + "\" -> " + (result ? "✓ Palindrome" : "✗ Not a palindrome"));
            } catch (Exception e) {
                System.out.println("\"" + test + "\" -> Error: " + e.getMessage());
            }
        }
        System.out.println();
    }

    /**
     * Test the simple palindrome method using StringBuilder
     */
    private static void testPalindromeSimple() {
        System.out.println("--- Palindrome Check (StringBuilder Method) ---");

        String[] testCases = {
                "Na  #$yan",
                "racecar",
                "hello",
                "A man a plan a canal Panama"
        };

        for (String test : testCases) {
            boolean result = isPalindromeSimple(test);
            System.out.println("\"" + test + "\" -> " + (result ? "✓ Palindrome" : "✗ Not a palindrome"));
        }
    }
}
