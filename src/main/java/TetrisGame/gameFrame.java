package TetrisGame;

import java.awt.*;

public class gameFrame extends Frame {
    public gameFrame(){
        setLayout(new FlowLayout());
        setSize(0, 0  );
        Label l = new Label();
        l.setText("This is a demonstration");
        add(l);
        setVisible(true);

    }

}
