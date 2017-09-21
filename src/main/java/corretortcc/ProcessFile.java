package corretortcc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class ProcessFile
 */
public class ProcessFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static String TEXTO_COMPLETO;
	public static String TEXTO_COMPLETO_SEM_INCLUDE;

	/*
	 * private ServletFileUpload uploader = null;
	 * 
	 * @Override public void init() throws ServletException {
	 * DiskFileItemFactory fileFactory = new DiskFileItemFactory(); File
	 * filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
	 * fileFactory.setRepository(filesDir); this.uploader = new
	 * ServletFileUpload(fileFactory); }
	 */

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.removeAttribute("erros");
		request.removeAttribute("erros2");
		request.removeAttribute("erros3");
		request.removeAttribute("erros4");

		Util util = new Util();

		response.setContentType("text/html;charset=UTF-8");

		HttpSession session = request.getSession();
		session.removeAttribute("mainText");
		session.removeAttribute("sectionText");

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List items = null;
		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		Iterator itr = items.iterator();
		while (itr.hasNext()) {
			FileItem item = (FileItem) itr.next();
			String name = item.getName();
			FileTypeBuilder flb = new LatexConcreteBuilder();

			if (item.getName().endsWith(".tex")) {
				if (item.getName().equals("main.tex")) {

					String mainText = util.retiraCaracterEspecial(util.UTF8toISO(item.getString()));

					session.setAttribute("mainText", mainText);

					flb.createTitleServlet().service(request, response);
					flb.createAbstractServlet().service(request, response);

				} else {
					String sectionText = util.retiraCaracterEspecial(util.UTF8toISO(item.getString()));
					session.setAttribute("sectionText", sectionText);

					// if(sectionText.matches(".*\\\\section\\{.*")){}

					flb.createSectionServlet().service(request, response);

				}
			} else {
				request.setAttribute("erro", "Somente upload de arquivo .tex");
				request.getRequestDispatcher("/erro.jsp").forward(request, response);

			}
		}
		request.getRequestDispatcher("/lista.jsp").forward(request, response);

	}

	/*
	 * String arquivo = request.getParameter("arquivo");
	 * 
	 * 
	 * if (arquivo.endsWith(".tex")) {
	 * 
	 * String diretorioPrincipal = arquivo.split("main.tex")[0];
	 * 
	 * String dados = new String(Files.readAllBytes(new
	 * File(arquivo).toPath()));
	 * 
	 * TEXTO_COMPLETO = util.retiraCaracterEspecial(util.UTF8toISO(dados));
	 * 
	 * 
	 * FileTypeBuilder flb = new LatexConcreteBuilder(); Text text =
	 * flb.createText(); Abstract r = flb.createAbstract(TEXTO_COMPLETO); Title
	 * t = flb.createTitle(TEXTO_COMPLETO); Section s =
	 * flb.createSection(TEXTO_COMPLETO); text.setResumo(r); text.setTitulo(t);
	 * text.setSection(s); //text.mountText();
	 * 
	 * 
	 * 
	 * 
	 * TEXTO_COMPLETO_SEM_INCLUDE = text.mountText();;
	 * 
	 * System.out.println(TEXTO_COMPLETO_SEM_INCLUDE); String regex =
	 * "\\\\input\\{(?<texto>.*?)\\}";
	 * 
	 * Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
	 * Matcher matcher = pattern.matcher(TEXTO_COMPLETO);
	 * 
	 * while (matcher.find()) { String input = matcher.group("texto");
	 * 
	 * 
	 * String sections = new String(Files.readAllBytes(new
	 * File(diretorioPrincipal+input).toPath()));
	 * 
	 * String sections2 = util.retiraCaracterEspecial(util.UTF8toISO(sections));
	 * String inputSection2 = ""; Matcher matcher2 = pattern.matcher(sections2);
	 * 
	 * while (matcher2.find()) {
	 * 
	 * String input2 = matcher.group("texto");
	 * 
	 * String inputSection = new String(Files.readAllBytes(new
	 * File(diretorioPrincipal+input2).toPath()));
	 * 
	 * inputSection2 =
	 * util.retiraCaracterEspecial(util.UTF8toISO(inputSection));
	 * 
	 * TEXTO_COMPLETO_SEM_INCLUDE = "/n" + TEXTO_COMPLETO_SEM_INCLUDE +
	 * inputSection2; }
	 * 
	 * TEXTO_COMPLETO_SEM_INCLUDE = "/n" + TEXTO_COMPLETO_SEM_INCLUDE +
	 * sections2;
	 * 
	 * }
	 * 
	 * request.setAttribute("erros", getLista()); request.setAttribute("erros2",
	 * getLista2()); request.setAttribute("erros3", getLista3());
	 * request.setAttribute("erros4", getLista4());
	 * 
	 * request.getRequestDispatcher("/lista.jsp").forward(request, response);
	 * 
	 * } else { request.setAttribute("erro", "Somente upload de arquivo .tex");
	 * request.getRequestDispatcher("/erro.jsp").forward(request, response);
	 * 
	 * }
	 */

	public List<String> getLista() {
		Regras r = new Regras(TEXTO_COMPLETO_SEM_INCLUDE);
		List<String> e = r.virgulaPonto(TEXTO_COMPLETO_SEM_INCLUDE);
		return e;
	}

	public List<String> getLista2() {
		Regras r = new Regras(TEXTO_COMPLETO_SEM_INCLUDE);
		List<String> e = r.encontrarDoisPontos(TEXTO_COMPLETO_SEM_INCLUDE);
		return e;
	}

	public List<String> getLista3() {
		Regras r = new Regras(TEXTO_COMPLETO_SEM_INCLUDE);
		List<String> e = r.espacoParentese(TEXTO_COMPLETO_SEM_INCLUDE);
		return e;
	}

	public List<String> getLista4() {
		Regras r = new Regras(TEXTO_COMPLETO_SEM_INCLUDE);
		List<String> e = r.espacoCitacao(TEXTO_COMPLETO_SEM_INCLUDE);
		return e;
	}
}
