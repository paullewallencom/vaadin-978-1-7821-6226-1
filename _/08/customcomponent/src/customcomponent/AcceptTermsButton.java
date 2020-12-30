package customcomponent;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author Alejandro Duarte
 * 
 */
@SuppressWarnings("serial")
public class AcceptTermsButton extends CustomComponent {

  private VerticalLayout layout = new VerticalLayout();
  private CheckBox checkbox = new CheckBox();
  private Button button = new Button();

  public AcceptTermsButton(String checkboxCaption,
      String buttonCaption) {

    layout.setSpacing(true);

    checkbox.setCaption(checkboxCaption);
    checkbox.addValueChangeListener(new ValueChangeListener() {
      @Override
      public void valueChange(ValueChangeEvent event) {
        button.setEnabled(checkbox.getValue());
      }
    });

    button.setCaption(buttonCaption);
    button.setEnabled(false);

    layout.addComponent(checkbox);
    layout.addComponent(button);

    setCompositionRoot(layout);
  }

  public void addClickListener(ClickListener listener) {
    button.addClickListener(listener);
  }

}
