package customcomponent;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author Alejandro Duarte
 * 
 */
@SuppressWarnings("serial")
public class CustomcomponentUI extends UI {

  @Override
  protected void init(VaadinRequest request) {
    final VerticalLayout layout = new VerticalLayout();
    layout.setMargin(true);
    setContent(layout);

    Label terms = new Label(
        "You agree with us on everything.");
    
    Panel panel = new Panel("LICENSE TERMS:");
    panel.setContent(terms);
    layout.addComponent(panel);

    AcceptTermsButton button = new AcceptTermsButton(
        "Yeah right. I do accept that.", "Install");

    button.addClickListener(new ClickListener() {
      @Override
      public void buttonClick(ClickEvent event) {
        Notification.show("Software installed.");
      }
    });

    layout.addComponent(button);
  }
}
