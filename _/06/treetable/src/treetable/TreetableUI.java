package treetable;

import java.io.File;

import com.vaadin.data.util.FilesystemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.TreeTable;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author Alejandro Duarte
 * 
 */
@SuppressWarnings("serial")
public class TreetableUI extends UI {

  @Override
  protected void init(VaadinRequest request) {
    final VerticalLayout layout = new VerticalLayout();
    layout.setMargin(true);
    setContent(layout);

    File folder = VaadinService.getCurrent().getBaseDirectory();
    FilesystemContainer container = new FilesystemContainer(folder);

    TreeTable treeTable = new TreeTable();
    treeTable.setContainerDataSource(container);
    treeTable.setSizeFull();

    layout.addComponent(treeTable);
  }

}
