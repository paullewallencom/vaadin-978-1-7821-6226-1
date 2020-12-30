package clientsideapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class MyEntryPoint implements EntryPoint {

  @Override
  public void onModuleLoad() {
    Button button = new Button("Click Me");
    button.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        RootPanel.get().add(new Label("Thank you for clicking"));
      }
    });
    RootPanel.get().add(button);
  }

}
