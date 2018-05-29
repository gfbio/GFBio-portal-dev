package org.gfbio.idmg.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.gfbio.idmg.dto.DMPTInput;
import org.gfbio.idmg.jiraclient.model.AttachmentInput;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class TXTUtil {
	
	private static Log _log = LogFactoryUtil.getLog(TXTUtil.class);
	private static final String EXTENSION = ".txt";
	
	public static AttachmentInput getTXTAttachmentFromDMP (DMPTInput input) {
		InputStream is = null;
		String filename = input.getProjectName().trim() + EXTENSION;
		
		StringBuilder result = new StringBuilder();
		// 1 General Information
		result.append("What's the official name of your research project?\n");
		result.append(input.getProjectName() + "\n\n");
		
		result.append("Please select a category:\n");
		appendString(input.getCategory(), result);
		result.append("\n");
		
		result.append("Is your research data reproducible?\n");
		appendStringList(input.getReproducible(), result);
		appendString(input.getReproducibleText(), result);
		result.append("\n");
		
		result.append("Please specify your project type.\n");
		appendStringList(input.getProjectTypes(), result);
		result.append("\n");
		
		result.append("Provide your project abstract or describe your work and the data involved.\n");
		appendString(input.getProjectAbstract(), result);
		result.append("\n");
		
		result.append("Who are the principal investigators?\n");
		appendStringList(input.getInvestigators(), result);
		result.append("\n");
		
		result.append("Who is the point of contact for the project data?\n");
		String contact = input.getResponsibleName().concat(", " + input.getPhoneNumber() + ", " + input.getEmail()).replaceAll(", ,", ",");
		result.append(contact + "\n\n");
		
		result.append("For which funding are you applying?\n");
		appendString(input.getFunding().getName(), result);
		appendString(input.getFundingLink(), result);
		result.append("\n");
		
		result.append("If you are part of a coordinated programme (Koordinierte Programme, Verbundprojekte), is there any specific coordination, guideline or policy for data management?\n");
		appendString(input.getCoordinatedProgramme(), result);
		result.append("\n");
		
		result.append("Are you part of a research unit (Forschergruppe)?\n");
		appendString(yesOrNo(new Boolean(input.isResearchUnit())), result);
		result.append("\n");
		
		result.append("Please estimate the total volume of your research proposal?\n");
		appendString(input.getResearchProposal(), result);
		result.append("\n");
		
		result.append("Which policies or guideliness for research data management will you follow?\n");
		appendStringList(input.getAllPolicies(), result);
		appendString(input.getPolicyLink(), result);
		result.append("\n");
		
		// 2 Data Collection
		result.append("Do you want to submit physical objects along with your data?\n");
		appendString(yesOrNo(input.getPhysical()), result);
		result.append("\n");
		
		result.append("Is your object dead or alive?\n");
		appendString(yesOrNo(input.getAlive()), result);
		result.append("\n");
		
		result.append("Is your object taxon-based?\n");
		appendString(yesOrNo(input.getTaxon()), result);
		result.append("\n");
		
		result.append("Do you have mainly sequence data?\n");
		appendString(yesOrNo(input.getSequenced()), result);
		result.append("\n");
		
		result.append("What type of data will you create?\n");
		appendStringList(input.getDatatypes(), result);
		result.append("\n");
		
		result.append("What data formats will you create?\n");
		appendString(input.getCreateFormats(), result);
		result.append("\n");
		
		result.append("Please estimate the data volume you will create.\n");
		appendString(input.getDataVolume(), result);
		result.append("\n");
		
		result.append("Please estimate the number of data sets (files) you will create.\n");
		appendString(input.getDataSets(), result);
		result.append("\n");
		
		result.append("What standards, methodologies or tools will you use to collect, manage and process your data?\n");
		appendString(input.getMethodologies(), result);
		result.append("\n");
		
		// 3 Metadaata
		result.append("Which metadata schema does your data support (if any)?\n");
		appendStringList(input.getAllMetadata(), result);
		appendString(input.getMetadataDescription(), result);
		result.append("\n");
		
		// 4 Ethics
		result.append("Which legal requirements will your research data meet?\n");
		appendStringList(input.getAllRequirements(), result);
		result.append("\n");
		
		result.append("How will your data be licensed for reuse?\n");
		appendString(input.getLicense().getName(), result);
		result.append("\n");
		
		result.append("Do you need access restriction for your data?\n");
		appendString(yesOrNo(input.getAccessRestriction()), result);
		result.append("\n");
		
		result.append("For how long do you need exclusive use of the data?\n");
		appendString(input.getAccessDuration(), result);
		result.append("\n");
		
		result.append("Why do you need exclusive use of the data?\n");
		appendString(input.getAccessReason(), result);
		result.append("\n");

		// 5 Preservation and Sharing
		result.append("How is your data backed up during project runtime? Who is responsible for data backup?\n");
		appendString(input.getBackup(), result);
		result.append("\n");
		
		result.append("Where will your data be archived?\n");
		appendStringList(input.getDataArchives(), result);
		result.append("\n");
		
		result.append("Do you need a persistent idenfifier (e.g. ePIC PID / DOI) for your data?\n");
		appendString(input.getPid(), result);
		result.append("\n");
		
		is = new ByteArrayInputStream( result.toString().getBytes() );
		
		return new AttachmentInput(filename, is);
	}
	
	private static void appendString(String s, StringBuilder result) {
		if (!isNullOrEmpty(s)) {
			result.append(s + "\n");
		} else {
			printEmptyAnswer(result);
		}
	}
	
	private static void appendStringList(List<String> list, StringBuilder result) {
		if (!isNullOrEmpty(list)) {
			result.append(createCommaSeperatedString(list) + "\n");
		} else {
			printEmptyAnswer(result);
		}
	}
	
	private static void printEmptyAnswer(StringBuilder result) {
		result.append("-/-\n");
	}
	
	private static String createCommaSeperatedString(List<String> list) {
		String result = "";
		if(!isNullOrEmpty(list)) {
			for (String s : list) {
				result = result.concat(s + ", ");
			}
		}
		return result.replaceAll(", $", "");
	}
	
	private static String yesOrNo(Boolean b) {
		if (b != null) {
			if (b.booleanValue()) {
				return "Yes";
			} else {
				return "No";
			}
		} 
		return null;
	}
	
	private static boolean isNullOrEmpty(final String value) {
		return value == null || value.isEmpty();
	}
	
	private static boolean isNullOrEmpty(final List<String> values) {
		return values == null || values.isEmpty();
	}
}
