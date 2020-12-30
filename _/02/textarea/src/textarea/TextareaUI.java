package textarea;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author Alejandro Duarte.
 * 
 */
@SuppressWarnings("serial")
public class TextareaUI extends UI implements ValueChangeListener {

	@Override
	protected void init(VaadinRequest request) {
		// our TextArea component
		TextArea textArea = new TextArea(
				"Enter some multi-lined text and press TAB:");
		textArea.addValueChangeListener(this);
		textArea.setImmediate(true);

		VerticalLayout layout = new VerticalLayout();
		layout.addComponent(textArea);
		setContent(layout);
	}

	@Override
	public void valueChange(ValueChangeEvent event) {
		String userText = event.getProperty().getValue()
				.toString();
		Notification.show("This is it: " + userText);
	}

}