package expensable.client.view.expensereport.item;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class ExpenseItemViewImpl extends Composite implements ExpenseItemView {

  private static Binder binder = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, ExpenseItemViewImpl>{}

  private int currentPanel;
  private ArrayList<CreateItemPanel> itemMap;

  @UiField ListBox expenseType;
  @UiField SimplePanel panel;

  private ExpenseItemPresenter presenter;

  public ExpenseItemViewImpl() {
    // TODO(dpurpura): Mitch add your various panels to itemMap here..
    // itemMap.add(...)
    initWidget(binder.createAndBindUi(this));
  }

  @Override
  public void setPresenter(ExpenseItemPresenter presenter) {
    this.presenter = presenter;
  }

  @UiHandler("expenseType")
  public void onExpenseTypeChange(ChangeEvent e) {
    int selectedIndex = expenseType.getSelectedIndex();
    if (currentPanel != selectedIndex) {
      panel.clear();
      panel.add(itemMap.get(selectedIndex).asWidget());
      currentPanel = selectedIndex;
    }
  }

}
