package javascriptspinner;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;

@SuppressWarnings("serial")
@JavaScript({ "spinner.js",
    "http://code.jquery.com/jquery-1.9.1.js",
    "http://code.jquery.com/ui/1.10.3/jquery-ui.js" })
public class Spinner extends AbstractJavaScriptComponent {

}
