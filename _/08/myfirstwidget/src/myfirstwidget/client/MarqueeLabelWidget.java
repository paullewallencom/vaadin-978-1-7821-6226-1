package myfirstwidget.client;

import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Label;

/**
 * 
 * @author Alejandro Duarte
 * 
 */
public class MarqueeLabelWidget extends Label {

  public MarqueeLabelWidget() {
    final Element element = getElement();
    element.getStyle().setPosition(Position.RELATIVE);

    Timer timer = new Timer() {
      private int left = 0;

      @Override
      public void run() {
        element.getStyle().setLeft(left, Unit.PX);
        left++;
      }
    };

    timer.scheduleRepeating(100);
  }

}
