import java.util.Random;

public class CodeGenerator {

    private final Colours[] CODE;
    private final Colours[] CHOSEN_COLOURS;

    public CodeGenerator(Colours[] chosenColours) {
        CHOSEN_COLOURS = chosenColours;
        CODE = generateCode(chosenColours);
    }

    public CodeGenerator() {
        CHOSEN_COLOURS = Colours.values();
        CODE = generateCode(CHOSEN_COLOURS);
    }

    public Colours[] getCode()
    {
        return CODE;
    }

    public Colours[] stringToColours(String input_line) throws IllegalAnswerLength
    {
        String[] colourStrings = input_line.split(" ");
        if(colourStrings.length != CODE.length)
        {
            throw new IllegalAnswerLength("Input length and Code length do not match");
        }

        Colours[] guess = new Colours[colourStrings.length];

        for(int i = 0; i < colourStrings.length; i++)
        {
            guess[i] = Colours.valueOf(colourStrings[i].toUpperCase());
        }

        return guess;
    }

    private Colours[] generateCode(Colours[] chosenColours)
    {
        Random rand = new Random();

        Colours[] code = new Colours[4];

        for(int i = 0; i < 4; i++)
        {
            code[i] = chosenColours[rand.nextInt(chosenColours.length)];
        }

        return code;
    }
}
