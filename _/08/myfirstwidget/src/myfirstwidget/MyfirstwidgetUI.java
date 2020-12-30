package myfirstwidget;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author Alejandro Duarte
 * 
 */
@SuppressWarnings("serial")
public class MyfirstwidgetUI extends UI {

  @Override
  protected void init(VaadinRequest request) {
    final VerticalLayout layout = new VerticalLayout();
    layout.setMargin(true);
    setContent(layout);

    MarqueeLabel marquee = new MarqueeLabel();
    marquee.setCaption("Hello Custom Widget!");
    layout.addComponent(marquee);
  }

}
