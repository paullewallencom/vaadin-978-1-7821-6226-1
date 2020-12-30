package navigator;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * 
 * @author Alejandro Duarte.
 * 
 */
@SuppressWarnings("serial")
public class NavigatorUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		Navigator navigator = new Navigator(this, this);

		navigator.addView("", new Welcome());
		navigator.addView("page1", new Page1());
		navigator.addView("page2", new Page2());
	}

}
