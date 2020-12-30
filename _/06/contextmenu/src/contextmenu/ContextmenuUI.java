package contextmenu;

import com.vaadin.event.Action;
import com.vaadin.event.Action.Handler;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author Alejandro Duarte
 *
 */
@SuppressWarnings("serial")
public class ContextmenuUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		Table table = new Table("A table:");
		table.setSizeFull();
    
    final Action action = new Action("Say hello");
    
    table.addActionHandler(new Handler() {
      
      @Override
      public void handleAction(Action action, Object sender, Object target) {
        Notification.show("Ok, here I go... Hello.");
      }
      
      @Override
      public Action[] getActions(Object target, Object sender) {
        return new Action[] { action };
      }
    });

		layout.addComponent(table);
	}

}
