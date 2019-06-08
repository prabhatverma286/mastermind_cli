import java.util.Arrays;
import java.util.Random;

public class CodeGenerator {

    public Colours[] generateCode(int codeLength) throws IllegalCodeLength
    {
        Colours[] availableColours = Colours.values();
        if(codeLength > availableColours.length)
        {
            throw new IllegalCodeLength("Code length can't be more than available colours");
        }

        Random rand = new Random();

        Colours[] code = new Colours[codeLength];

        for(int i = 0; i < codeLength; i++)
        {
            Colours colour;
            do {
                 colour = availableColours[rand.nextInt(availableColours.length)];
            } while(Arrays.asList(code).contains(colour));

            code[i] = colour;
        }

        return code;
    }
}
