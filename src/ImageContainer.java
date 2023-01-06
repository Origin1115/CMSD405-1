/*
 * File Name: ImageContainter.java
 * Name: David Crawley
 * Date: 1/06/2023
 */
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageContainer
{
    private final TransformAdjustment origTransform;
    private TransformAdjustment currentTransform;

    private BufferedImage image;

    public ImageContainer(BufferedImage image, TransformAdjustment startingTransform ){
        this.image = image;
        currentTransform = origTransform = startingTransform.clone();
    }
    
    public void TransformImage(Graphics2D graphics2D, TransformAdjustment newTransform, JPanel jPanel){
        currentTransform = currentTransform.getAdjustment(newTransform);
        applyCurrentTransform(graphics2D, jPanel);
    }

    public void ResetImage(Graphics2D graphics2D, JPanel jPanel){
        currentTransform = origTransform.clone();
        applyCurrentTransform(graphics2D, jPanel);
    }

    private void applyCurrentTransform(Graphics2D graphics2D, JPanel jPanel){
        graphics2D.translate(currentTransform.getTranslateX(), currentTransform.getTranslateY());
        graphics2D.rotate(currentTransform.getRotation());
        graphics2D.scale(currentTransform.getScaleX(), currentTransform.getScaleY());
        graphics2D.drawImage(image, 0, 0, jPanel);
    }
}
