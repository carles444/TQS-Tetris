package TetrisGame;

import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;



import java.io.*;
import java.util.ArrayList;

public class TetrisGameClient {
    private final String usersInfo = "usersInfo";

    private final String USER_FILE="./data/file.json";
    TetrisGameClient(){}

    public String getUSER_FILE() {
        return USER_FILE;
    }

    public boolean createUser(String userName, String pasword) throws IOException, ParseException {
        return ( isPasswordFormatCorrect(pasword)&&isUserNameFormatCorrect(userName))?addUser(userName,pasword):false;

    }


    private boolean addUser(String userName,String password) throws IOException, ParseException {


        boolean createUserIsOkey=true;

        if (isFirstsUser() ){
            writeJson(new JSONObject(),userName,password);
        }
        else{
            InputStream is = new FileInputStream(new File(this.USER_FILE));
            JSONTokener tokener = new JSONTokener(is);
            JSONObject jsonObject = new JSONObject(tokener);
            createUserIsOkey=userNotExist(jsonObject,userName);
            if (createUserIsOkey){
                writeJson(jsonObject,userName,password);
            }

        }
        return createUserIsOkey;

    }
    private boolean isFirstsUser()
    {
        File targetFile = new File(this.USER_FILE);
        boolean sadf=targetFile.exists();
        return  !targetFile.exists() || targetFile.length()==0;
    }
    private boolean userNotExist(JSONObject jsonObject,String userName){
        return jsonObject.isNull(userName);
    }
    private void writeJson(JSONObject jsonObject,String userName, String password) throws IOException {
        File file = new File(this.USER_FILE);
        jsonObject.put(userName,password);
        try (FileWriter writer = new FileWriter(file)) {
            jsonObject.write(writer);
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    //region---------------------------------Password Format------------------------------------------

    protected boolean isPasswordFormatCorrect(String password){
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
protected boolean isUserNameFormatCorrect(String userName){

        if ((isEmptyOrCantainScape(userName) || userName.length()>8)) {
            return false;
        }
        return userName.matches("^[a-zA-Z]*$");
    }


    protected boolean readJsonUsers(String fileName) throws FileNotFoundException {
        JSONObject object;
        JSONTokener tokener;
        File targetFile = new File(fileName);
        InputStream is = new FileInputStream(targetFile);
        tokener = new JSONTokener(is);
        object = new JSONObject(tokener);


        return true;
    }
}
