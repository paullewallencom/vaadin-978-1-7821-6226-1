package optiongroup;

import java.util.ArrayList;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Notification;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author Alejandro Duarte.
 * 
 */
@SuppressWarnings("serial")
public class OptiongroupUI extends UI implements
		ValueChangeListener {

	@Override
	protected void init(VaadinRequest request) {
		// an array with the options
		ArrayList<String> answers = new ArrayList<String>();
		answers.add("Vaadin beans");
		answers.add("Session beans");
		answers.add("Enterprise App for Vaadin beans");
		answers.add("Message-driven beans");

		// our OptionGroup component
		OptionGroup og = new OptionGroup(
				"Two kinds of EJBs in Java EE are:", answers);
		og.addValueChangeListener(this);
		og.setImmediate(true);
		// FIXME: og should be multi select!

		// our main layout
		VerticalLayout layout = new VerticalLayout();
		layout.addComponent(og);
		setContent(layout);
	}

	@Override
	public void valueChange(ValueChangeEvent event) {
		String answer = event.getProperty().getValue().toString();
		Notification.show("Your answer: " + answer);
	}

}