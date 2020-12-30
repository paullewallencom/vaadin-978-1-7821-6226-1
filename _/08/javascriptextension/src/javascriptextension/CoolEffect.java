package javascriptextension;

import com.vaadin.annotations.JavaScript;
import com.vaadin.server.AbstractClientConnector;
import com.vaadin.server.AbstractJavaScriptExtension;

@SuppressWarnings("serial")
@JavaScript({ "cooleffect.js",
    "http://code.jquery.com/jquery-1.9.1.js" })
public class CoolEffect extends AbstractJavaScriptExtension {

  public void extend(AbstractClientConnector component) {
    super.extend(component);
  }

}
