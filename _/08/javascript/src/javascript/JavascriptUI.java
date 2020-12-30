package javascript;

import org.json.JSONArray;
import org.json.JSONException;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.JavaScript;
import com.vaadin.ui.JavaScriptFunction;
import com.vaadin.ui.Link;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author Alejandro Duarte
 * 
 */
@SuppressWarnings("serial")
public class JavascriptUI extends UI {

  @Override
  protected void init(VaadinRequest request) {
    final VerticalLayout layout = new VerticalLayout();
    layout.setMargin(true);
    setContent(layout);

    JavaScript.getCurrent().execute(
        "alert('Hello from server side.')");

    JavaScript.getCurrent().addFunction("myFunction",
        new JavaScriptFunction() {
          @Override
          public void call(JSONArray arguments) throws JSONException {
            Notification
                .show("JavaScript called me, I show this message.");
          }
        });

    Link link = new Link("JavaScript request", new ExternalResource(
        "javascript:window.myFunction()"));
    layout.addComponent(link);
  }

}
