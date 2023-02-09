<%@ tag body-content="empty" language="java" pageEncoding="UTF-8"%>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="value" type="java.lang.String" required="true" %>
<%
value.replace("\r\n","<br>");
// value.replace("crcn", "\r\n");
// value.replace("\n", "\n<br>");
// value.replace("\n", "<br/>");
value.replace("&", "&amp;");
value.replace("<", "&lt;");
value.replace(">", "&gt;");
%>
<%=value %>