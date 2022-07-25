import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class MyCanvas extends Canvas {
    private int width;
    private int height;

    public MyCanvas(int w, int h) {
        this.width = w;
        this.height = h;
    }

    public void paint(Graphics g) {
        int fontsize = 14;
        g.setFont(new Font("Consolas", Font.PLAIN, fontsize));
        String ascii = " .^!~+ox*?xX0%&#W";
        String otwo = " 02";
        int limit = 129;
        int count = 0;
        System.out.println(g.getFontMetrics().getHeight()+" "+height +" "+height / g.getFontMetrics().getHeight());
        while (count < limit) {
            g.setColor(new Color(0));
            g.fillRect(0, 0, width, height);
            StringBuilder result = new StringBuilder();
            count++;
            int nums = (int) Math.floor(Math.log10(count));
            String path = "images/toptyan" + "0".repeat(2 - nums) + count + ".png";
            try {
                BufferedImage picture = ImageIO.read(new File(path));
                for (int y = 0; y < picture.getHeight(this); y++) {
                    for (int x = 0; x < picture.getWidth(this); x++) {
                        int pixel = picture.getRGB(x, y);
                        int luma = (pixel >> 16) & 0xff / 16;
                        result.append(ascii.charAt(luma));
//                        switch (luma) {
//                            case 0, 1, 2, 3, 4 -> result.append(' ');
//                            case 5, 6, 7, 8, 9 -> result.append('0');
//                            case 10, 11, 12, 13, 14, 15 -> result.append('2');
//                        }
                    }
                    g.setColor(new Color(255, 255, 255));
                    g.drawString(result.toString(), 0, (int) (y * fontsize * 0.6));
                    result = new StringBuilder();
                }
//                g.drawImage(picture, 0, 0, width, height, this);
                Thread.sleep(45);
            } catch (IOException e) {
                System.out.println(count + " : " + nums + " : " + path);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.exit(69);
    }
}


// %&W#
// *O0X
// x?+~
// !^.

// " .^!~+ox*?xX0%&#W"