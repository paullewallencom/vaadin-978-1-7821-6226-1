package binding;

import com.vaadin.data.util.ObjectProperty;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author Alejandro Duarte.
 *
 */
@SuppressWarnings("serial")
public class BindingUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		// some UI components (viewers)
		TextField textField = new TextField("Data");
		textField.setImmediate(true);
		Label label = new Label();
		
		// a main layout
		VerticalLayout layout = new VerticalLayout();
		layout.addComponent(textField);
		layout.addComponent(label);
		setContent(layout);
		
		// a data source (property in Vaadin words)
		ObjectProperty<String> property = new ObjectProperty<String>("the value");
		
		// the binding
		textField.setPropertyDataSource(property);
		label.setPropertyDataSource(property);
	}

}