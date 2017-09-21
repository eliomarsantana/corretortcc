package corretortcc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TitleServlet
 */
public class TitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static String TITLE;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		FileTypeBuilder flb = new LatexConcreteBuilder(); 
		
		String mainText = (String) session.getAttribute("mainText");
		String arquiveName = (String) session.getAttribute("arquiveName");
	
		
		Title titleText = new Title(mainText, arquiveName);
		TITLE = titleText.getTitle();
		Regras role = new Regras(TITLE);
		role.virgulaPonto(TITLE);
		role.encontrarDoisPontos(TITLE);
		role.espacoParentese(TITLE);
		role.espacoCitacao(TITLE);
		 
		request.setAttribute("errorTitle", role.getErros());
		
	}

}
