package org.gfbio.idmg.dmpt;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.gfbio.idmg.dto.DMPTInput;
import org.gfbio.idmg.dto.GFunding;
import org.gfbio.idmg.util.PDFUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;

public class DownloadFile extends HttpServlet {

	private static final long serialVersionUID = 2545474165363400648L;

	private static Log _log = LogFactoryUtil.getLog(DownloadFile.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String fName = request.getParameter("fileName"); // getting file name from request parameter
		if (fName == null || fName.isEmpty()) {
			fName = "data_management_plan.pdf";
		}

		response.setContentType("application/pdf");
		response.setHeader("Cache-Control", "max-age=3600, must-revalidate");
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + fName + "\"");

		BufferedOutputStream output = null;
		ByteArrayOutputStream byteStream = null;
		PDDocument pdf = null;
		
		DMPTInput input = (DMPTInput) request.getSession(true).getAttribute("dmptInput");
		String themePath = (String) request.getSession(true).getAttribute("themePath");
		
		if (input != null) {
			_log.info(input.toString());
		} else {
			// Can be removed after development phase
			input = new DMPTInput();
			input.setProjectName("Test Project");
			input.setCategory("Category2");
			input.setReproducible("snapshot");
			List<String> types = new ArrayList<>();
			types.add("Field Work");
			types.add("Observable");
			input.setProjectTypes(types);
			List<String> inv = new ArrayList<>();
			inv.add("Paul");
			inv.add("Johann");
			input.setInvestigators(inv);
			input.setProjectAbstract("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.");
			input.setResponsibleName("Herbert Schwachkoviak");
			input.setPhoneNumber("0800 666666");
			input.setEmail("h.sch@web.de");
			input.setFunding(new GFunding(1, "Fndingtst", "TestLabFund", "2340"));
			
		}
		
		if (themePath == null || themePath.isEmpty()) {
			themePath = "http://localhost:8080/GFBio-2.0-bootstrap3-theme/images";
		}
		
		try {
			pdf = PDFUtil.createPDF(fName, input, themePath);
			
			byteStream = new ByteArrayOutputStream();
			pdf.save(byteStream);
			
			output = new BufferedOutputStream(response.getOutputStream());
			IOUtils.write(byteStream.toByteArray(), output);
		} catch (Exception e) {
			_log.error("Error while creating or streaming PDF document!");
			e.printStackTrace();

		} finally {
			if (output != null)	output.close();
			if (byteStream != null) byteStream.close();
			if (pdf != null) pdf.close();
		}
	}
	
}
