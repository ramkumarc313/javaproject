package com.test;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.test1.ProVars;

public class BarcodePdfDAO {
	private BaseFont bfSig;
	private BaseColor bf;
	public static void main(String args[]) throws IOException
	{
		BarcodePdfDAO dao = new BarcodePdfDAO();
		
		dao.barcodePrint();
		
	}

	public String barcodePrint() throws IOException{
		
		Document doc = new Document(PageSize.A4);
		initializeFonts();
		String fileName ="";
		PdfWriter docWriter = null;
		String filePath = null; 
		try{
			FilePath fp = new FilePath();
			java.util.Date date = new java.util.Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhmmss");
			fileName = (sdf.format(new Timestamp(date.getTime())));
			fileName = "barcode"+"_"+fileName+".pdf";
			
			filePath = fp.getFilePath()+fileName;
			docWriter = PdfWriter.getInstance(doc , new FileOutputStream(filePath));
			doc.open();
			PdfContentByte cb = docWriter.getDirectContent(); 
			generateBarcode(doc,cb,"7657657656757656757780147574654");
			
		}
		
		catch (DocumentException dex) {
			dex.printStackTrace();
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		} 
		finally{
			try{
				if (doc != null){
					doc.close();
				}
				if (docWriter != null){
					docWriter.close();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		return fileName;

		
	}




	

	private void generateBarcode(Document doc, PdfContentByte cb,String InvoiceNumber)
	{
		try
		{

			int i=1;
			int z=910;

			//while(i<=4)
			//{
			String barcodeNumber=(InvoiceNumber);

			int x = 230;
			x = x + (80 - (barcodeNumber.length() * 3 - 3)); 
			String barcodeValue = barcodeNumber;

			Barcode barcode = BarcodeFactory.createCode128(barcodeValue);
			barcode.setDrawingText(true);  
			barcode.setBarHeight(5);  
			barcode.setBarWidth(1);  

			BufferedImage bufferImage = new BufferedImage(40, 40, BufferedImage.TYPE_BYTE_GRAY);  
			Graphics2D g = (Graphics2D) bufferImage.getGraphics();  
			barcode.draw(g, 180, 15);
			byte [] bytes = null;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			// BarcodeImageHandler.writeJPEG(barcode, baos);
			BarcodeImageHandler.outputBarcodeAsJPEGImage(barcode, baos);
			bytes = baos.toByteArray();
			Image barcodeImage = Image.getInstance(bytes);
			barcodeImage.setAbsolutePosition(340,710);
			createAddress(cb, 370, 790, barcodeNumber, 20);
			barcodeImage.scalePercent(1);
			barcodeImage.scaleAbsolute (150, 70);// 105,40
			barcodeImage.setCompressionLevel(2);

			//createAddress(cb, 370, 790, barcodeNumber, 20);
			doc.add(barcodeImage);

			barcodeImage.setAbsolutePosition(340,510);
			createAddress(cb, 370, 590, barcodeNumber, 20);
			barcodeImage.scalePercent(1);
			barcodeImage.scaleAbsolute (150, 70);// 105,40
			barcodeImage.setCompressionLevel(2);
			doc.add(barcodeImage);
			barcodeImage.setAbsolutePosition(340,310);
			createAddress(cb, 370, 390, barcodeNumber, 20);
			barcodeImage.scalePercent(1);
			barcodeImage.scaleAbsolute (150, 70);// 105,40
			barcodeImage.setCompressionLevel(2);
			doc.add(barcodeImage);
			barcodeImage.setAbsolutePosition(340,80);

			barcodeImage.scalePercent(1);
			barcodeImage.scaleAbsolute (150, 70);// 105,40
			barcodeImage.setCompressionLevel(2);
			createAddress(cb, 370, 170, barcodeNumber, 20);
			//createAddress(cb, 370, 790, barcodeNumber, 20);
			doc.add(barcodeImage);
			//i++;
			//}
		}
		catch(Exception e)
		{
			Date errDate = new Date();
			System.out.println("Error in generateBarcode :"+errDate.toString()+"\nMessage :\n"+e.getMessage());

		}
	}

	private void generateSingleBarcode(Document doc, PdfContentByte cb,String barcodeNumber)
	{
		try
		{

			int i=1;
			int z=910;

			//while(i<=4)
			//{

			int x = 230;
			x = x + (80 - (barcodeNumber.length() * 3 - 3)); 
			String barcodeValue = barcodeNumber;

			Barcode barcode = BarcodeFactory.createCode128(barcodeValue);
			barcode.setDrawingText(true);  
			barcode.setBarHeight(5);  
			barcode.setBarWidth(1);  

			BufferedImage bufferImage = new BufferedImage(40, 40, BufferedImage.TYPE_BYTE_GRAY);  
			Graphics2D g = (Graphics2D) bufferImage.getGraphics();  
			barcode.draw(g, 180, 15);
			byte [] bytes = null;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			//BarcodeImageHandler.writeJPEG(barcode, baos);
			BarcodeImageHandler.outputBarcodeAsJPEGImage(barcode, baos);
			bytes = baos.toByteArray();
			Image barcodeImage = Image.getInstance(bytes);
			barcodeImage.setAbsolutePosition(340,710);
			createAddress(cb, 370, 790, barcodeNumber, 20);
			barcodeImage.scalePercent(1);
			barcodeImage.scaleAbsolute (150, 70);// 105,40
			barcodeImage.setCompressionLevel(2);

			//createAddress(cb, 370, 790, barcodeNumber, 20);
			doc.add(barcodeImage);

			barcodeImage.setAbsolutePosition(340,510);
			createAddress(cb, 370, 590, barcodeNumber, 20);
			barcodeImage.scalePercent(1);
			barcodeImage.scaleAbsolute (150, 70);// 105,40
			barcodeImage.setCompressionLevel(2);
			doc.add(barcodeImage);
			barcodeImage.setAbsolutePosition(340,310);
			createAddress(cb, 370, 390, barcodeNumber, 20);
			barcodeImage.scalePercent(1);
			barcodeImage.scaleAbsolute (150, 70);// 105,40
			barcodeImage.setCompressionLevel(2);
			doc.add(barcodeImage);
			barcodeImage.setAbsolutePosition(340,80);

			barcodeImage.scalePercent(1);
			barcodeImage.scaleAbsolute (150, 70);// 105,40
			barcodeImage.setCompressionLevel(2);
			createAddress(cb, 370, 170, barcodeNumber, 20);
			//createAddress(cb, 370, 790, barcodeNumber, 20);
			doc.add(barcodeImage);
			//i++;
			//}
		}
		catch(Exception e)
		{
			Date errDate = new Date();
			System.out.println("Error in generateBarcode :"+errDate.toString()+"\nMessage :\n"+e.getMessage());

		}
	}


	private void initializeFonts()  
	{
		try 
		{
			bfSig = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1257, BaseFont.NOT_EMBEDDED);
			bf = BaseColor.BLACK;
		} 
		catch (DocumentException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private void createAddress(PdfContentByte cb, float x, float y, String text,int fontSize)
	{
		cb.beginText();
		cb.setFontAndSize(bfSig, fontSize);
		cb.setColorFill(bf);
		cb.setTextMatrix(x,y);
		cb.showText(text);
		cb.endText();
	} 

}
