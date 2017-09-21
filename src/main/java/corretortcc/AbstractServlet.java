package corretortcc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AbstractServlet
 */
public class AbstractServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public static String ABSTRACT;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String mainText = (String) session.getAttribute("mainText");
		String arquiveName = (String) session.getAttribute("arquiveName");
	
		
		Abstract abstractText = new Abstract(mainText, arquiveName);
		ABSTRACT = abstractText.getAbstract();
		Regras role = new Regras(ABSTRACT);
		role.virgulaPonto(ABSTRACT);
		role.encontrarDoisPontos(ABSTRACT);
		role.espacoParentese(ABSTRACT);
		role.espacoCitacao(ABSTRACT);
		 
		request.setAttribute("errorAbstract", role.getErros());
		
	}

}
