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
}
