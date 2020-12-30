package shortcut2;

import com.vaadin.event.Action;
import com.vaadin.event.Action.Handler;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutAction.ModifierKey;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;

/**
 * 
 * @author Alejandro Duarte.
 * 
 */
@SuppressWarnings("serial")
public class Shortcut2UI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		Panel panel = new Panel();
		panel.setSizeFull();
		setContent(panel);

		Handler handler = new Handler() {

			@Override
			public Action[] getActions(Object target, Object sender) {
				return new Action[] {
						new ShortcutAction("Enter", KeyCode.ENTER, null),
						new ShortcutAction("Shift + U", KeyCode.U,
								new int[] { ModifierKey.SHIFT }) };
			}

			@Override
			public void handleAction(Action action, Object sender, Object target) {
				Notification.show(action.getCaption());
			}

		};

		panel.addActionHandler(handler);

	}

}