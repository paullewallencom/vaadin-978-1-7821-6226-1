package richtextarea;

import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author Alejandro Duarte.
 * 
 */
@SuppressWarnings("serial")
public class RichtextareaUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		RichTextArea richText = new RichTextArea("Rich text area:");
		richText.setImmediate(true);
		Label label = new Label(richText, ContentMode.HTML);

		VerticalLayout layout = new VerticalLayout();
		layout.addComponent(richText);
		layout.addComponent(label);
		setContent(layout);
	}

}