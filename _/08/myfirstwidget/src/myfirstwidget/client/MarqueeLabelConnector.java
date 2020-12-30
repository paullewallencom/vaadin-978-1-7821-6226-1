package myfirstwidget.client;

import myfirstwidget.MarqueeLabel;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;

/**
 * 
 * @author Alejandro Duarte
 * 
 */
@SuppressWarnings("serial")
@Connect(MarqueeLabel.class)
public class MarqueeLabelConnector extends AbstractComponentConnector {

  private MarqueeLabelServerRpc rpc = RpcProxy.create(
      MarqueeLabelServerRpc.class, this);
  
  public MarqueeLabelConnector() {
    getWidget().addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        rpc.clicked();
      }
    });
  }

  @Override
  public Widget createWidget() {
    return GWT.create(MarqueeLabelWidget.class);
  }

  @Override
  public MarqueeLabelWidget getWidget() {
    return (MarqueeLabelWidget) super.getWidget();
  }

  @Override
  public MarqueeLabelState getState() {
    return (MarqueeLabelState) super.getState();
  }

  @Override
  public void onStateChanged(StateChangeEvent stateChangeEvent) {
    super.onStateChanged(stateChangeEvent);
    getWidget().setText(getState().text);
  }

}
