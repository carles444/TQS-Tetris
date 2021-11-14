package TetrisGame.Controller;

import java.awt.*;

public class GameFrame extends Frame {
    public GameFrame(){
        setLayout(new FlowLayout());
        setSize(0, 0  );
        Label l = new Label();
        l.setText("This is a demonstration");
        add(l);
        setVisible(true);

    }
    public void end() {
        this.dispose();
    }

}
