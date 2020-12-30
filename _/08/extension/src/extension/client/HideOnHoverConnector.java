package extension.client;

import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.shared.ui.Connect;

import extension.HideOnHover;

@SuppressWarnings("serial")
@Connect(HideOnHover.class)
public class HideOnHoverConnector extends AbstractExtensionConnector {

  @Override
  protected void extend(ServerConnector target) {
    final Widget widget = ((ComponentConnector) target).getWidget();

    widget.addHandler(new MouseOverHandler() {
      @Override
      public void onMouseOver(MouseOverEvent event) {
        widget.setVisible(false);
      }
    }, MouseOverEvent.getType());
  }

}
