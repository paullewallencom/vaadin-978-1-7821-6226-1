package table;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.FooterClickEvent;
import com.vaadin.ui.Table.FooterClickListener;
import com.vaadin.ui.Table.HeaderClickEvent;
import com.vaadin.ui.Table.HeaderClickListener;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Alejandro Duarte.
 */
@SuppressWarnings("serial")
public class MyFirstTableUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		final Table table = new Table();

		table.addContainerProperty("Column 1", String.class, "(default 1)");
		table.addContainerProperty("Column 2", String.class, "(default 2)");

		table.addItem(new Object[] { "Hi", "There" }, "item ID 1");
		table.addItem(new Object[] { "Well", "Hello!" }, "item ID 2");
		table.addItem();

		table.setColumnFooter("Column 1", "Footer 1");
		table.setFooterVisible(true);

		table.addHeaderClickListener(new HeaderClickListener() {
			@Override
			public void headerClick(HeaderClickEvent event) {
				Notification.show("Header clicked: " + event.getPropertyId());
			}
		});

		table.addFooterClickListener(new FooterClickListener() {
			@Override
			public void footerClick(FooterClickEvent event) {
				Notification.show("Footer clicked: " + event.getPropertyId());
			}
		});

		layout.addComponent(table);
	}

}
