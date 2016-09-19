package controller;

import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.VideoAttributes;
import it.sauronsoftware.jave.VideoSize;
import onlinecontent.model.OnlineContentDAO;
import onlinecontent.model.OnlineContentDBBean;
import onlinecurriculum.board.model.OnlineCurriculumBoardDAO;
import onlinecurriculum.model.OnlineCurriculumDAO;

@Controller
public class ContentController {

	private OnlineContentDAO onlineContentDAO=null;
	private OnlineCurriculumDAO onlineCurriculumDAO;
	private OnlineCurriculumBoardDAO onlineCurriculumBoardDAO;
	
	public void setOnlineContentDAO(OnlineContentDAO onlineContentDAO) {
		System.out.println("���������!");
		this.onlineContentDAO = onlineContentDAO;
	}

	public void setOnlineCurriculumDAO(OnlineCurriculumDAO onlineCurriculumDAO) {
		this.onlineCurriculumDAO = onlineCurriculumDAO;
	}
	
	public void setOnlineCurriculumBoardDAO(OnlineCurriculumBoardDAO onlineCurriculumBoardDAO) {
		this.onlineCurriculumBoardDAO = onlineCurriculumBoardDAO;
	}
	
	// --------------  ������  -----------------------------------
	

	@RequestMapping(value = "/insertVideo.content")
	public ModelAndView insertVideo(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		//dto
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(arg0);
		
		if( isMultipart ) {
			System.out.println("isMultipart if�� ����");
			//E:\\java\\Main\\Temp
			//C:\Users\Public\Downloads
		    File temporaryDir = new File("C:\\Users\\Public\\Downloads\\");
		    DiskFileItemFactory factory = new DiskFileItemFactory();
		    System.out.println("factory ��������");
		    factory.setSizeThreshold(1 * 1024 * 1024);
		    factory.setRepository(temporaryDir);
		    ServletFileUpload upload = new ServletFileUpload(factory);
		    System.out.println("ServletFileUpload ��������");
		    upload.setSizeMax(2 * 1024 * 1024 * 1024);            
		    System.out.println("upload.getFileSizeMax()"+upload.getFileSizeMax());
		    System.out.println("upload.getSizeMax()"+upload.getSizeMax());
		    List items = null;
		    try {
		        items = upload.parseRequest(arg0);
		        System.out.println("items�޾ƿ��� ����"+items.size());
		    } catch (FileUploadException fe){
		        System.out.println(fe);
		    }
		    if(items!=null){
		    	System.out.println("items!=null ���Լ���");
		        
		        
		            FileItem fileItem = (FileItem) items.get(0); 
		            

		                //���� ���ε� ó��
		               
		             
                	String fileName = fileItem.getName();
                	long fileSize = fileItem.getSize()/1024 + (fileItem.getSize()%1024>0?1:0);
                    //File uploadedFile = new File(fileName);
                    System.out.println("filename : "+fileName);
                    System.out.println("filesize : "+fileSize);
                    Socket client = new Socket("127.0.0.1", 12345);
                    System.out.println("�������Ӽ���!!");
                    InputStream is = fileItem.getInputStream();
                    OutputStream os = client.getOutputStream();
                    DataOutputStream dout = new DataOutputStream(os);
                    
                	dout.writeLong(fileSize);
                	dout.writeUTF(fileName);
                	System.out.println("��� : "+fileName);
                	byte[] buffer = new byte[1024];
                	
                	int len;
                	System.out.println("����������..");
                	for(;fileSize>0;fileSize--) {
                    	len = is.read(buffer);
                    	os.write(buffer, 0, len);
                	}
                	dout.close();
                	os.close();
                	
                	
                	
                	System.out.println("�������ۿϷ�!!");
                	//return new ModelAndView("../index.jsp");
                	//1.���ڵ� �ϰ�, ���ϳ����� arg1�� �ھƼ�
                	//-------------------------------------------
            /*		File source = new File("movie/sample2.mp4");
            		File target = new File("movie/sample22.flv");*/
                	OnlineContentDBBean dto=new OnlineContentDBBean();
                	String filedir="C:\\Users\\�����\\Desktop\\";
                	
    				String[] fileNameE=fileName.split("[.]");//0: ���� ����, 1: ���� Ȯ����
    				System.out.println(fileNameE.length);
    				System.out.println(fileNameE[0]);
    				System.out.println(fileNameE[1]);
    				
            		dto.setFilename(fileNameE[0]+".mp4");
            		dto.setFiledir(filedir);
            		dto.setMnum(0);
            		dto.setVdnum(0);
            		System.out.println(onlineContentDAO);
            		onlineContentDAO.insertContent(dto, 0);//���Ƿ�! �־����� ����!
                	//2.forward�� �� �ִ� �״�� �޿� �Űܼ�..�ٵ� �� �������� ��� ��������
            		System.out.println("������� �Գ�");
		                
		            
		        
		    }
		    //new OnlineContentDAOImpl.insertBoard(dto);
		}
		//return new ModelAndView("redirect:board_list.do");
		
		return new ModelAndView("content/online/cont_detailForm.jsp");
	}
	@RequestMapping(value = "/list.content")
	public ModelAndView listContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_listContent() ����");
		return new ModelAndView("content/contentList.jsp");

	}

	@RequestMapping(value = "/cont_insert.content") // �ΰ����Form(�б�)
	public ModelAndView insertFormContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_insertFormContent() ����");
		return new ModelAndView("content/online/cont_insertForm.jsp");

	}
	
	@RequestMapping(value = "/cont_insertPro.content") // �ΰ����Pro(�б�)
	public ModelAndView insertProContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_insertProContent() ����");
		return new ModelAndView("content/contentList.jsp"); //���߿� ������������???

	}

	@RequestMapping(value = "/cont_detail.content") // �ΰ� �󼼺���
	public ModelAndView detailContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_detailContent() ����");
		//����!
		int num=Integer.parseInt(arg0.getParameter("num"));
		
		onlineContentDAO.getContent(num);
		return new ModelAndView("content/online/cont_detailForm.jsp");

	}
	
	// --------------  Ŀ��ŧ�� -----------------------------------
	
	@RequestMapping(value = "/curri_insert.content") // Ŀ��ŧ�� ���
	public ModelAndView insertFormCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_insertFormCurri() ����");
		return new ModelAndView("content/online/cont_insertForm.jsp");

	}
	
	@RequestMapping(value = "/curri_insertPro.content") // Ŀ��ŧ�� ���Pro
	public ModelAndView insertProCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_insertProCurri() ����");
		return new ModelAndView("content/contentList.jsp"); //���߿� �ڽ��� �ø� ����(�б�) ���������� ����

	}

	@RequestMapping(value = "/curri_detail.content") // ���ǽ�Form
	public ModelAndView detailCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_detailCurri() ����");
		return new ModelAndView("content/online/curr_detailForm.jsp");

	}
}