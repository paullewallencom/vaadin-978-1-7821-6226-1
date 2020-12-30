package editabletable;

import java.util.Date;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Alejandro Duarte
 */
@SuppressWarnings("serial")
public class EditabletableUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Table table = new Table();
		table.setPageLength(0);
		table.setEditable(true);

		table.addContainerProperty("String", String.class, "");
		table.addContainerProperty("Boolean", Boolean.class, false);
		table.addContainerProperty("Date", Date.class, null);
		table.addContainerProperty("Item", Item.class, null);

		table.addItem();
		table.addItem();
		table.addItem();

		User user = new User();
		user.setLogin("mylogin");
		user.setPassword("mypassword");

		BeanItem<User> item = new BeanItem<User>(user);

		table.addItem(new Object[] { "", true, new Date(), item }, 4);

		layout.addComponent(table);
	}

}
