<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<table class="table table-hover">
	<thead>
		<tr>
			<th>#</th>
			<th>Erros na seção</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<%
				List<String> errorSection = (List<String>) request.getAttribute("errorSection");

				int count = 0;
				for (String error : errorSection) {
			%>
			<th scope="row"><%=count++%></th>

			<td><%=error%></td>
		</tr>
		<%
			}
		%>
	</tbody>
</table>