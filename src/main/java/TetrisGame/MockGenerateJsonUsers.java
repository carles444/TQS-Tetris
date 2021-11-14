package TetrisGame;

import org.json.JSONObject;

public class MockGenerateJsonUsers {
  public static JSONObject getJsonUser(){
    JSONObject jsonObject=new JSONObject();
    jsonObject.put("Estevan","1eG$5dg");
    jsonObject.put("Julian","2fG$6dg@");
    jsonObject.put("Aurelio","3gG$7dg@");
    jsonObject.put("Cristian","4hG$8dg@");

    return jsonObject;

  }
  public static JSONObject getJsonPuntuation(){
    JSONObject jsonObject=new JSONObject();
    jsonObject.put("Estevan","200");
    jsonObject.put("Julian","1000");
    jsonObject.put("Aurelio","10000");
    jsonObject.put("Cristian","10500");

    return jsonObject;

  }
}
