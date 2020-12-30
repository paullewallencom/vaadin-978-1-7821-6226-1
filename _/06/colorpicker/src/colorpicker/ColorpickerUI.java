package colorpicker;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.ColorPicker;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Main UI class
 */
@SuppressWarnings("serial")
public class ColorpickerUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		ColorPicker picker = new ColorPicker("Select a color");
		picker.setHeight("100%");

		layout.addComponent(picker);
	}

}