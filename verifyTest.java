import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class QuizTest {

    @Test
    public void testQuestionOptions() {
        // Assuming the questions and their options are stored in a data structure accessible to the test.
        // For this example, I'll represent the questions and options as lists of strings.

        List<String> question1Options = Arrays.asList("undefined", "5", "10", "SyntaxError", "null");
        List<String> question2Options = Arrays.asList("[x^2 for x in range(1,6)]", "[x*x for x in range(1,6)]", "range(1,5).map(lambda x: x*x)", "[x** for x in range(1,6)]", "map(lambda x: x*x, range(1,6))");
        List<String> question3Options = Arrays.asList("Defining the same method in different classes", "Calling multiple methods at once", "Same method name with different parameters", "Same return type with different names", "None of the above");
        List<String> question4Options = Arrays.asList("<div>", "<span>", "<header>", "<b>", "<font>");
        List<String> question5Options = Arrays.asList("Centers content vertically", "Moves content to right", "Horizontally centers child items", "Makes content bold", "Hides content");
        List<String> question6Options = Arrays.asList("class Child inherits Parent {}", "class Child extends Parent {}", "class Child : public Parent {}", "inherit Child from Parent", "Child -> Parent");
        List<String> question7Options = Arrays.asList("null", "undefined", "object", "false", "number");
        List<String> question8Options = Arrays.asList("func myFunc() {}", "function myFunc:", "def myFunc():", "myFunc => ()", "function: myFunc()");
        List<String> question9Options = Arrays.asList("int ptr = *x;", "int* ptr;", "int ptr* ;", "pointer<int> ptr;", "int &ptr;");
        List<String> question10Options = Arrays.asList("<responsive>", "@media queries", "<script>", "<layout>", "<css-grid>");


        // Assert that the number of options for each question is correct.
        assertEquals(5, question1Options.size());
        assertEquals(5, question2Options.size());
        assertEquals(5, question3Options.size());
        assertEquals(5, question4Options.size());
        assertEquals(5, question5Options.size());
        assertEquals(5, question6Options.size());
        assertEquals(5, question7Options.size());
        assertEquals(5, question8Options.size());
        assertEquals(5, question9Options.size());
        assertEquals(5, question10Options.size());

        // You can add assertions to check the content of each option, e.g.,
        assertTrue(question1Options.contains("10"));
        assertTrue(question2Options.contains("[x*x for x in range(1,6)]"));
        assertTrue(question3Options.contains("Same method name with different parameters"));
        assertTrue(question4Options.contains("<header>"));
        assertTrue(question5Options.contains("Horizontally centers child items"));
        assertTrue(question6Options.contains("class Child : public Parent {}"));
        assertTrue(question7Options.contains("object"));
        assertTrue(question8Options.contains("def myFunc():"));
        assertTrue(question9Options.contains("int* ptr;"));
        assertTrue(question10Options.contains("@media queries"));
    }
}
