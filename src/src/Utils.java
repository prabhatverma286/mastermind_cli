public class Utils {

    public static Colours[] stringToColours(String input_line)
    {
        String[] colourStrings = input_line.split(" ");

        Colours[] guess = new Colours[colourStrings.length];

        for(int i = 0; i < colourStrings.length; i++)
        {
            guess[i] = Colours.valueOf(colourStrings[i].toUpperCase());
        }

        return guess;
    }
}
