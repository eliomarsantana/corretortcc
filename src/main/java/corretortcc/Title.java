package corretortcc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Title {

	private String title;
	private String archiveName;
	
	public Title(String text){
		setTitle(text);
	}
	
	public String getArchiveName() {
		return archiveName;
	}

	public void setArchiveName(String archiveName) {
		this.archiveName = archiveName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String text) {

		String regex = "\\\\title\\{(?<titulo>.*?)\\}";

		String title = text.replace("\\", "\\\\");//escapando as barras no arquivo
		
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher comparator = pattern.matcher(title);
		
		if (comparator.find()) {
			this.title = comparator.group("titulo");
		}
	}
}
