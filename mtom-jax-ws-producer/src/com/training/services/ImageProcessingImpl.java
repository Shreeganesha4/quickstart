package com.training.services;



import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



import javax.imageio.ImageIO;
import javax.jws.WebService;



import com.training.ifaces.ImageProcessing;
@WebService(endpointInterface="com.training.ifaces.ImageProcessing")
public class ImageProcessingImpl implements ImageProcessing {



   @Override
    public Image getImage(String imageName) {
        
        try {
            return ImageIO.read(new File(imageName));
        } catch (IOException e) {
           
            e.printStackTrace();
            return null;
        }
    }

@Override
public String sendImage(Image image) {
	
	BufferedImage buffImage=(BufferedImage) image;
	
	try {
		ImageIO.write(buffImage, "png", new File("download.png"));
		return "Image upload success!!!";
	} catch (IOException e) {
		
		e.printStackTrace();
		return "image upload failed!!!";
	}
	
	
}



}