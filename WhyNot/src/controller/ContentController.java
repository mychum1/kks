package controller;

import java.io.IOException;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.Socket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import onlinecontent.model.OnlineContentDAO;
import onlinecontent.model.OnlineContentDAOImpl;
import onlinecontent.model.OnlineContentDBBean;
import onlinecurriculum.model.OnlineCurriculumDAO;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@Controller
public class ContentController {

	private OnlineContentDAO onlineContentDAO;
	private OnlineCurriculumDAO onlineCurriculumDAO;
  
	
	public void setOnlineContentDAO(OnlineContentDAO onlineContentDAO) {
		this.onlineContentDAO = onlineContentDAO;
	}

	public void setOnlineCurriculumDAO(OnlineCurriculumDAO onlineCurriculumDAO) {
		this.onlineCurriculumDAO = onlineCurriculumDAO;
	}
	
	// --------------  컨텐츠  -----------------------------------
	
	@RequestMapping(value = "/list.content")
	public ModelAndView listContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_listContent() 실행");
		return new ModelAndView("content/contentList.jsp");

	}

	@RequestMapping(value = "/cont_insert.content") // 인강등록Form(학교)
	public ModelAndView insertFormContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_insertFormContent() 실행");
		return new ModelAndView("content/online/cont_insertForm.jsp");

	}
	
	@RequestMapping(value = "/cont_insertPro.content") // 인강등록Pro(학교)
	public ModelAndView insertProContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_insertProContent() 실행");
		return new ModelAndView("content/contentList.jsp"); //나중에 마이페이지로???

	}
	
	@RequestMapping(value = "/insert.content")
	public ModelAndView insertVideo(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
	boolean isMultipart = ServletFileUpload.isMultipartContent(arg0);
		
		if( isMultipart ) {
			System.out.println("isMultipart if문 진입");
			OnlineContentDBBean dto = new OnlineContentDBBean();
			//E:\\java\\Main\\Temp
			//C:\Users\Public\Downloads
		    File temporaryDir = new File("C:\\Users\\Public\\Downloads\\");
		    DiskFileItemFactory factory = new DiskFileItemFactory();
		    System.out.println("factory 생성성공");
		    factory.setSizeThreshold(1 * 1024 * 1024);
		    factory.setRepository(temporaryDir);
		    ServletFileUpload upload = new ServletFileUpload(factory);
		    System.out.println("ServletFileUpload 생성성공");
		    upload.setSizeMax(2 * 1024 * 1024 * 1024);            
		    System.out.println("upload.getFileSizeMax()"+upload.getFileSizeMax());
		    System.out.println("upload.getSizeMax()"+upload.getSizeMax());
		    List items = null;
		    try {
		        items = upload.parseRequest(arg0);
		        System.out.println("items받아오기 성공");
		    } catch (FileUploadException fe){
		        System.out.println(fe);
		    }
		    if(items!=null){
		    	System.out.println("items!=null 진입성공");
		        Iterator it = items.iterator();
		        while (it.hasNext()) {
		            FileItem fileItem = (FileItem) it.next(); 
		            

		                //파일 업로드 처리
		                try{
		             
		                	String fileName = fileItem.getName();
		                	long fileSize = fileItem.getSize()/1024 + (fileItem.getSize()%1024>0?1:0);
		                    File uploadedFile = new File(fileName);
		                    System.out.println("filename : "+fileName);
		                    System.out.println("filesize : "+fileSize);
		                    Socket client = new Socket("localhost", 12345);
		                    System.out.println("서버접속성공!!");
		                    InputStream is = fileItem.getInputStream();
		                    OutputStream os = client.getOutputStream();
		                    DataOutputStream dout = new DataOutputStream(os);
		                    
	                    	dout.writeLong(fileSize);
	                    	dout.writeUTF(fileName);
	                    	System.out.println("경로 : "+fileName);
	                    	byte[] buffer = new byte[1024];
	                    	
	                    	int len;
	                    	System.out.println("파일전송중..");
	                    	for(;fileSize>0;fileSize--) {
		                    	len = is.read(buffer);
		                    	os.write(buffer, 0, len);
	                    	}
	                    	System.out.println("파일전송완료!!");
	                    	//return new ModelAndView("../index.jsp");
		                } catch(Exception e){                       
		                    System.out.println("e : "+e);
		                }
		            
		        }
		    }
		    //new OnlineContentDAOImpl.insertBoard(dto);
		}
		//return new ModelAndView("redirect:board_list.do");
		
		return new ModelAndView("content/online/cont_detailForm.jsp");
	}
//cont_detail.content
	@RequestMapping(value = "/cont_detail.content") // 인강 상세보기
	public ModelAndView detailContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_detailContent() 실행");
		//여기
		
	
		
		return new ModelAndView("content/online/cont_detailForm.jsp");

	}
	
	// --------------  커리큘럼 -----------------------------------
	
	@RequestMapping(value = "/curri_insert.content") // 커리큘럼 등록
	public ModelAndView insertFormCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_insertFormCurri() 실행");
		return new ModelAndView("content/online/cont_insertForm.jsp");

	}
	
	@RequestMapping(value = "/curri_insertPro.content") // 커리큘럼 등록Pro
	public ModelAndView insertProCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_insertProCurri() 실행");
		return new ModelAndView("content/contentList.jsp"); //나중에 자신이 올린 강좌(학교) 상세페이지로 수정

	}

	@RequestMapping(value = "/curri_detail.content") // 강의실Form
	public ModelAndView detailCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_detailCurri() 실행");
		return new ModelAndView("content/online/curr_detailForm.jsp");

	}
}
