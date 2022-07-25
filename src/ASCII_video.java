import javax.swing.*;

public class ASCII_video {

    public static void main(String[] args) {
        int width = 1290;
        int height = 785;
        MyCanvas m = new MyCanvas(width, height);
        JFrame f = new JFrame();
        f.add(m);
        f.setSize(width, height);
        f.setVisible(true);
    }
}
