import java.util.Scanner;

public class Match {
    public final Colours[] CODE;

    private Colours[][] guesses;
    private FeedbackPegState[][] feedback;

    private CodeChecker codeChecker;
    private int guessesRemaining;
    private int totalGuesses;

    public boolean win = false;

    public Match(Colours[] CODE, int numberOfGuesses) {
        this.CODE = CODE;

        codeChecker = new CodeChecker();
        totalGuesses = numberOfGuesses;
        guessesRemaining = numberOfGuesses;

        guesses = new Colours[numberOfGuesses][CODE.length];
        feedback = new FeedbackPegState[numberOfGuesses][CODE.length];
    }

    public boolean isFinished() {
        return win || guessesRemaining <= 0;
    }

    public Colours[][] getGuesses() {
        return guesses;
    }

    public FeedbackPegState[][] getFeedback() {
        return feedback;
    }

    public void addGuess(Colours[] guess) throws IllegalAnswerLength{

        if(guess.length != CODE.length)
            throw new IllegalAnswerLength("Input length and Code length do not match");

        guesses[totalGuesses - guessesRemaining] = guess;
        FeedbackPegState[] latestFeedback = codeChecker.checkWithFeedback(CODE, guess);
        feedback[totalGuesses - guessesRemaining] = latestFeedback;
        win = check(latestFeedback);

        guessesRemaining--;
    }

    private boolean check(FeedbackPegState[] feedback) {
        for(FeedbackPegState state : feedback)
        {
            if(state != FeedbackPegState.WHITE)
                return false;
        }

        return true;
    }
}
