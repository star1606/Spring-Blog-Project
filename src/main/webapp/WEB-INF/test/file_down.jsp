<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page impoty="jave.io.File" %>
<%@ page import="java.io.*" %>    
    
 <%
 	String fileName = request.getParameter("file_name");
 	
 	String savePath = "upload";
 	
 	ServletContext context = getServletContext();
 	String sDownloadPath = context.getRealPath(savePath);
 	String sFilePath = sDownloadPath + "\\" + fileName;
 	byte b[] = new byte[4096];
 	FileInputStream in = new FileInputStream(sFilePath);
 	String sMimeType = getServletContext().getMimeType(sFilePath);
 	System.out.println("sMimeType>>>" + sMimeType);
 	
 	//if()
 
 %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>