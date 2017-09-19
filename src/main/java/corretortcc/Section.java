package corretortcc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Section {

	public Section(String archiveName, String text){
		setSection(text);
		setArchiveName(archiveName);
	}
	
	public void setSection(String text) {

		String regex = "\\section{(?<meuGrupo>.*?)";
	    String retorno = "";

	    Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);;
	    Matcher comparator = pattern.matcher(text);
	    if (comparator.find(0)){
	        this.text = comparator.group("meuGrupo");
	    }else {System.out.println("não encontrou section");}

	}

	
	public void setTitleSection(String text) {

		String regex = "\\\\section\\{(?<titulo>.*?)\\}";

		String title = text.replace("\\", "\\\\");//escapando as barras no arquivo
		
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher comparator = pattern.matcher(title);
		
		if (comparator.find()) {
			this.title = comparator.group("titulo");
		}
	}
	
	public String getSection(){
		return text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Section[] getSubsections() {
		return subsections;
	}

	public void setSubsections(Section[] subsections) {
		this.subsections = subsections;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getArchiveName() {
		return archiveName;
	}

	public void setArchiveName(String archiveName) {
		this.archiveName = archiveName;
	}
	
	
	
	private static final Pattern PATTERN = Pattern.compile(".*\\section\\{(.*)\\section\\{.*");
														//(".*\\\\begin\\{abstract\\}(.*)\\\\end\\{abstract\\}.*")
	private String title;
	private Section[] subsections;
	private String text;
	private String archiveName;
}
