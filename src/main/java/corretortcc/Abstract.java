package corretortcc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.ManagedBean;

@ManagedBean
public class Abstract {

	public Abstract(String text) {
		setAbstract(text);
		
	}

	public String getAbstract() {
		
		
		return text;
	}

	public void setAbstract(String text) {
		

		String resume = text.replace("\\", "\\\\");// escapando as barras no
													// arquivo
		String t = resume.replace("\n", "\\n");
		
		/*String regex = "\\section\\{abstract\\}\\{(?<meuGrupo>.*?)\\}";

		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher comparator = pattern.matcher(text);

		if (comparator.find()) {
			this.text = comparator.group("meuGrupo");

		}*/
		Matcher matcher = PATTERN.matcher(t);

		if (matcher.matches() && matcher.groupCount() == 1) {
			this.text = matcher.group(1);
		} else {
			System.out.println("Não encontrou resumo.");
		}

	}

	public String getArchiveName() {
		return archiveName;
	}

	public void setArchiveName(String archiveName) {
		this.archiveName = archiveName;
	}



	private String text;
	private String archiveName;
	
	private static final Pattern PATTERN = Pattern.compile(".*\\\\begin\\{abstract\\}(.*)\\\\end\\{abstract\\}.*");
}
