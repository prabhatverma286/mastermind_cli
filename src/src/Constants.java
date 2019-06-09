class Constants {
    static String GREET_MESSAGE = "Hi and welcome to a command line version of the game Mastermind!";
    static String INSTRUCTIONS = "The objective of the game is for you to guess a code of colours that I generate. \n\n" +
            "Different to the original mastermind game, here you can specify the length of the code that I generate.\n" +
            "You can choose the length of the code and it can be anywhere between 1 and 10. \n" +
            "You can also choose the number of guesses that you want to be able to crack the code \n" +
            "Use these two parameters to alter the difficulty of your match! \n\n" +
            "To win the game, you will have to guess the code with all the correct colours in their correct position.\n\n" +
            "The code that I generate will contain a colour only once, so keep that in mind when guessing.\n\n" +
            "For each guess, I will give you a feedback. \n" +
            "A 'white' feedback means ANY one the colours that you guessed is correct and in the correct position. (YAY!)\n" +
            "A 'red' feedback means ANY one of the colours that you guessed is correct, but in the wrong position. (GOOD!)\n" +
            "With each guess, I will give you the number of 'white' and 'red' feedbacks.\n\n" +
            "You will also be able to see your previous guesses and use them to crack the code!\n\n" +
            "Also, you can quit at any time by typing 'quit'. \n\n" +
            "Good Luck!\n\n"
            ;
    static String GOODBYE_MESSAGE = "Thank you for playing with me! Bye!";
}
