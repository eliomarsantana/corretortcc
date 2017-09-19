package corretortcc;

public class LatexConcreteBuilder implements FileTypeBuilder{

	@Override
	public Title createTitle(String archiveName, String text) {
		// TODO Auto-generated method stub
		return new Title(archiveName, text);
	}

	@Override
	public Abstract createAbstract(String archiveName, String text) {
		// TODO Auto-generated method stub
		return new Abstract(archiveName, text);
	}

	@Override
	public Text createText() {
		// TODO Auto-generated method stub
		return new Text();
	}

	@Override
	public Section createSection(String archiveName, String text) {
		// TODO Auto-generated method stub
		return new Section(archiveName, text);
	}

}
