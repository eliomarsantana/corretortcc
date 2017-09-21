<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<table class="table table-hover">
	<thead>
		<tr>
			<th>#</th>
			<th>Erros no título</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<%
				List<String> errorTitle = (List<String>) request.getAttribute("errorTitle");

				int count = 0;
				for (String erro : errorTitle) {
			%>
			<th scope="row"><%=count++%></th>

			<td><%=erro%></td>
		</tr>
		<%
			}
		%>
	</tbody>
</table>