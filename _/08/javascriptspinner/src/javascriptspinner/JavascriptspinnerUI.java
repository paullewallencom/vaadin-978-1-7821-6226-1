package javascriptspinner;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author Alejandro Duarte
 *
 */
@SuppressWarnings("serial")
public class JavascriptspinnerUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Spinner spinner = new Spinner();
		layout.addComponent(spinner);
	}

}
