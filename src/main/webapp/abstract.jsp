<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<table class="table table-hover">
	<thead>
		<tr>
			<th>#</th>
			<th>Erros no Abstract</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<%
				List<String> errorAbstract = (List<String>) request.getAttribute("errorAbstract");

				int count = 0;
				for (String erro : errorAbstract) {
			%>
			<th scope="row"><%=count++%></th>

			<td><%=erro%></td>
		</tr>
		<%
			}
		%>
	</tbody>
</table>
