package com.newlecture.web.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.vo.Notice;
import com.newlecture.web.vo.NoticeFile;

@Controller
@RequestMapping("/customer/*")
public class CustomerController {
	
	private NoticeDao ND;
	private NoticeFileDao noticeFileDao;

	@Autowired
	public void setNoticeFileDao(NoticeFileDao noticeFileDao) {
		this.noticeFileDao = noticeFileDao;
	}

	@Autowired	
	public void setND(NoticeDao nD) {
		this.ND = nD;
	}

	@RequestMapping("notice")
	public String notice(Model model){
		List<Notice> list = ND.getNotices();
		
		//mv.setViewName("/WEB-INF/view/customer/notice.jsp");//=1
		model.addAttribute("list",list);
		
		/*return "/WEB-INF/view/customer/notice.jsp";*/
		return "customer.notice";
		
	}
	
	@RequestMapping("noticeDetail")
	public String noticeDetail(String c,Model model){
		//NoticeDao ND = new MyBatisNoticeDao();
		Notice n = ND.getNotice(c);
		
		
		model.addAttribute("n",n);
	
		NoticeFile noticeFile = noticeFileDao.getNoticeFile(c);
		model.addAttribute("nf", noticeFile);
		
		return "customer.noticeDetail";
		
		
	}
	
	@RequestMapping(value="noticeReg",method=RequestMethod.GET)
	public String noticeReg(){
		return "customer.noticeReg"; //forward
		
	}
	
	@RequestMapping(value="noticeReg",method=RequestMethod.POST)
	public String noticeReg(Notice n,Principal principal, MultipartFile file,
			HttpServletRequest request,SecurityContext context) throws IOException{ // reDirect
		
		if(request.isUserInRole("ROLE_ADMIN")){
			
		}
		context.getAuthentication().getAuthorities();
		context.getAuthentication().isAuthenticated();//조건문 인증된 정보가있는지
		
		n.setWriter(principal.getName());
		ND.addNotice(n);
		String lastCode=ND.getLastCode();
		
		//Part part=request.getPart("file");
		ServletContext application=request.getServletContext();
		
		String url="/resource/customer/upload";		
		String path=application.getRealPath(url);
		String temp=file.getOriginalFilename();//part.getSubmittedFileName();
		String fname= temp.substring(temp.lastIndexOf("\\")+1);
		String fpath=path+"\\"+fname;
		
		if(!file.isEmpty()){
		
		InputStream ins= file.getInputStream(); //part.getInputStream();
		OutputStream outs=new FileOutputStream(fpath);
		
		byte[] 대야=new byte[1024];
		int len=0;
		
		while((len=ins.read(대야,0,1024))>=0)
			
		outs.write(대야,0,len);		
		outs.flush();
		outs.close();
		ins.close();
		}
			
		if(!file.isEmpty()){
		NoticeFile noticeFile=new NoticeFile();
		noticeFile.setNoticeCode(lastCode);
		noticeFile.setName(fname);
		noticeFileDao.addNoticeFile(noticeFile);
		}
		
		
		return "redirect:notice";
	}
	

}
