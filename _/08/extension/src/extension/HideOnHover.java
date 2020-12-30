package extension;

import com.vaadin.server.AbstractExtension;
import com.vaadin.ui.Label;

@SuppressWarnings("serial")
public class HideOnHover extends AbstractExtension {

  public void extend(Label label) {
    super.extend(label);
  }

}
