package corretortcc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SectionServlet
 */
public class SectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static String SECTION;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String sectionText = (String) session.getAttribute("sectionText");
		String arquiveName = (String) session.getAttribute("arquiveName");
		
		Section section = new Section(sectionText, arquiveName);
		SECTION = section.getSection();
		Regras role = new Regras(sectionText);
		role.virgulaPonto(sectionText);
		role.encontrarDoisPontos(sectionText);
		role.espacoParentese(sectionText);
		role.espacoCitacao(sectionText);
		 
		request.setAttribute("errorSection", role.getErros());
		
	}
}
