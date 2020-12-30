package datefield;

import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.InlineDateField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Main UI class
 */
@SuppressWarnings("serial")
public class DatefieldUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		InlineDateField dateField = new InlineDateField("Select a date");
		dateField.setResolution(Resolution.YEAR);
		dateField.setDateFormat("yyyy-MM-dd");

		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		layout.addComponent(dateField);
		setContent(layout);
	}

}