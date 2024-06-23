/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.client.beans;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author franksuarez
 */
public class ImageJComponent extends JComponent {

    class ImagePropertyChangeListener implements PropertyChangeListener {

        @Override
        public void propertyChange(PropertyChangeEvent pce) {
            System.out.printf("Property Changed: %s%n", pce.getPropertyName());
            switch (pce.getPropertyName()) {
                case "imagePath" -> {
                    try {
                        loadImage();
                    } catch (IOException ex) {
                        Logger.getLogger(ImageJComponent.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                default -> {

                }
            }
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    }

    
    
    
    
    
    private BufferedImage bufImg;
    private String imagePath = "";

    public ImageJComponent() {
        addPropertyChangeListener(new ImagePropertyChangeListener());
        
        
        
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        String oldImagePath = this.imagePath;
        this.imagePath = imagePath;
        firePropertyChange("imagePath", oldImagePath, imagePath);

    }

    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int w, int h) {
        System.out.printf("Image has been updated.%n");
        return super.imageUpdate(img, infoflags, x, y, w, h); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody

        g.drawImage(bufImg, 0, 0, this);
    }

    private void loadImage() throws IOException {
        System.out.printf("loadImage()%n");
        System.out.printf("imagePath = %s%n",this.imagePath);
        
        URL resource = getClass().getClassLoader().getResource(this.getImagePath());

        if (resource != null) {
            this.bufImg = ImageIO.read(resource);
            System.out.printf("bufImg = %s%n",this.bufImg.toString());
        } else {
            throw new NullPointerException();
        }
    }
}
