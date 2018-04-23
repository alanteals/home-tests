package com.mruiz84.home.image;

import org.junit.Assert;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Image.SCALE_DEFAULT        – uses the default image-scaling algorithm.
 * Image.SCALE_FAST           – uses an image-scaling algorithm that gives higher priority to scaling speed than smoothness of the scaled image.
 * Image.SCALE_SMOOTH         – uses an image-scaling algorithm that gives higher priority to image smoothness than scaling speed.
 * Image.SCALE_REPLICATE      – use the image scaling algorithm embodied in the ReplicateScaleFilter class.
 * Image.SCALE_AREA_AVERAGING – uses the area averaging image scaling algorithm.
 */
public class ResizeImageTest {

    final private String IMAGE_NAME = "forest.jpg";

    @Test
    public void resizeImageScaleDefault() {
        resizeImageScale(Image.SCALE_DEFAULT, 500, 500);
    }

    @Test
    public void resizeImageScaleFast() {
        resizeImageScale(Image.SCALE_FAST,500, 500);
    }

    @Test
    public void resizeImageScaleSmooth() {
        resizeImageScale(Image.SCALE_SMOOTH, 500, 500);
    }

    @Test
    public void resizeImageScaleReplicate() {
        resizeImageScale(Image.SCALE_REPLICATE,500, 500);
    }

    @Test
    public void resizeImageScaleAreaAveraging() {
        resizeImageScale(Image.SCALE_AREA_AVERAGING,500, 500);
    }

    // https://memorynotfound.com/java-resize-image-fixed-width-height-example/
    private void resizeImageScale(int scalingAlgorithm, int width, int height){

        URL imageResource = getClass().getClassLoader().getResource(IMAGE_NAME);
        File file = new File(imageResource.getFile());
        try {
            BufferedImage image = ImageIO.read(file);
            BufferedImage resized = resize(image, scalingAlgorithm, width, height);

            String imareResizedName = "/"+IMAGE_NAME+"-resized-"+width+"x"+height+"-by-"+scalingAlgorithm+".png";
            File output = new File(file.getParent() + imareResizedName);
            ImageIO.write(resized, "png", output);

        } catch (IOException ioe) {
            Assert.fail(ioe.getMessage());
        }
    }

    private BufferedImage resize(BufferedImage img, int scalingAlgorithm, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, scalingAlgorithm);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
    
}
