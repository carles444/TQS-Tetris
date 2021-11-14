package TetrisGame.Model;


import TetrisGame.Controller.Player;
import org.json.JSONObject;
import org.json.JSONTokener;



import java.io.*;

public class TetrisGameClient {


    private final String USER_FILE="./data/file.json";
    private final String USER_PUNTUATION="./data/puntuation.json";

    public TetrisGameClient(){}

    public String getUSER_FILE() {
        return USER_FILE;
    }

    public String getUSER_PUNTUATION() {
        return USER_PUNTUATION;
    }

    //region -------------------------JSON, Save Puntuation, Login, RegisterUser ----------------------------------------
    //region Register User
    /*
    Este metodo se encarga de añadir el usario al JSON
    1 Primero comprueba que el formato de nombre del usuario sea el correcto.
    2 Comprueba el formato de la contraseña sea correcta
    ( contenga 8 caracteres entre ellas mayusculas, minusculas, numeros, caracteres especiales )
    3 Si cumple estas condiciones añadismo el usuario.
     */
    public boolean registerUser(String userName, String pasword) throws IOException {
        return ( isUserNameFormatCorrect(userName)&&isPasswordFormatCorrect(pasword) )? registerUserInJsonFile(userName,pasword):false;
    }

    /*
    Metodo que registra el usuario en un fichero JSON.
    1 Mirar si es el primer usuario del juego.
        1.1 Lo añadimos directamente
    2 Si no es el primer jugador del juego.
        2.1 Leemos el fichero JSON.
        2.2 Comprovamos que el usario no este repetido ->userNotExist().
     */
    private boolean registerUserInJsonFile(String userName, String password) throws IOException {

        boolean createUserIsOkey=true;

        if (isFirstsUser()){
            writeJson(new JSONObject(),userName,password,USER_FILE);
        }
        else{
            JSONObject jsonObject = readJson(USER_FILE);
            //JSONObject jsonObject=MockGenerateJsonUsers.getJsonUser();
            createUserIsOkey=userNotExist(jsonObject,userName);
            if (createUserIsOkey){
                writeJson(jsonObject,userName,password,USER_FILE);
            }
        }

        return createUserIsOkey;
    }
    //endregion

    //region Login
    /*
    Este metodo se encarga de hacer el login al sistema.
    1 Cargamos el fichero json.
    2 Comprovamos si el nombre de usuario existe.
        2.1 Si existe el usuario comprobamos que la contraseña sean iguales.
     */
    public boolean login(String userName, String password) throws FileNotFoundException {

        if (notExistUsers(USER_FILE)){
            return false;
        }
        JSONObject jsonObject = readJson(USER_FILE);
        //JSONObject jsonObject = MockGenerateJsonUsers.getJsonUser();
        if (userIsCorrect( jsonObject,  userName)){
            String passwordTemp=jsonObject.getString(userName);
            return passwordIsCorrect(passwordTemp,password);
        }
        return false;
    }
    //endregion


    //region Save Puntuation
    /*
    Este metodo se encarga de guardar la puntuación del jugador.
    1 Primero comprueba si el jugador tiene alguna partida guardad.
        1.1 Si no la tiene guarda directamente la puntuación actual.
    2 Si no es la primera partida de jugador.
        2.1 Comprobamos si la puntuación actual es mayor a la anterior.
        2.2 Por ultimo guardamos los cambios.
     */
    public boolean savePuntuation(Player player, int currentPuntution) throws IOException {
        //JSONObject jsonObject = MockGenerateJsonUsers.getJsonPuntuation();
        boolean isOkey=true;
        if (!isPuntuationFormatCorrect(currentPuntution)){
            return false;
        }
        if (notExistUsers(USER_PUNTUATION)){
            writeJson(new JSONObject(),player.getName(),String.valueOf(currentPuntution),USER_PUNTUATION);
        }
        else{
            JSONObject jsonObject = readJson(USER_PUNTUATION);
            //JSONObject jsonObject=MockGenerateJsonUsers.getJsonUser();

            if (userNotExist(jsonObject,player.getName())){
                writeJson(jsonObject,player.getName(),String.valueOf(currentPuntution),USER_PUNTUATION);
            }else{
                int lastPuntuation=jsonObject.getInt(player.getName());
                if (lastPuntuation<currentPuntution){
                    writeJson(jsonObject,player.getName(),String.valueOf(currentPuntution),USER_PUNTUATION);
                }
                else{
                    isOkey=false;
                }
            }
        }
        return isOkey;

    }
    //endregion


