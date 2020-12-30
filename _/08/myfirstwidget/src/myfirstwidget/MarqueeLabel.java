package myfirstwidget;

import myfirstwidget.client.MarqueeLabelServerRpc;
import myfirstwidget.client.MarqueeLabelState;

import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Notification;

/**
 * 
 * @author Alejandro Duarte
 * 
 */
@SuppressWarnings("serial")
public class MarqueeLabel extends AbstractComponent {

  public MarqueeLabel() {
    registerRpc(new MarqueeLabelServerRpc() {
      @Override
      public void clicked() {
        Notification
            .show("You clicked, so I made an RPC to the server.");
      }
    });
  }

  @Override
  public MarqueeLabelState getState() {
    return (MarqueeLabelState) super.getState();
  }
  
  @Override
  public void setCaption(String caption) {
    getState().text = caption;
  }

}
