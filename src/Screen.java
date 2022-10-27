import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// TODO: Make controls:
// Choice for the animation to loop or start manually
// Choice of small or big dic(t)
// For loading of images (maybe video at some point)

public class Screen extends JPanel {
    private final int width, height;
    private final String bigDictionary = " `.-':_,^=;><+!rc*/z?sLTv)J7(|Fi{C}fI31tlu[neoZ5Yxjya]2ESwqkP6h9d4VpOGbUAKXHm8RD#$Bg0MNWQ%&@";
    private final String smallDictionary = " .^!~+ox*?xX0%&#W";
    private int count = 0;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));
        setVisible(true);
        setBounds(0, 0, width, height);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Set font
        int fontSize = 10;
        g2d.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, fontSize));

        // TODO: Remove "limit" and make it automatically detect next images to load
        int limit = 8;

        // TODO: Rework "count" variable
        if (count >= limit) count = 0;
        count++;

        // Draw bg
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, width, height);

        // Amount of numbers in count (0-9 is 1, 10-99 is 2, 100-999 is 3 and so on)
        // Will be removed in loading rework
        int nums = (int) Math.floor(Math.log10(count));

        String path = "images/<name of image files>" + "0".repeat(1 - nums) + count + ".png";

        // TODO: REMOVE TRY-CATCH BLOCK!!!
        try {

            // Loads a current image
            BufferedImage picture = ImageIO.read(new File(path));

            // Goes through each row of pixels (and each line accordingly)
            for (int y = 0; y < picture.getHeight(this); y++) {

                // Goes through each pixel
                for (int x = 0; x < picture.getWidth(this); x++) {

                    // Gets current pixel value and converts it
                    int pixel = picture.getRGB(x, y);
                    int red = (pixel >> 16) & 0xff, green = (pixel >> 8) & 0xff, blue = pixel & 0xff;
                    int luma = (int) ((red + green + blue) * (bigDictionary.length() / 768.0f));

                    // Draws current character
                    g2d.setColor(new Color(red, green, blue));
                    g2d.drawString(String.valueOf(bigDictionary.charAt(luma)), x * (Main.window.getWidth() / picture.getWidth()), y * (Main.window.getHeight() / picture.getHeight()));
                }
            }

            // TODO: REMOVE TRY-CATCH BLOCK!!!
        } catch (IOException e) {
            System.out.println("could not load file:" + path + "[" + count + " : " + nums + "]");
        }
    }
}
