package icons;

import com.vaadin.server.ClassResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Main UI class
 */
@SuppressWarnings("serial")
public class IconsUI extends UI {

	private TextField tf = new TextField("Email");
	private ComboBox cb = new ComboBox("Type");
	private TextArea ta = new TextArea("Details");
	private OptionGroup og = new OptionGroup("Priority");
	private Button bt = new Button("Send");

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		layout.setSpacing(true);
		setContent(layout);

		tf.setWidth("100%");
		cb.setWidth("100%");
		ta.setWidth("100%");

		og.setWidth("100%");
		og.addItem("Too low");
		og.addItem("Extremely high");

		HorizontalLayout top = new HorizontalLayout();
		top.setWidth("100%");
		top.setSpacing(true);

		HorizontalLayout bottom = new HorizontalLayout();
		bottom.setWidth("100%");
		bottom.setSpacing(true);

		top.addComponent(tf);
		top.addComponent(cb);
		bottom.addComponent(og);
		bottom.addComponent(bt);

		layout.addComponent(top);
		layout.addComponent(ta);
		layout.addComponent(bottom);

		bottom.setComponentAlignment(bt, Alignment.BOTTOM_RIGHT);
		
		tf.setIcon(new ClassResource("email.png"));
		cb.setIcon(new ClassResource("note.png"));
		ta.setIcon(new ClassResource("document.png"));
		bt.setIcon(new ClassResource("ok.png"));
		
		og.setItemIcon("Too low", new ClassResource("attention.png"));
		og.setItemIcon("Extremely high", new ClassResource("error.png"));
	}

}