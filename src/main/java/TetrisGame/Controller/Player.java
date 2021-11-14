package TetrisGame.Controller;

public class Player {
    private int topScore;
    private String name;
    public Player(){}


    public String getName() {
        return name;
    }

    public  boolean setName(String name){
        boolean isCorrectFormat=comproveName(name);
        this.name=isCorrectFormat?name:"";
        return isCorrectFormat;
    }
    private boolean comproveName(String name){
        if ((name.isEmpty() || name.length()>8)) {
            return false;
        }
        for (int x = 0; x < name.length(); x++) {
            char c = name.charAt(x);
            // Si no está entre a y z, ni entre A y Z, ni es un espacio
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') )) {
                return false;
            }
        }
        return true;
    }

    public  boolean setTopScore(int puntuation){
        boolean isOkeyFormat=true;
        boolean ret=false;
        isOkeyFormat= puntuation<0?false:true;
        isOkeyFormat=!isOkeyFormat || puntuation>999999?false:true;

        if (isOkeyFormat ){
            ret=true;
            this.topScore=puntuation;
        }
        return ret;
    }




}
