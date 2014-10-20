package com.virt.Servlet;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.file.FileAlreadyExistsException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.omg.CORBA.portable.InputStream;

import util.AdbCommandUtil;

/**
 * Servlet implementation class FileReceiveServlet
 */
@WebServlet("/FileReceiveServlet")
public class FileReceiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String PATH="/home/usr/Programs/manage_cloud/VirtualSmartPhSer/WebContent/Screens/";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileReceiveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String folderPath=null;
		String fileName=null;
		Writer writer=response.getWriter();
		List<FileItem> items;
		System.out.println("In FilesReciveServlet");
		try {
			System.out.println("inside try");
			items=new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			for(FileItem item : items) {
				if(item.isFormField()){
				System.out.println("if block");
					
				}
				else
				{
					System.out.println("else block");
					String fieldname=item.getString();
				//	System.out.println("fieldname"+fieldname);
					if(fieldname.equals("uploadFIle"));
					fileName=FilenameUtils.getName(item.getName());
					System.out.println("fileName:"+fileName);
					java.io.InputStream filecontent=item.getInputStream();
					File f=new File(PATH+"/"+fileName);
					
				if(!f.exists())
				{
					f.createNewFile();
				}
					OutputStream out=new FileOutputStream(f);
					byte buf[] =new byte[1024];
					int len;
					while((len=filecontent.read(buf))>0)
						out.write(buf,0,len);
					out.close();filecontent.close();	
					AdbCommandUtil adbConn=new AdbCommandUtil();
					adbConn.commandpushFile(fileName);
				//Thread.sleep(3000);		
				}
			}
		} catch (FileUploadException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (FileAlreadyExistsException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}



}
