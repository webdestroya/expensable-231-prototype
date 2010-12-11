package expensable.client.activity.expensereport;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import expensable.client.ClientFactory;
import expensable.client.place.ExpenseReportsPlace;
import expensable.client.view.expensereport.ExpenseReportView;
import expensable.client.view.expensereport.ExpenseReportView.ExpenseReportPresenter;

public class ShowExpenseReportActivity extends AbstractActivity implements ExpenseReportPresenter {

  private ClientFactory clientFactory;

  public ShowExpenseReportActivity(ExpenseReportsPlace place, ClientFactory clientFactory) {
    this.clientFactory = clientFactory;
  }

  @Override
  public void start(AcceptsOneWidget container, EventBus eventBus) {
    ExpenseReportView view = clientFactory.getExpenseReportView();
    view.setPresenter(this);
    container.setWidget(view.asWidget());
  }

  @Override
  public void goTo(Place place) {
    clientFactory.getPlaceController().goTo(place);
  }
}