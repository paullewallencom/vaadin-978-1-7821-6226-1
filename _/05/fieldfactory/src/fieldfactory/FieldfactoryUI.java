package fieldfactory;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Alejandro Duarte
 */
@SuppressWarnings("serial")
public class FieldfactoryUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Table table = new Table("Users");
		table.setPageLength(0);
		table.setEditable(true);
		table.addContainerProperty("Login", String.class, "");
		table.addContainerProperty("Password", String.class, "");

		table.addItem();
		table.addItem();
		table.addItem();

		layout.addComponent(table);

		table.setTableFieldFactory(new UserFieldFactory());
	}

}
