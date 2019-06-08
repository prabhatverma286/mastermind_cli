import java.util.Scanner;

public class Game {

    public static void main(String[] args)
    {
        CodeGenerator codeGenerator = new CodeGenerator();
        CodeChecker codeChecker = new CodeChecker();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Code has been generated. Please guess.");
        String input = scanner.nextLine();
        Colours[] inputColours = new Colours[0];

        try
        {
            inputColours = codeGenerator.stringToColours(input);
        }
        catch(IllegalAnswerLength ex)
        {
            System.out.println("Your answer is of incorrect length. You lose.");
            System.exit(1);
        }

        if(codeChecker.check(codeGenerator.getCode(), inputColours))
            System.out.println("You won!");
        else
            System.out.println("You lost...");

    }
}
