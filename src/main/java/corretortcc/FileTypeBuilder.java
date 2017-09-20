package corretortcc;

public interface FileTypeBuilder {
	public abstract TitleServlet createTitleServlet();
	public abstract Section createSection(String archiveName, String text);
	public abstract Text createText();
	public abstract AbstractServlet createAbstractServlet();
}
