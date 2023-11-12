package com.happytrip.petcargo.service.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Random;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.Barcode128;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Rectangle;


public class BarCode128 {

	public static void main(String[] args) throws FileNotFoundException,
			DocumentException {
		long x = generateBarcodeNum();
		generateBarcode(x,"Booking Id:67\n User Id:12\n Payment Id:1202\n Pet Name: Ramu");
		
	}

	public static void generateBarcode(long x ,String deatils) throws DocumentException,
			FileNotFoundException {
		Document document = new Document(new Rectangle(PageSize.A4));
		PdfWriter writer = PdfWriter.getInstance(document,
				new FileOutputStream("D:/HappyTrip_PetInfo.pdf"));

		document.addCreationDate();
		document.open();
		document.add(new Paragraph("                                                        Ticket for the pet \n\n\n\n"));
		document.add(new Paragraph(deatils));
		document.add(new Paragraph("\n\n\nships a wide variety of animals, from cats and dogs to hatching eggs, insects and tropical fish. You can be sure that your pet will travel safely and comfortably to its destination."));
		document.add(new Paragraph("\n\n\n\nHappyTrip.com"));
		Barcode128 code128 = new Barcode128();
		code128.setGenerateChecksum(true);
		code128.setCode(x + "");

		document.add(code128.createImageWithBarcode(writer.getDirectContent(),
				null, null));
		document.add(new Paragraph("                                                                                            KIRAN KUMAR MAHARANA \n"));
		document.add(new Paragraph("                                                                                                 Authorised By \n\n\n\n"));
		document.close();

		System.out.println("Document Generated...!!!!!!");
	}

	public static long generateBarcodeNum() {
		Random r = new Random();
		long x = r.nextInt(1000000000);
		return x;
	}
}
