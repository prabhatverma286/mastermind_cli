import java.util.Scanner;

public class Play {

    public static void main(String[] args)
    {
        CodeGenerator codeGenerator = new CodeGenerator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("The available colours are :");

        for(Colours colour : Colours.values())
            System.out.print(colour.name() + ", ");

        Colours[] generatedCode = null;
        while(generatedCode == null)
        {
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
        }

        System.out.println("Please enter the number of guesses you want");
        int numberOfGuesses = scanner.nextInt();

        Match match = new Match(
                generatedCode,
                numberOfGuesses
        );

        System.out.println("Code has been generated. Please guess.");
        scanner.nextLine(); //clean the input

        while(!match.isFinished()) {
            System.out.println("Please enter " + match.CODE.length + " colours separated by spaces.");
            System.out.println("For example : Red Blue Green Yellow");

            String input = scanner.nextLine();

            Colours[] inputColours = new Colours[0];

            inputColours = Utils.stringToColours(input);
            try {
                match.addGuess(inputColours);
            }
            catch (IllegalAnswerLength ex)
            {
                System.out.println("Your answer is of incorrect length. Please try again.");
                continue;
            }

            if(match.win)
            {
                System.out.println("You win!!!");
            }
            else
            {
                System.out.println("Incorrect Guess!");
            }

        }

        if(!match.win)
            System.out.println("You lost! :-( ");
    }
}
