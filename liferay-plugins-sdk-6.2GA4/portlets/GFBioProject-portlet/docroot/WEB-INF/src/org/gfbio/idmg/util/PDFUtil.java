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

	private static Log _log = LogFactoryUtil.getLog(PDFUtil.class);
	
	private PDDocument document;
	private PDPage page;
	private PDPageContentStream content;
	private PDType1Font boldFont = PDType1Font.HELVETICA_BOLD;
	
	private float yCoordinate;
	private float leading = 15.5f;
	private float margin = 50;
	// Fontsizes
    private float docTitleSize = boldFont.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * 24;
	
	private DMPTInput userInput;
	private String themePath;
	
	public PDFUtil(DMPTInput userInput, String themePath) throws IOException {
		this.userInput = userInput;
		this.themePath = themePath;
		
		document = new PDDocument();
		page = createNewPage();
		
	}

	public PDDocument createPDF() throws IOException {

		// Set metadata for document
		setDocumentInformation();
		
		// Set content and create pages dynamically
		setDocumentContent();

		return document;
	}

	private void setDocumentInformation() {

		// Creating the PDDocumentInformation object
		PDDocumentInformation pdd = document.getDocumentInformation();
		// Setting the author of the document
		pdd.setAuthor("GFBio");
		// Setting the title of the document
		pdd.setTitle("DMP for" + userInput.getProjectName());
		// Setting the creator of the document
		pdd.setCreator("GFBio DMP-Tool");
		// Setting the subject of the document
		pdd.setSubject("GFBio Data Management Plan");
	}
	
	private void setDocumentContent() throws IOException {
		
	
		// Attributes for line breaking method printLines
		PDRectangle mediabox = page.getMediaBox();
	    float width = mediabox.getWidth() - 2*margin;

	    // Setting the font to the Content stream
	 	content.setFont(boldFont, 24);
	 	content.setNonStrokingColor(51, 90, 163);
	 	
		// Start of Page Content - Adding Document title
		content.showText("Data Management Plan");
		content.newLine();
		yCoordinate -= docTitleSize;
		
		// 1 - General Information
		printHeading("General Project Information");
		
		printTitle("Project Name: ");
		printLine(userInput.getProjectName());
		
		printTitle("Research Field: ");
		printSingleLineAnswer(userInput.getCategory());
		
		String title = "Project Characteristics: ";
		printTitle(title);
		
		String characteristics = createCommaSeperatedString(userInput.getReproducible()) + createCommaSeperatedString(userInput.getProjectTypes());
		characteristics = characteristics.replaceAll(", $", "");
		printLines(characteristics, title, width);

		// Additional infos
		if (!isNullOrEmpty(userInput.getReproducibleText())) {
			printLines(userInput.getReproducibleText(), "", width);
		}
		
		title = "Project Abstract: ";
		printTitle(title);
		printMultiLineAnswer(userInput.getProjectAbstract(), title, width);
		
		
		printTitle("Project Data Contact: ");
		String contact = userInput.getResponsibleName().concat(", " + userInput.getPhoneNumber() + ", " + userInput.getEmail()).replaceAll(", ,", ",");
		printLine(contact);
		
		title = "Principal Investigator/s: ";
		printTitle(title);
		printMultiLineAnswer(userInput.getInvestigators(), title, width);
		
		printTitle("Funding Application: ");
		printSingleLineAnswer(userInput.getFunding().getName());
		printSingleLineAnswer(userInput.getFundingLink());
		
		title = "Coordinated Programme: ";
		printTitle(title);
		printMultiLineAnswer(userInput.getCoordinatedProgramme(), title, width);

		printTitle("Part of a Research Unit? ");
		printSingleLineAnswer(yesOrNo(new Boolean(userInput.isResearchUnit())));
		
		printTitle("Volume of Research Proposal: ");
		printSingleLineAnswer(userInput.getResearchProposal());
		
		title = "Relevant Policies and Guidelines: ";
		printTitle(title);
		printMultiLineAnswer(userInput.getAllPolicies(), title, width);
		if (!isNullOrEmpty(userInput.getPolicyLink())) {
			printSingleLineAnswer(userInput.getPolicyLink(), false);
		}
		
		// 2 - Data Collection
		printHeading("Data Collection");
 		
		printTitle("Physical Objects: ");
		printSingleLineAnswer(yesOrNo(userInput.getPhysical()));
		
		printTitle("Dead or Alive: ");
		printSingleLineAnswer(yesOrNo(userInput.getAlive()));
		
		printTitle("Taxon-Based: ");
		printSingleLineAnswer(yesOrNo(userInput.getTaxon()));
		
		printTitle("Mainly Sequence Data: ");
		printSingleLineAnswer(yesOrNo(userInput.getSequenced()));
		
		title = "Type of Data: ";
		printTitle(title);
		printMultiLineAnswer(userInput.getDatatypes(), title, width);
		
		title = "Data Formats: ";
		printTitle(title);
		printMultiLineAnswer(userInput.getCreateFormats(), title, width);
		
		printTitle("Estimated Data Volume: ");
		printSingleLineAnswer(userInput.getDataVolume());
		
		printTitle("Number of Data Sets: ");
		printSingleLineAnswer(userInput.getDataSets());
		
		title = "Standards, Methodologies and Tools: ";
		printTitle(title);
		printMultiLineAnswer(userInput.getMethodologies(), title, width);
		
		// 3 - Metadata
		printHeading("Documentation and Metadata");
		
		title = "Supported Metadata Schemas: ";
		printTitle(title);
		printMultiLineAnswer(userInput.getAllMetadata(), title, width);
		
		// Additional infos
		if (!isNullOrEmpty(userInput.getMetadataDescription())) {
			printLines(userInput.getMetadataDescription(), "", width);
		}
		
		// 4 - Ethics 
		printHeading("Ethics and Legal Compliance");
		
		title = "Legal Requirements: ";
		printTitle(title);
		printMultiLineAnswer(userInput.getAllRequirements(), title, width);
		
		printTitle("License: ");
		printSingleLineAnswer(userInput.getLicense().getName());
		
		printTitle("Access Restriction");
		printSingleLineAnswer(yesOrNo(userInput.getAccessRestriction()));

		if (userInput.getAccessRestriction() != null && userInput.getAccessRestriction().booleanValue()) {
			printSingleLineAnswer("How long: " + userInput.getAccessDuration());
			printSingleLineAnswer("Reason: " + userInput.getAccessReason());
		}
		
		// 5 - Preservation and Sharing
		printHeading("Preservation and Sharing");
		
		title = "Data Submission to GFBio: ";
		printTitle(title);
		printMultiLineAnswer(userInput.getDataSubmissions(), title, width);
		
		title = "Data Backup: ";
		printTitle(title);
		printMultiLineAnswer(userInput.getBackup(), title, width);
		
		title = "Data Archiving: ";
		printTitle(title);
		printMultiLineAnswer(userInput.getDataArchives(), title, width);
		
		printTitle("Persistent Identifier: ");
		printSingleLineAnswer(userInput.getPid());
		
		
		// Recommendation
		printHeading("GFBio recommends");
		String recommends = "GFBio provides individual data management support and recommends contacting us for your personal data management strategy and DMP support. "
				+ "We give advice regarding storage, security, quality assurance and backup and help you optimizing the findability, accessibility, interoperability and re-usability of your research data. "
				+ "We highly recommend using common standards for data and metadata formats. You can find an overview of GFBio services on www.gfbio.org.";
		printLines(recommends, "", width, 11, Color.BLACK, PDType1Font.HELVETICA);
		
		// Ending the content stream
		content.endText();
		content.close();
		
		printFooter();
		
	}
	
	private boolean yCoordinateTooLow(float yCoordinate) {
		return yCoordinate <= 50;
	}
	
	private PDPage createNextPage() throws IOException {
		// Ending the content stream
		content.endText();
		content.close();
		printFooter();
		return createNewPage();
	}
	
	private PDPage createNewPage() throws IOException {
		PDPage page = new PDPage();
		document.addPage(page);
		content = new PDPageContentStream(document, page);
		
		// GFBio Logo printing
		printGFBioLogo();
		// Begin the Content stream
		content.beginText();

		// Setting line heigt for newLine method
		content.setLeading(leading);
		
		// Header
		printHeader();
		// Set remaining yCoordinate for determining end of page
		yCoordinate = 731f;
		// Setting the position for the line
	 	content.newLineAtOffset(10, -70);
	 	yCoordinate -= 70f;
		
		return page;
	}
	
	private void printGFBioLogo() {
		// Get GFBio Logo and print it to pdf document
		try {
			URL url = new URL(themePath + "/gfbiologo-transparent_122_60.png");
			BufferedImage awtImage = ImageIO.read(url);
			if (awtImage != null) { 
				PDImageXObject  pdImage = LosslessFactory.createFromImage(document, awtImage);
				content.drawImage(pdImage, 450, 710, 122, 60);
			}
		} catch (IOException e) {
			_log.error("GFBio Logo couldn't be found!", e);
		}
	}
	
	private void toggleTextColorAndType(PDPageContentStream content, boolean oblique) throws IOException {
		if (!oblique) {
			content.setNonStrokingColor(Color.LIGHT_GRAY);
			content.setFont(PDType1Font.HELVETICA_OBLIQUE, 11);
		} else {
			content.setNonStrokingColor(51, 90, 163);
			content.setFont(boldFont, 11);
		}
	}
	
	private void printHeading(String heading) throws IOException {
		//Check First whether yCoordinate is too low after the heading
		yCoordinate -= 2*leading;
		if (yCoordinateTooLow(yCoordinate)) {
			page = createNextPage();
		}
		content.setFont(boldFont, 12);
		content.setNonStrokingColor(51, 90, 163);
		content.newLine();
		content.showText(heading);
		content.newLine();
	}
	
	private void printTitle(String title) throws IOException {
		toggleTextColorAndType(content, true);
		content.showText(title);
	}
	
	private void printSingleLineAnswer(String answer) throws IOException {
		printSingleLineAnswer(answer, true);
	}
	
	private void printSingleLineAnswer(String answer, boolean printNoResult) throws IOException {
		if (!isNullOrEmpty(answer)) {
			printLine(answer);
		} else if(printNoResult) {
			printLine("-/-");
		}
	}
	
	private void printMultiLineAnswer(List<String> answers, String title, float width) throws IOException {
		if (!isNullOrEmpty(answers)) {
			toggleTextColorAndType(content, false);
			String printString = createCommaSeperatedString(answers);
			printString = printString.replaceAll(", $", "");
			printMultiLineAnswer(printString, title, width);
		} else {
			printLine("-/-");
		}
	}
	
	private void printMultiLineAnswer(String answer, String title, float width) throws IOException {
		if (!isNullOrEmpty(answer)) {
			printLines(answer, title, width);
		} else {
			printLine("-/-");
		}
	}
	
	private String createCommaSeperatedString(List<String> list) {
		String result = "";
		if(!isNullOrEmpty(list)) {
			for (String s : list) {
				result = result.concat(s + ", ");
			}
		}
		return result;
	}
	
	private void printHeader() throws IOException {
		content.newLineAtOffset(50, 750);
		content.setNonStrokingColor(51, 90, 163);
		content.setFont(boldFont, 8);
		
		String header = "GERMAN FEDERATION FOR BIOLOGICAL DATA";
		String text = "Research Data Management";
		content.showText(header);
		content.newLine();
		content.showText("     " + text);
	}
	
	private void printFooter() throws IOException {
		//Set contentStream new for footer
		content = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
		content.beginText();
		// Print Footer
		content.newLineAtOffset(70, 25);
		content.setNonStrokingColor(Color.LIGHT_GRAY);
		content.setFont(PDType1Font.HELVETICA, 8);
		
		String footer = "This data management plan was computer-produced by GFBio DMP-Tool. For revision and support please contact info@gfbio.org.";
		content.showText(footer);

		content.endText();
		// Closing the content stream
		content.close();
	}
	
	private void printLine(String line) throws IOException {
		toggleTextColorAndType(content, false);
		content.showText(line);
		content.newLine();
		yCoordinate -= leading;
		if (yCoordinateTooLow(yCoordinate)) {
			page = createNextPage();
		}
	}
	
	private void printLines(String text, String title, float width) throws IOException {
		PDFont pdfFont = PDType1Font.HELVETICA_OBLIQUE;
		Color color = Color.LIGHT_GRAY;
	    float fontSize = 11;
	    printLines(text, title, width, fontSize, color, pdfFont);
	}
	
	private void printLines(String text, String title, float width, float fontSize, Color color, PDFont pdfFont) throws IOException {
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
			yCoordinate -= leading;
			if (yCoordinateTooLow(yCoordinate)) {
				page = createNextPage();
				content.setNonStrokingColor(color);
				content.setFont(pdfFont, fontSize);
			}
		}
	}
	
	private String yesOrNo(Boolean b) {
		if (b != null) {
			if (b.booleanValue()) {
				return "Yes";
			} else {
				return "No";
			}
		} 
		return null;
	}
	
	private boolean isNullOrEmpty(final String value) {
		return value == null || value.isEmpty();
	}
	
	private boolean isNullOrEmpty(final List<String> values) {
		return values == null || values.isEmpty();
	}
}
