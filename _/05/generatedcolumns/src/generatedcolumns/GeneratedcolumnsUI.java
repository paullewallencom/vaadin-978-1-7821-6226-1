package generatedcolumns;

import com.vaadin.data.Property;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Alejandro Duarte
 */
@SuppressWarnings("serial")
public class GeneratedcolumnsUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Table table = new Table() {
			@Override
			protected String formatPropertyValue(Object rowId, Object colId,
					Property<?> property) {

				Integer n = (Integer) property.getValue();

				if (n < 0) {
					return "(" + (-n) + ")";
				}

				return "" + n;
			}
		};

		table.setPageLength(0);
		table.addContainerProperty("A", Integer.class, 0);
		table.addContainerProperty("B", Integer.class, 0);

		table.addGeneratedColumn("A + B", new ColumnGenerator() {
			@Override
			public Object generateCell(Table source, Object itemId,
					Object columnId) {

				Integer a = (Integer) source.getItem(itemId)
						.getItemProperty("A").getValue();

				Integer b = (Integer) source.getItem(itemId)
						.getItemProperty("B").getValue();

				return new Label("" + (a + b));
			}
		});

		table.addItem(new Object[] { 10, 20 }, 1);
		table.addItem(new Object[] { -5, 6 }, 3);

		table.setColumnCollapsingAllowed(true);
		table.setColumnCollapsible("A + B", false);

		layout.addComponent(table);
	}

}