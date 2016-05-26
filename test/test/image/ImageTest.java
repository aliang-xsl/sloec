package test.image;

import java.io.File;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageTest {
	
	
	public static void main(String[] args) { 
		 
		//谷歌的图片处理框架
		//http://blog.csdn.net/wangpeng047/article/details/17610451
		try {
			
		/*	Thumbnails.of("E:/图片/test/_DSC0024.JPG")  
		    .size(2048,1362)  
		    .toFile("E:/图片/test/111.JPG"); */
			

			//watermark(位置，水印图，透明度)  
		/*	Thumbnails.of("E:/图片/test/IMAG0748.jpg")  
		    .size(2048,1362)  
		    .watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File("E:/图片/test/ysxz1.png")),0.8f)  
		    .outputQuality(0.8f)  
		    .toFile("E:/图片/test/555.JPG"); */
			//
			
			
			   File[] root = new File("E:\\图片\\test\\df").listFiles();
			   for (int i = 0; i < root.length; i++) {
				
				   Thumbnails.of(root[i].getPath())  
				    .size(2048,1362)  
				    .watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File("E:/图片/test/ysxz1.png")),0.8f)  
				    .outputQuality(0.8f)  
				    .toFile("E:\\图片\\test\\dfz\\"+i+".JPG");
				   System.out.println(root[i].getPath());
				   
				   Thread.sleep(1000*5);
			   }
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
