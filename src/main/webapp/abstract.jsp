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
				List<String> erros = (List<String>) request.getAttribute("errorAbstract");

				int count = 0;
				if(erros == null){
					
				%>
				<td>Você não possui erros no abstract</td>	
				<%
				}else{
				for (String erro : erros) {
			%>
			<th scope="row"><%=count++%></th>

			<td><%=erro%></td>
		</tr>
		<%
				}
			}
		%>
	</tbody>
