package corretortcc;

public class LatexConcreteBuilder implements FileTypeBuilder{

	@Override
	public TitleServlet createTitleServlet() {
		// TODO Auto-generated method stub
		return new TitleServlet();
	}

	@Override
	public Text createText() {
		// TODO Auto-generated method stub
		return new Text();
	}

	@Override
	public AbstractServlet createAbstractServlet() {
		return new AbstractServlet();
		// TODO Auto-generated method stub
		
	}

	@Override
	public SectionServlet createSectionServlet() {
		// TODO Auto-generated method stub
		return new SectionServlet();
	}

}
