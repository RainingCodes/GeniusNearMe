<%

String src = request.getContextPath() + "/talent/comment?talentId=" + request.getParameter("talentId");
System.out.println(src);
response.sendRedirect(src); 

%>