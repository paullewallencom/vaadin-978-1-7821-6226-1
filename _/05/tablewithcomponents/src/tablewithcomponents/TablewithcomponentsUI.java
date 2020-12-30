package tablewithcomponents;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Alejandro Duarte
 */
@SuppressWarnings("serial")
public class TablewithcomponentsUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Table table = new Table();
		table.setPageLength(0);

		table.addContainerProperty("Text fields", TextField.class, null);
		table.addContainerProperty("Check boxes", CheckBox.class, null);

		table.addItem(new Object[] { new TextField(), new CheckBox() }, 1);

		layout.addComponent(table);
	}

}