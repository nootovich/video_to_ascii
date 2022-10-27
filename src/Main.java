public class Main {

    // Some settings you can tweak to your needs (will be reworked to be dynamic)
    private static final int width = 1280, height = 720, FPS = 500;
    public static Window window = new Window(width, height);

    public static void main(String[] args) {

        // Render loop
        long prevFrame = 0, frameTime = 1_000_000_000 / FPS;
        while (true) {
            long time = System.nanoTime();
            long frameDiff = 0;
            if (prevFrame > 1) frameDiff = time - prevFrame - frameTime;
            if (frameDiff >= 0) {
                prevFrame = time - (frameDiff - frameTime);
                window.repaint();
            }
        }
    }
}


// Just some mess

// %&W#
// *O0X
// x?+~
// !^.

//  .^!~+ox*?xX0%&#W

//  `.-':_,^=;><+!rc*/z?sLTv)J7(|Fi{C}fI31tlu[neoZ5Yxjya]2ESwqkP6h9d4VpOGbUAKXHm8RD#$Bg0MNWQ%&@