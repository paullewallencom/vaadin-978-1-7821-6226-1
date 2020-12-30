package slider;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Slider;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author Alejandro Duarte
 * 
 */
@SuppressWarnings("serial")
public class SliderUI extends UI {

  @Override
  protected void init(VaadinRequest request) {
    final VerticalLayout layout = new VerticalLayout();
    layout.setMargin(true);
    setContent(layout);

    Slider slider = new Slider("Drag the point");
    slider.setWidth("100%");
    slider.setMin(0.0);
    slider.setMax(100.0);
    slider.setValue(30.0);

    slider.addValueChangeListener(new ValueChangeListener() {
      @Override
      public void valueChange(ValueChangeEvent event) {
        Notification.show("Attention! Slider value has changed to "
            + event.getProperty().getValue());
      }
    });

    layout.addComponent(slider);
  }

}