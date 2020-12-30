package timeit.ui;

import java.util.Collection;

import timeit.biz.TestSet;
import timeit.biz.TestSetExecutor;
import timeit.biz.test.LongVsInt;
import timeit.biz.test.ShortCircuitVsNoShortCircuit;
import timeit.biz.test.StringVsStringBuffer;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.UserError;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author Alejandro Duarte.
 *
 */
@SuppressWarnings("serial")
public class TimeItUI extends UI {
	
	private static final TestSet[] testSets = new TestSet[] {
		new LongVsInt(),
		new StringVsStringBuffer(),
		new ShortCircuitVsNoShortCircuit()
	};
	
	private VerticalLayout layout = new VerticalLayout();
	private ComboBox combo = new ComboBox("Test");
	private final TextField textField = new TextField("Number of iterations", "1000");
	private CheckBox checkBox = new CheckBox("Keep previous results");
	private Button button = new Button("Time it!");
	private VerticalLayout resultsLayout = new VerticalLayout();
	
	@Override
	protected void init(VaadinRequest request) {
		initCombo();
		initButton();
		initLayout();
	}

	private void initCombo() {
		for(TestSet testSet : testSets) {
			combo.addItem(testSet);
			combo.setItemCaption(testSet, testSet.getTitle());
		}
		
		combo.addValueChangeListener(new ValueChangeListener() {
			@Override
			public void valueChange(ValueChangeEvent event) {
				TestSet testSet = (TestSet) combo.getValue();
				textField.setValue("" + testSet.getDefaultTimes());
				button.setDescription("<big>" + testSet.getDescription() + "</big>");
			}
		});
		
		combo.setImmediate(true);
	}

	private void initButton() {
		button.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				if(isValid()) {
					runSelectedTest();
				}
			}
		});
	}
	
	private void initLayout() {
		layout.setMargin(true);
		layout.setSpacing(true);
		layout.addComponent(combo);
		layout.addComponent(textField);
		layout.addComponent(checkBox);
		layout.addComponent(button);
		layout.addComponent(resultsLayout);
		
		setContent(layout);
	}

	public boolean isValid() {
		combo.setComponentError(null);
		textField.setComponentError(null);
		
		boolean isValid = true;
		
		if(combo.getValue() == null) {
			combo.setComponentError(new UserError("Select a test from the list."));
			isValid = false;
		}
		
		if(textField.getValue().toString().isEmpty()) {
			textField.setComponentError(new UserError("You must introduce the number of iterations to execute"));
			isValid = false;
		}
		
		return isValid;
	}
	
	public void runSelectedTest() {
		Long times = Long.parseLong(textField.getValue());
		Collection<String> results = TestSetExecutor.execute((TestSet) combo.getValue(), times);
		showResults(results);
	}
	
	private void showResults(Collection<String> results) {
		if(!checkBox.getValue()) {
			resultsLayout.removeAllComponents();
			
		} else if(resultsLayout.getComponentCount() > 0) {
			resultsLayout.addComponent(new Label("--"));
		}
		
		for(String result : results) {
			resultsLayout.addComponent(new Label(result));
		}
	}

}