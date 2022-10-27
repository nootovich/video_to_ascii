import javax.swing.*;

// This class is literally just to remove java cutting off top of the render
public class Window extends JFrame {

    Window(int width, int height) {
        Screen screen = new Screen(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(screen);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}