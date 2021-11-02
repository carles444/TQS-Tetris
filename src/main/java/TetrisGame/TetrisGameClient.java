package TetrisGame;


import java.util.ArrayList;

public class TetrisGameClient {
    TetrisGameClient(){}

    public boolean createUser(String name, String pasword){
        return isPasswordFormatCorrect(pasword)&&isUserNameFormatCorrect(name);
    }
    //region---------------------------------Password Format------------------------------------------

    private boolean isPasswordFormatCorrect(String password){
        boolean haveUpperCase=false;
        boolean haveLowerCase=false;
        boolean haveDigit=false;
        boolean haveSpecialCaracter=false;
        if ((isEmptyOrCantainScape(password) ||isIncorrectLenght(password) )) {
            return false;
        }
        for (int x = 0; x < password.length(); x++) {
            char c = password.charAt(x);
            haveUpperCase= (haveUpperCase || isUpperCase(c))?true:false;
            haveLowerCase= (haveLowerCase || isLowerCase(c))?true:false;
            haveDigit= (haveDigit || isDigit(c))?true:false;
            haveSpecialCaracter= (haveSpecialCaracter || isSpecialCaracter(c))?true:false;
        }
        return haveUpperCase && haveLowerCase && haveDigit && haveSpecialCaracter;
    }
    private boolean isEmptyOrCantainScape(String password){
        return password.isEmpty() && !password.contains(" ");
    }
    private  boolean isIncorrectLenght(String password){
        return password.length()!=8;
    }
    private boolean isUpperCase(char ch){
        return Character.isUpperCase(ch);
    }
    private boolean isLowerCase(char ch){
        return Character.isLowerCase(ch);
    }
    private boolean isDigit(char ch){
        return Character.isDigit(ch);
    }
    private boolean isSpecialCaracter(char ch){
        return !Character.isDigit(ch) && !Character.isLetter(ch) && !Character.isWhitespace(ch);
    }
    //endregion
private boolean isUserNameFormatCorrect(String userName){

        if ((isEmptyOrCantainScape(userName) || userName.length()>8)) {
            return false;
        }
        return userName.matches("^[a-zA-Z]*$");
    }
}
