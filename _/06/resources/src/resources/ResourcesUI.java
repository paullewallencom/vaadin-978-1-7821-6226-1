package resources;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import com.vaadin.server.ClassResource;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.FileResource;
import com.vaadin.server.StreamResource;
import com.vaadin.server.StreamResource.StreamSource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.Flash;
import com.vaadin.ui.Image;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;

/**
 * 
 * @author Alejandro Duarte
 * 
 */
@SuppressWarnings("serial")
public class ResourcesUI extends UI {

  @Override
  protected void init(VaadinRequest request) {
    final TabSheet sheets = new TabSheet();
    sheets.setSizeFull();
    setContent(sheets);

    Image imageFromTheme = new Image(null, new ThemeResource(
        "common/icons/error.png"));
    imageFromTheme.setSizeFull();

    Image imageFromClasspath = new Image(null, new ClassResource(
        "globe.png"));
    imageFromClasspath.setSizeFull();

    BrowserFrame frameFromURL = new BrowserFrame(null,
        new ExternalResource("http://alejandrodu.com"));
    frameFromURL.setSizeFull();

    BrowserFrame frameFromFileSystem = new BrowserFrame(null,
        new FileResource(new File("C:/readme.txt")));

    StreamSource mySource = new StreamSource() {
      @Override
      public InputStream getStream() {
        return new InputStream() {

          private int size = 20;

          @Override
          public int read() throws IOException {

            if (size-- > 0) {
              return 'V'; // we are returning 20 V's.
            }

            return -1;
          }
        };
      }
    };

    BrowserFrame frameFromStream = new BrowserFrame(null,
        new StreamResource(mySource, "hello.txt"));

    Flash flashFromURL = new Flash(null, new ExternalResource(
        "http://www.youtube.com/v/ALgCDkZvzeY&hl=en_US&fs=1"));
    flashFromURL.setSizeFull();

    sheets.addTab(imageFromTheme, "Image from theme");
    sheets.addTab(imageFromClasspath, "image from classpath");
    sheets.addTab(frameFromURL, "Frame from URL");
    sheets.addTab(frameFromFileSystem, "Frame from file system");
    sheets.addTab(frameFromStream, "Frame from InputStream");
    sheets.addTab(flashFromURL, "Flash from URL");
  }

}
