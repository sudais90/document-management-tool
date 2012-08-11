<div class="footer">
<%@page import="java.util.Enumeration"%><span class="copyright">
<a href="mailto:ibharatsharma@gmail.com">ibharatsharma@gmail.com</a>
<span>
<% 

Enumeration sa =  session.getAttributeNames();
while(sa.hasMoreElements()){
	
%>
	<%= session.getAttribute(sa.nextElement().toString()) %>
<%	
}
%>

</div>