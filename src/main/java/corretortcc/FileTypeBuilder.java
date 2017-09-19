package corretortcc;

public interface FileTypeBuilder {
	public abstract Title createTitle(String archiveName, String text);
	public abstract Abstract createAbstract(String archiveName, String text);
	public abstract Section createSection(String archiveName, String text);
	public abstract Text createText();
}
