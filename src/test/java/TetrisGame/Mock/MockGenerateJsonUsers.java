package TetrisGame.Mock;

import TetrisGame.Model.TetrisGameClient;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class MockGenerateJsonUsers {
  public static void generateJsonUsers() throws IOException {
    JSONObject jsonObject=new JSONObject();
    jsonObject.put("Estevan","1eG$5dgg");
    jsonObject.put("Julian","2fG$6dg@");
    jsonObject.put("Aurelio","3gG$7dg@");
    jsonObject.put("Cristian","4hG$8dg@");
    File file = new File(TetrisGameClient.getUSER_FILE());
    try (FileWriter writer = new FileWriter(file)) {
      jsonObject.write(writer);
      writer.flush();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }


  }
  public static void generateJsonPuntuation(){
    JSONObject jsonObject=new JSONObject();
    jsonObject.put("Estevan","100");
    jsonObject.put("Julian","100");
    jsonObject.put("Aurelio","100");
    jsonObject.put("Cristian","100");
    File file = new File(TetrisGameClient.getUSER_PUNTUATION());
    try (FileWriter writer = new FileWriter(file)) {
      jsonObject.write(writer);
      writer.flush();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
