import java.util.Random;

public class Code_Generator {

    private final Colours[] CODE;

    public Code_Generator(Colours[] chosenColours) {
        CODE = generateCode(chosenColours);
    }

    public Colours[] getCode()
    {
        return CODE;
    }

    private Colours[] generateCode(Colours[] chosenColours) {
        Random rand = new Random();

        Colours[] code = new Colours[4];

        for(int i = 0; i < 4; i++)
        {
            code[i] = chosenColours[rand.nextInt(chosenColours.length)];
        }

        return code;
    }
}
