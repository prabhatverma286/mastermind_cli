import java.util.Scanner;

public class Play {

    // TODO: new match - maintain scoreboard
    // TODO: Java.awt.Colours

    public static void main(String[] args)
    {
        CodeGenerator codeGenerator = new CodeGenerator();
        CodeChecker codeChecker = new CodeChecker();
        DisplayManager displayManager = new DisplayManager();
        Scanner scanner = new Scanner(System.in);

        displayManager.greet();
        displayManager.showInstructions();
        displayManager.showAvailableColours();

        Colours[] generatedCode = null;
        while(generatedCode == null)
        {
            generatedCode = getGeneratedCode(codeGenerator, scanner);
        }

        System.out.println("Please enter the number of guesses you want");
        int numberOfGuesses = scanner.nextInt();

        Match match = new Match(
                generatedCode,
                numberOfGuesses
        );

        System.out.println("New match created!");
        scanner.nextLine(); //clean the input

        while(!match.isFinished()) {

            displayManager.showMatch(match);
            displayManager.showAvailableColours();
            displayManager.showInputInstructions(match);

            String input = getNextInput(displayManager, scanner);

            if (!validateAndSaveInput(codeChecker, match, input)) continue;

            if(match.win)
                displayManager.showWinStats(match);
            else
                System.out.println("Incorrect Guess!");
        }

        if(!match.win)
            displayManager.showLossStats(match);
    }

    private static boolean validateAndSaveInput(CodeChecker codeChecker, Match match, String input) {
        Colours[] inputColours;
        try {
            inputColours = Utils.stringToColours(input);
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            return false;
        }

        try {
            match.addGuess(inputColours, codeChecker);
        }
        catch (IllegalAnswerLength ex)
        {
            System.out.println("Your answer is of incorrect length. Please try again.");
            return false;
        }
        return true;
    }

    private static String getNextInput(DisplayManager displayManager, Scanner scanner) {
        String input = scanner.nextLine();

        if(input.toUpperCase().equals("QUIT"))
        {
            System.out.println("You are in the middle of a game! Are you sure? (Yes/No)");
            input = scanner.nextLine();

            if(input.toUpperCase().equals("YES")) {
                displayManager.showExitMessage();
                System.exit(0);
            }

        }
        return input;
    }

    private static Colours[] getGeneratedCode(CodeGenerator codeGenerator, Scanner scanner) {
        Colours[] generatedCode;
        System.out.println("Please enter the code length to generate");
        int codeLength = scanner.nextInt();
        try {
            generatedCode = codeGenerator.generateCode(codeLength);
        }
        catch (IllegalCodeLength ex)
        {
            System.out.println(ex.getMessage());
            System.out.println("Please try again.");
            generatedCode = null;
        }
        return generatedCode;
    }
}
