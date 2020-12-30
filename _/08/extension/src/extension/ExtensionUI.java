package extension;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author Alejandro Duarte
 * 
 */
@SuppressWarnings("serial")
public class ExtensionUI extends UI {

  @Override
  protected void init(VaadinRequest request) {
    final VerticalLayout layout = new VerticalLayout();
    layout.setMargin(true);
    setContent(layout);

    Label textField = new Label(
        "Do you dare to put the cursor over me?");
    layout.addComponent(textField);

    HideOnHover extension = new HideOnHover();
    extension.extend(textField);
  }

}
