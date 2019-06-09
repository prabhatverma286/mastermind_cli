class Match {
    final Colours[] CODE;

    private Colours[][] guesses;
    private FeedbackPegState[][] feedback;

    private int guessesRemaining;

    int getTotalGuesses() {
        return totalGuesses;
    }

    private int totalGuesses;
    boolean win = false;

    Match(Colours[] CODE, int numberOfGuesses) {
        this.CODE = CODE;

        totalGuesses = numberOfGuesses;
        guessesRemaining = numberOfGuesses;

        guesses = new Colours[numberOfGuesses][CODE.length];
        feedback = new FeedbackPegState[numberOfGuesses][CODE.length];
    }

    boolean isFinished() {
        return win || guessesRemaining <= 0;
    }

    int getGuessesRemaining() {
        return guessesRemaining;
    }

    Colours[][] getGuesses() {
        return guesses;
    }

    FeedbackPegState[][] getFeedback() {
        return feedback;
    }

    void addGuess(Colours[] guess, CodeChecker codeChecker) throws IllegalAnswerLength{

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
