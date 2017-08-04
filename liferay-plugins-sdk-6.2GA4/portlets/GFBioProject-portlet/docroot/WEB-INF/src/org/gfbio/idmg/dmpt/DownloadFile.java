package org.gfbio.idmg.dmpt;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.portlet.PortletSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.gfbio.idmg.dto.DMPTInput;
import org.gfbio.idmg.util.PDFUtil;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;

public class DownloadFile extends HttpServlet {

	private static final long serialVersionUID = 2545474165363400648L;

	private static Log _log = LogFactoryUtil.getLog(DownloadFile.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String fName = request.getParameter("fileName"); // getting file name from request parameter
		_log.info("fileName from request Object" + fName);

		response.setContentType("application/pdf");
		response.setHeader("Cache-Control", "max-age=3600, must-revalidate");
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + fName + "\"");

		BufferedOutputStream output = null;
		ByteArrayOutputStream byteStream = null;
		PDDocument pdf = null;
		
		//String jsonString = (String) request.getSession(true).getAttribute("dmptInput");
		//_log.info(jsonString);
		DMPTInput input = (DMPTInput) request.getSession(true).getAttribute("dmptInput");
		
//		try {
//			Gson gson = new Gson();
//			input = gson.fromJson(jsonString, DMPTInput.class);
//		    _log.info(input.toString());
//		} catch (JsonSyntaxException e) {
//			_log.error("Error while parsing jsonString to POJO", e);
//		}
		
		_log.info(input.toString());
		
		try {
			pdf = PDFUtil.createPDF(fName, input);
			
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
