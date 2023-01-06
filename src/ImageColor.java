/*
 * File Name: ImageColor.java
 * Name: David Crawley
 * Date: 1/06/2023
 * We can modify color array as follow 0-White, 1-Yellow, 1-Blue, 3-Red, 4-Green
 */
import java.awt.Color;
import java.awt.image.BufferedImage;
public class ImageColor {
	private final static int IMGSIZEX = 25;
    private final static int IMGSIZEY = 25;


    public BufferedImage getImage(int[][] data){
        BufferedImage image = new BufferedImage(IMGSIZEX, IMGSIZEY, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < IMGSIZEX; x++) {
            for (int y = 0; y < IMGSIZEY; y++) {
                int pixelColor = data[x][y];
                // Set Colors based on Binary Image value
                if (pixelColor == 0) {
                    pixelColor = Color.WHITE.getRGB();
                } else if (pixelColor == 1) {
                    pixelColor = Color.YELLOW.getRGB();
                } else if (pixelColor == 2) {
                	pixelColor = Color.BLUE.getRGB();
                } else if (pixelColor == 3) {
                	pixelColor = Color.GREEN.getRGB();
                } else if (pixelColor == 4) {
                	pixelColor = Color.RED.getRGB();
                }
                image.setRGB(x, y, pixelColor);
            } // End for y.
        }
        return image;
    }
}
