package customtheme;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author Alejandro Duarte
 * 
 */
@SuppressWarnings("serial")
@Theme("cool")
public class CustomthemeUI extends UI {

  @Override
  protected void init(VaadinRequest request) {
    final VerticalLayout layout = new VerticalLayout();
    layout.setSizeFull();
    layout.setMargin(true);
    setContent(layout);

    Component header = getHeader();
    layout.addComponent(header);
    
    Component contentArea = getContentArea();
    layout.addComponent(contentArea);
    layout.setExpandRatio(contentArea, 1);
  }

  private Component getHeader() {
    VerticalLayout header = new VerticalLayout();
    header.setWidth("100%");

    Label title = new Label("My Vaadin Application");
    title.addStyleName("page-header");
    header.addComponent(title);

    return header;
  }

  private Component getContentArea() {
    HorizontalLayout content = new HorizontalLayout();
    content.setSizeFull();

    Component menu = getMenu();
    content.addComponent(menu);
    
    Component mainArea = getMainArea();
    content.addComponent(mainArea);
    content.setExpandRatio(mainArea, 1);

    return content;
  }

  private Component getMenu() {
    VerticalLayout menu = new VerticalLayout();
    menu.setSpacing(true);
    menu.setWidth("100px");

    Button button1 = new Button("Dashboard");
    button1.setWidth("100%");
    menu.addComponent(button1);

    Button button2 = new Button("Services");
    button2.setWidth("100%");
    menu.addComponent(button2);

    Button button3 = new Button("Reports");
    button3.setWidth("100%");
    menu.addComponent(button3);

    return menu;
  }

  private Component getMainArea() {
    GridLayout main = new GridLayout(2, 3);
    main.setMargin(true);
    main.setSpacing(true);
    main.setSizeFull();
    main.setRowExpandRatio(1, 1);

    TextField textField = new TextField();
    textField.setInputPrompt("Search");
    textField.setWidth("100%");
    main.addComponent(textField, 0, 0);
    
    MenuBar menuBar = new MenuBar();
    menuBar.setWidth("100%");
    menuBar.addItem("Option 1", null);
    menuBar.addItem("Option 2", null);
    menuBar.addItem("Option 3", null);
    main.addComponent(menuBar, 1, 0);
    
    Table table = new Table();
    table.setSizeFull();
    table.setPageLength(0);
    table.addContainerProperty("Datum", String.class, "");
    table.addContainerProperty("Ammount", String.class, "");
    table.addItem(new Object[] { "data 1", "200.000" }, 1);
    table.addItem(new Object[] { "data 2", "197.000" }, 2);
    table.addItem(new Object[] { "data 3", "901.300" }, 3);
    table.addItem(new Object[] { "data 4", "428.450" }, 4);
    table.addItem(new Object[] { "data 5", "811.708" }, 5);
    main.addComponent(table, 0, 1);

    Panel panel = new Panel();
    panel.setSizeFull();
    panel
        .setContent(new Label(
            "Important info here. <br/>1000<br/>2000<br/>5000<br/>9000<br/>140000",
            ContentMode.HTML));
    main.addComponent(panel, 1, 1);

    return main;
  }

}