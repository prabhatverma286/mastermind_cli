import java.util.Arrays;
import java.util.Collections;

class DisplayManager {
    void showAvailableColours() {
        System.out.println("The available colours are :");

        for(Colours colour : Colours.values())
            System.out.print(colour.name() + ", ");

        System.out.println("\n\n");
    }

    void showInputInstructions(Match match) {
        System.out.println("Please enter " + match.CODE.length + " colours separated by spaces.");
        System.out.println("For example : Red Blue Green Yellow");
        System.out.println("Enter 'quit' to quit match");
        System.out.println("You have " + match.getGuessesRemaining() + " guesses remaining!");
    }

    void showMatch(Match match) {
        // show first line
        // show every line

        System.out.println(fixedLengthString("Number") + "|" +
                fixedLengthGuessHeading(match.CODE) + "|" +
                fixedLengthString("W R"));


        System.out.println("------------------------------------------------------------------------------------------"
        + "--------------------------------------");

        for(int i = 0; i < match.getTotalGuesses(); i++)
        {
            System.out.println(fixedLengthString(""+ (i+1)) + "|" +
                    fixedLengthGuessString(match.getGuesses()[i]) + "|" +
                    fixedLengthString(getNumberOfWhite(match.getFeedback()[i]) + " " + getNumberOfRed(match.getFeedback()[i])));
        }

        System.out.println();
    }

    private String getNumberOfWhite(FeedbackPegState[] feedback)
    {
        return String.valueOf(Collections.frequency(Arrays.asList(feedback), FeedbackPegState.WHITE));
    }

    private String getNumberOfRed(FeedbackPegState[] feedback)
    {
        return String.valueOf(Collections.frequency(Arrays.asList(feedback), FeedbackPegState.RED));
    }

    private String fixedLengthGuessString(Colours[] code) {
        StringBuilder codeString = new StringBuilder();

        for (Colours colours : code)
        {
            if(colours != null)
                codeString.append(fixedLengthString(colours.name()));
            else
                codeString.append(fixedLengthString("X"));
        }

        return codeString.toString();
    }

    private String fixedLengthGuessHeading(Colours[] code) {
        StringBuilder guessHeading = new StringBuilder(fixedLengthString("Guess"));

        for(int i = 0; i < (code.length - 1); i++)
            guessHeading.append(fixedLengthString(""));

        return guessHeading.toString();
    }

    void showWinStats(Match match) {
        System.out.println("Congratulations! You guessed the code correctly!");
        System.out.println("The final code was " + Arrays.toString(match.CODE));
        System.out.println("You took " + (match.getTotalGuesses() - match.getGuessesRemaining()) + " guesses!");
    }

    void showLossStats(Match match) {
        System.out.println("Sorry, you have no more guesses. You lose. :(");
        System.out.println("The code was " + Arrays.toString(match.CODE));
    }

    void greet() {
        System.out.println(Constants.GREET_MESSAGE);
    }

    void showInstructions() {
        System.out.println(Constants.INSTRUCTIONS);
    }

    void showExitMessage() {
        System.out.println(Constants.GOODBYE_MESSAGE);
    }

    private static String fixedLengthString(String string) {
        return String.format("%1$10s", string);
    }
}
