package corretortcc;

public interface FileTypeBuilder {
	public abstract TitleServlet createTitleServlet();
	public abstract SectionServlet createSectionServlet();
	public abstract Text createText();
	public abstract AbstractServlet createAbstractServlet();
}