    //region Metodos complementarios
    private boolean userIsCorrect(JSONObject jsonObject , String userName){
       return  !jsonObject.isNull(userName);
    }
    private boolean passwordIsCorrect(String passwordTemp1,String passwordTemp2 ){
        return passwordTemp1.equals(passwordTemp2);
    }
    private boolean notExistUsers( String path){
        File targetFile = new File(path);
        return  !targetFile.exists() || targetFile.length()==0;
    }
    private boolean isFirstsUser(){
        File targetFile = new File(this.USER_FILE);
        return  !targetFile.exists() || targetFile.length()==0;
    }
    private boolean userNotExist(JSONObject jsonObject,String userName){
        return jsonObject.isNull(userName);
    }
    private void writeJson(JSONObject jsonObject,String Key, String Value,String fileWriter) throws IOException {
        File file = new File(fileWriter);

        jsonObject.put(Key,Value);
        try (FileWriter writer = new FileWriter(file)) {
            jsonObject.write(writer);
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    private JSONObject readJson(String fileRead) throws FileNotFoundException {
        InputStream is = new FileInputStream(new File(fileRead));
        JSONTokener tokener = new JSONTokener(is);
        JSONObject jsonObject = new JSONObject(tokener);
        return jsonObject;
    }
    //endregion

    //endregion





    //region -----------------------USER NAME FORMAT---------------------------------------

    /*
   Hemos decido que el nombre de usuario tiene que contener como maximo 8 caracteres.
   1 Primero comprobamos si el nombre no este vació o contenga más caracters de los indicados.
   2 Comprobamos que solo contengas caracteres alfabeticos.
    */
    public boolean isUserNameFormatCorrect(String userName){

        if ((isEmptyOrCantainScape(userName) || userName.length()>8)) {
            return false;
        }
        return userName.matches("^[a-zA-Z]*$");
    }

    //endregion


    //region---------------------PASSWORD FORMAT------------------------------------------
    /*
    Hemos decido que la contraseña tiene que contener como minino
    8 caracteres entre ellas Mayusculas, Minusculas, Numeros y caracteres especiales

    1 Primero comprobamos si la contraseña intruducida contiene el tamaño adecuado.
    2 Recorrecmos caracter por caracter.
        2.1 Si cumple alguna de las condiciones.
        2.2 A medida que las vaya cumpliendo "encendemos los flags".
     */
    public boolean isPasswordFormatCorrect(String password){
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

    //endregion

    //region -----------------------PUNTUATION FORMAT---------------------------------------

    /*
   Hemos decido que la puntuacion maxima del jujador sea de 999999.
   1 Primero comprobamos que la puntuacion se mayor de 0.
   2 Comprobamos que la puntuación se menor de 999999.
    */
    public  boolean isPuntuationFormatCorrect(int puntuation){
        boolean isOkeyFormat;
        isOkeyFormat= puntuation<0?false:true;
        isOkeyFormat=!isOkeyFormat || puntuation>999999?false:true;
        return isOkeyFormat;
    }


    //endregion

    //regions metodos complementarios para hacer el codigo autoExplicativo
    private boolean isEmptyOrCantainScape(String word){
        return word.isEmpty() || word.contains(" ");
    }
    private  boolean isIncorrectLenght(String password){
        return password.length()<8 || password.length()>16;
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

}
