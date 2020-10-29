package com.cos.springblog.util;

public class Script {

//	public static void outText(String msg, HttpServletResponse response) {
//
//		try {
//			response.setCharacterEncoding("utf-8");
//			response.setContentType("text/plain; charset=utf-8");
//			PrintWriter out = response.getWriter();
//
//			out.print(msg);
//
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//	public static void outJson(String msg, HttpServletResponse response) {
//
//		try {
//			response.setCharacterEncoding("utf-8");
//			response.setContentType("application/json; charset=utf-8");
//			PrintWriter out = response.getWriter();
//
//			out.print(msg);
//
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	public static void getMessage(String msg, HttpServletResponse response) {
//
//		try {
//			response.setCharacterEncoding("utf-8");
//			response.setContentType("text/html; charset=utf-8");
//			PrintWriter out = response.getWriter();
//
//			out.println("<h1>"+msg+"</h1>");
//
//		
//
//			// redirect 안쓰고 history back을 다 쓴다
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	public static void back(String msg, HttpServletResponse response) {
//
//		try {
//			response.setCharacterEncoding("utf-8");
//			response.setContentType("text/html; charset=utf-8");
//			PrintWriter out = response.getWriter();
//
//			out.println("<script>");
//			out.println("alert('" + msg + "');");
//			out.println("history.back();");
//			out.println("</script>");
//
//			// redirect 안쓰고 history back을 다 쓴다
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	// 얘는 회원가입성공했습니다 띄어줄것 주소넣기전에 알림을 해줄 수 있다.
//	public static void href(String msg, String uri, HttpServletResponse response) {
//
//		try {
//			response.setCharacterEncoding("utf-8");
//			response.setContentType("text/html; charset=utf-8");
//			PrintWriter out = response.getWriter();
//
//			out.println("<script>");
//			out.println("alert('" + msg + "');");
//			out.println("location.href='" + uri + "';");
//			out.println("</script>");
//
//			// redirect 안쓰고 history back을 다 쓴다
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	public static void href(String uri, HttpServletResponse response) {
//
//		try {
//			response.setCharacterEncoding("utf-8");
//			response.setContentType("text/html; charset=utf-8");
//			PrintWriter out = response.getWriter();
//
//			out.println("<script>");
//
//			out.println("location.href='" + uri + "';");
//			out.println("</script>");
//
//			// redirect 안쓰고 history back을 다 쓴다
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
	
	
	
// 스크립트 	
public static String href(String msg, String uri) {
		
		return
			"<script>"+
			"alert('"+ msg +"');"+
			"location.href='" + uri + "';" + 
			"</script>";
	}
	
	
public static String href(String uri) {
		
		return
			"<script>"+
			"location.href='" + uri + "';" + 
			"</script>";
	}
	
	
	public static String back(String msg) {

		return 
			"<script>" + 
			"alert('" + msg + "');" + 
			"history.back();" + 
			"</script>";
	}
				
		
					// redirect 안쓰고 history back을 다 쓴다
			
}