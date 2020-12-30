package javascriptextension;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Main UI class
 */
@SuppressWarnings("serial")
public class JavascriptextensionUI extends UI {

  @Override
  protected void init(VaadinRequest request) {
    final VerticalLayout layout = new VerticalLayout();
    layout.setSizeFull();
    setContent(layout);
    
    FormLayout form = new FormLayout();
    form.setSpacing(true);
    form.setMargin(true);
    form.addComponent(new TextField("Username: "));
    form.addComponent(new PasswordField("Password: "));
    
    Panel panel = new Panel("Welcome", form);
    panel.setSizeUndefined();
    layout.addComponent(panel);
    layout.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);

    CoolEffect effect = new CoolEffect();
    effect.extend(panel);
  }

}
