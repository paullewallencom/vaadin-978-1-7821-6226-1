package progressindicator;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ProgressIndicator;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author Alejandro Duarte
 * 
 */
@SuppressWarnings("serial")
public class ProgressindicatorUI extends UI {

  private ProgressIndicator mrProgressIndicator = new ProgressIndicator();

  private class HighTechAlgorithm extends Thread {
    @Override
    public void run() {
      try {
        
        for (int i = 1; i <= 10; i++) {
          sleep(1000);
          mrProgressIndicator.setValue(i * 0.1f);
        }

      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  protected void init(VaadinRequest request) {
    final VerticalLayout layout = new VerticalLayout();
    layout.setMargin(true);
    setContent(layout);

    Button button = new Button("Start awesome algorithm");

    button.addClickListener(new Button.ClickListener() {
      public void buttonClick(ClickEvent event) {
        new HighTechAlgorithm().start();
      }
    });

    layout.addComponent(button);
    layout.addComponent(mrProgressIndicator);
  }

}
