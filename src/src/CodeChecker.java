import java.util.Arrays;

public class CodeChecker {

    public boolean check(Colours[] code, Colours[] guess)
    {
        if(code.length != guess.length)
            return false;

        for(int i = 0; i < code.length; i++)
        {
            if(code[i] != guess[i])
                return false;
        }

        return true;
    }

    public FeedbackPegState[] checkWithFeedback(Colours[] code, Colours[] guess)
    {
        FeedbackPegState[] feedback = new FeedbackPegState[code.length];

        for(int i = 0; i < code.length; i++)
        {
            if(code[i] == guess[i])
                feedback[i] = FeedbackPegState.WHITE;
            else if(Arrays.asList(code).contains(guess[i]))
                feedback[i] = FeedbackPegState.RED;
            else
                feedback[i] = FeedbackPegState.NONE;
        }

        return feedback;
    }
}
