package corretortcc;

public class Text {
	private Title titulo;
	private Abstract resumo;
	private Section[] sections;
	private Section section;
	
	public String mountText(){
		
		return titulo.getTitle()+"\n\n"+resumo.getAbstract()+"\n\n"+section.getSection();
	}

	public Title getTitulo() {
		return titulo;
	}

	public void setTitulo(Title titulo) {
		this.titulo = titulo;
	}

	public Abstract getResumo() {
		return resumo;
	}

	public void setResumo(Abstract resumo) {
		this.resumo = resumo;
	}

	public Section[] getSections() {
		return sections;
	}

	public void setSections(Section[] sections) {
		this.sections = sections;
	}
	
	public void setSection(Section section){
		this.section = section;
	}
	
	
}
