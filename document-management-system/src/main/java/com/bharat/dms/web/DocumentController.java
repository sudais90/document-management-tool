package com.bharat.dms.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bharat.dms.domain.Metadata;
import com.bharat.dms.service.DocumentService;

@Controller
public class DocumentController {

	@Autowired
	private DocumentService documentService;

	public void setDocumentService(DocumentService documentService) {
		this.documentService = documentService;
	}

	/**
	 * prepares document post form 
	 * @return
	 */
	@RequestMapping(value = "/docs", method = RequestMethod.GET)
	public ModelAndView listDocuments() {
		String msg = "Recent Documents";

		List<Metadata> lst = documentService.getRecentDocuments();

		ModelAndView mav = new ModelAndView();
		mav.setViewName("listDocs");
		mav.addObject("msg", msg);
		mav.addObject("lst", lst);

		return mav;
	}

	/**
	 * download document.
	 * 
	 * @param docId
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/download/{id}", method = RequestMethod.GET)
	public void downloadDocumentById(@PathVariable(value = "id") Long docId,
			HttpServletRequest request, HttpServletResponse response ) {

		Metadata meta = documentService.getDocumentById(docId);

		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition",
		"attachment; filename=\""+ meta.getDocumentFileName());
		
		try {
			ServletOutputStream out = response.getOutputStream();
			out.write(meta.getDocument().getDocument());
			out.flush();
			out.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}