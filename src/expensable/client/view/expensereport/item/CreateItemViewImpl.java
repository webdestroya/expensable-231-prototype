package expensable.client.view.expensereport.item;

import java.util.ArrayList;

import com.google.common.collect.Lists;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

import expensable.client.place.CreateExpenseItemPlace;
import expensable.client.place.ExpenseReportsPlace;
import expensable.client.view.expensereport.CreateExpenseReportView.CreateExpenseReportPresenter;
import expensable.client.view.widget.Button;

public class CreateItemViewImpl extends Composite implements CreateExpenseItemView {

  private static Binder binder = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, CreateItemViewImpl>{}

  private int currentPanel;
  private ArrayList<CreateItemPanel> itemPanels;

  @UiField ListBox expenseType;
  @UiField SimplePanel panel;

  private CreateExpenseItemPresenter presenter;

  public CreateItemViewImpl() {
    // TODO(dpurpura): Mitch, add your various panels to itemMap here..
    itemPanels = Lists.newArrayList();
    itemPanels.add(new CreateAirfaireExpenseItemView());
    itemPanels.add(new CreateHotelExpenseItemView());

    initWidget(binder.createAndBindUi(this));
    panel.add(itemPanels.get(0).asWidget());
  }

  @Override
  public void setPresenter(CreateExpenseItemPresenter presenter) {
    this.presenter = presenter;
  }

  @UiHandler("expenseType")
  public void onExpenseTypeChange(ChangeEvent e) {
    int selectedIndex = expenseType.getSelectedIndex();
    if (currentPanel != selectedIndex) {
      panel.clear();
      panel.add(itemPanels.get(selectedIndex).asWidget());
      currentPanel = selectedIndex;
    }
  }
  
  @UiField Button createItem;

  @UiHandler("createItem")
  public void onCreateItemButtonClick(ClickEvent e) {
    presenter.goTo(new ExpenseReportsPlace(""));
  }
  
  @UiField Button createItem2;

  @UiHandler("createItem2")
  public void onCreate2ItemButtonClick(ClickEvent e) {
    presenter.goTo(new ExpenseReportsPlace("1"));
  }

}
