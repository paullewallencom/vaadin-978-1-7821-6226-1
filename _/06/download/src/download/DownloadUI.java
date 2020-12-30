package download;

import com.vaadin.server.ClassResource;
import com.vaadin.server.FileDownloader;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.BaseTheme;

/**
 * 
 * @author Alejandro Duarte
 * 
 */
@SuppressWarnings("serial")
public class DownloadUI extends UI {

  @Override
  protected void init(VaadinRequest request) {
    final VerticalLayout layout = new VerticalLayout();
    layout.setMargin(true);
    setContent(layout);
    
    ClassResource resource = new ClassResource("enterprise-app.pdf");

    Button button = new Button("Download the PDF");
    button.setStyleName(BaseTheme.BUTTON_LINK);
    
    FileDownloader downloader = new FileDownloader(resource);
    downloader.extend(button);
    
    layout.addComponent(button);
  }

}
