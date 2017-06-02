package org.gfbio.idmg.util;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class PDFUtil {

	private static Log _log = LogFactoryUtil.getLog(ContentUtil.class);

	public static PDDocument createPDF(String path) throws IOException {

		// Creating PDF document object
		PDDocument document = new PDDocument();
		// PDPageContentStream contentStream;

		PDPage page = new PDPage();
		setDocumentContent(document, page);
		document.addPage(page);

		PDPage page2 = new PDPage();
		// Add content to page2
		document.addPage(page2);

		PDPage page3 = new PDPage();
		// Add content to page3
		document.addPage(page3);

		setDocumentInformation(document);

		// contentStream = new PDPageContentStream(document, page);
		//
		// contentStream.setFont(PDType1Font.COURIER, 10);
		//
		// contentStream.beginText();
		// contentStream.
		// contentStream.drawString("Hello World Hello World Hello World Hello
		// World Hello World");
		// contentStream.endText();
		// contentStream.close();

		return document;
	}

	private static void setDocumentInformation(PDDocument pdf) {

		// Creating the PDDocumentInformation object
		PDDocumentInformation pdd = pdf.getDocumentInformation();

		// Setting the author of the document
		pdd.setAuthor("GFBio");

		// Setting the title of the document
		pdd.setTitle("DMP for <<project title>>");

		// Setting the creator of the document
		pdd.setCreator("GFBio Portal");

		// Setting the subject of the document
		pdd.setSubject("GFBio Data Management Plan");

	}

	private static void setDocumentContent(PDDocument pdf, PDPage page) throws IOException {

		PDPageContentStream contentStream = new PDPageContentStream(pdf, page);
		// Begin the Content stream
		contentStream.beginText();

		// Setting the font to the Content stream
		contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);

		// Setting the position for the line
		contentStream.newLineAtOffset(25, 500);

		String text = "This is the sample document and we are adding content to it.";

		// Adding text in the form of string
		contentStream.showText(text);

		// Ending the content stream
		contentStream.endText();

		// Closing the content stream
		contentStream.close();
	}
}
