package org.gfbio.idmg.util;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.gfbio.idmg.dto.DMPTInput;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class PDFUtil {

	private static Log _log = LogFactoryUtil.getLog(ContentUtil.class);

	public static PDDocument createPDF(String path, DMPTInput userInput, String themePath) throws IOException {

		// Creating PDF document object
		PDDocument document = new PDDocument();

		// Set metadata for document
		setDocumentInformation(document, userInput);
		
		PDPage page = new PDPage();
		setDocumentContent(document, page, userInput, themePath);
		document.addPage(page);

		//PDPage page2 = new PDPage();
		// Add content to page2
		//document.addPage(page2);

		

		return document;
	}

	private static void setDocumentInformation(PDDocument pdf, DMPTInput userInput) {

		// Creating the PDDocumentInformation object
		PDDocumentInformation pdd = pdf.getDocumentInformation();
		// Setting the author of the document
		pdd.setAuthor("GFBio");
		// Setting the title of the document
		pdd.setTitle("DMP for" + userInput.getProjectName());
		// Setting the creator of the document
		pdd.setCreator("GFBio DMP-Tool");
		// Setting the subject of the document
		pdd.setSubject("GFBio Data Management Plan");
	}

	private static void setDocumentContent(PDDocument pdf, PDPage page, DMPTInput userInput, String themePath) throws IOException {

		PDPageContentStream content = new PDPageContentStream(pdf, page);
		_log.info(themePath + "/gfbiologo-transparent_122_60.png");
		
		// Get GFBio Logo and print it to pdf document
		try {
			URL url = new URL(themePath + "/gfbiologo-transparent_122_60.png");
			BufferedImage awtImage = ImageIO.read(url);
			if (awtImage != null) { 
				PDImageXObject  pdImage = LosslessFactory.createFromImage(pdf, awtImage);
				content.drawImage(pdImage, 450, 710, 122, 60);
			}
		} catch (IOException e) {
			_log.error("GFBio Logo couldn't be found!", e);
		}
		// Begin the Content stream
		content.beginText();

		// Setting line heigt for newLine method
		content.setLeading(15.5f);
		
		// Header
		printHeader(content);
		
		// Attributes for line breaking method printLines
		PDRectangle mediabox = page.getMediaBox();
	    float margin = 50;
	    float width = mediabox.getWidth() - 2*margin;

	    // Setting the font to the Content stream
	 	content.setFont(PDType1Font.HELVETICA_BOLD, 24);
	 	content.setNonStrokingColor(51, 90, 163);
	 	// Setting the position for the line
	 	content.newLineAtOffset(10, -70);
		// Start of Page Content - Adding text in the form of string
		content.showText("Data Management Plan");
		content.newLine();
		content.newLine();
		
		printHeading("General Project Information", content);
		printTitle("Project: ", content);
		
		printLine(userInput.getProjectName(), content);
		
		printTitle("Research Field: ", content);
		if (!isNullOrEmpty(userInput.getCategory())) {
			printLine(userInput.getCategory(), content);
		}
		
		
		String characTitle = "Project Characteristics: ";
		printTitle(characTitle, content);
		
		String characteristics = "";
		if (!isNullOrEmpty(userInput.getReproducible())) {
			if (!characteristics.isEmpty()) {
				characteristics = characteristics.concat(", ");
			}
			for (String s : userInput.getReproducible()) {
				characteristics = characteristics.concat(s + ", ");
			}
		}
		if (!isNullOrEmpty(userInput.getProjectTypes())) {
			if (!characteristics.isEmpty()) {
				characteristics = characteristics.concat(", ");
			}
			for (String s : userInput.getProjectTypes()) {
				characteristics = characteristics.concat(s + ", ");
			}
		}
		characteristics = characteristics.replaceAll(", $", "");
		printLines(characteristics, characTitle, width, content);
		
		printTitle("Principal Investigator/s: ", content);
		if (!isNullOrEmpty(userInput.getInvestigators())) {
			toggleTextColorAndSize(content, false);
			String investigators = "";
			for (String s : userInput.getInvestigators()) {
				investigators = investigators.concat(s + ", ");
			}
			investigators = investigators.replaceAll(", $", "");
			printLine(investigators, content);
		}
		
		printTitle("Project Data Contact: ", content);
		String contact = userInput.getResponsibleName().concat(", " + userInput.getPhoneNumber() + ", " + userInput.getEmail());
		printLine(contact, content);
		
		toggleTextColorAndSize(content, true);
		String abstractTitle = "Project Abstract: ";
		content.showText(abstractTitle);
		if (!isNullOrEmpty(userInput.getProjectAbstract())) {
			printLines(userInput.getProjectAbstract(), abstractTitle, width, content);
		}
		
		printTitle("Funding Application: ", content);
		if (userInput.getFunding() != null && !isNullOrEmpty(userInput.getFunding().getName())) {
			printLine(userInput.getFunding().getName(), content);
		}
		
		printTitle("Relevant Policies and Guidelines: ", content);
		
		printHeading("Data Collection", content);
 		
		printTitle("Data Formats: ", content);
		content.newLine();
		
		printTitle("Estimated Data Volume: ", content);
		content.newLine();
		
		printTitle("Standards, Methodologies and Tools for Data Collection: ", content);
		content.newLine();
		
		
		printHeading("Documentation and Metadata", content);
		content.newLine();
		printHeading("Ethics and Legal Compliance", content);
		content.newLine();
		printHeading("Preservation and Sharing", content);
		content.newLine();
		printHeading("GFBio recommends", content);
		String recommends = "GFBio provides individual data management support and recommends contacting us for your personal data management strategy and DMP support. "
				+ "We give advice regarding storage, security, quality assurance and backup and help you optimizing the findability, accessibility, interoperability and re-usability of your research data. "
				+ "We highly recommend using common standards for data and metadata formats. You can find an overview of GFBio services on www.gfbio.org.";
		printLines(recommends, "", width, 11, Color.BLACK, PDType1Font.HELVETICA, content);
		
		
		// Ending the content stream
		content.endText();
		content.close();
		
		//Set contentStream new for footer
		content = new PDPageContentStream(pdf, page, PDPageContentStream.AppendMode.APPEND, true, true);
		content.beginText();
		//Print Footer
		printFooter(content);
		content.endText();
		// Closing the content stream
		content.close();
	}

	private static void toggleTextColorAndSize(PDPageContentStream content, boolean oblique) throws IOException {
		if (!oblique) {
			content.setNonStrokingColor(Color.LIGHT_GRAY);
			content.setFont(PDType1Font.HELVETICA_OBLIQUE, 11);
		} else {
			content.setNonStrokingColor(51, 90, 163);
			content.setFont(PDType1Font.HELVETICA_BOLD, 11);
		}
	}
	
	private static void printHeading(String heading, PDPageContentStream content) throws IOException {
		content.setFont(PDType1Font.HELVETICA_BOLD, 12);
		content.showText(heading);
		content.newLine();
	}
	
	private static void printTitle(String title, PDPageContentStream content) throws IOException {
		toggleTextColorAndSize(content, true);
		content.showText(title);
	}
	
	private static void printHeader(PDPageContentStream content) throws IOException {
		content.newLineAtOffset(50, 750);
		content.setNonStrokingColor(51, 90, 163);
		content.setFont(PDType1Font.HELVETICA_BOLD, 8);
		
		String header = "GERMAN FEDERATION FOR BIOLOGICAL DATA";
		String text = "Research Data Management";
		content.showText(header);
		content.newLine();
		content.showText("     " + text);
	}
	
	private static void printFooter(PDPageContentStream content) throws IOException {
		content.newLineAtOffset(70, 25);
		content.setNonStrokingColor(Color.LIGHT_GRAY);
		content.setFont(PDType1Font.HELVETICA, 8);
		
		String footer = "This data management plan was computer-produced by GFBio DMP-Tool. For revision and support please contact info@gfbio.org.";
		content.showText(footer);
	}
	
	private static void printLine(String line, PDPageContentStream content) throws IOException {
		toggleTextColorAndSize(content, false);
		content.showText(line);
		content.newLine();
	}
	
	private static void printLines(String text, String title, float width, PDPageContentStream content) throws IOException {
		PDFont pdfFont = PDType1Font.HELVETICA_OBLIQUE;
		Color color = Color.LIGHT_GRAY;
	    float fontSize = 11;
	    printLines(text, title, width, fontSize, color, pdfFont, content);
	}
	
	private static void printLines(String text, String title, float width, float fontSize, Color color, PDFont pdfFont, PDPageContentStream content) throws IOException {
	    List<String> lines = new ArrayList<String>();
	    int lastSpace = -1;
	    
	    float titleSize = fontSize * pdfFont.getStringWidth(title) / 1000;
	    width = width - titleSize;
	    boolean increasedWidth = false;
	    
	    while (text.length() > 0)
	    {
	        int spaceIndex = text.indexOf(' ', lastSpace + 1);
	        if (spaceIndex < 0)
	            spaceIndex = text.length();
	        String subString = text.substring(0, spaceIndex);
	        float size = fontSize * pdfFont.getStringWidth(subString) / 1000;
	        //System.out.printf("'%s' - %f of %f\n", subString, size, width);
	        if (size > width)
	        {
	            if (lastSpace < 0)
	                lastSpace = spaceIndex;
	            subString = text.substring(0, lastSpace);
	            lines.add(subString);
	            text = text.substring(lastSpace).trim();
	            //System.out.printf("'%s' is line\n", subString);
	            lastSpace = -1;
	        }
	        else if (spaceIndex == text.length())
	        {
	            lines.add(text);
	            //System.out.printf("'%s' is line\n", text);
	            text = "";
	        }
	        else
	        {
	            lastSpace = spaceIndex;
	        }
	        
	        if (titleSize > 0 && lines.size() == 1 && !increasedWidth) {
	        	width = width + titleSize;
	        	increasedWidth = true;
	        }
	    }
	    
	    content.setNonStrokingColor(color);
		content.setFont(pdfFont, fontSize);

		for (String line : lines) {
			content.showText(line);
			content.newLine();
		}
	}
	
	private static boolean isNullOrEmpty(final String value) {
		return value == null || value.isEmpty();
	}
	
	private static boolean isNullOrEmpty(final List<String> values) {
		return values == null || values.isEmpty();
	}
}
