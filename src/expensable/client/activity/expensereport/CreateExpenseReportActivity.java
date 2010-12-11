package expensable.client.activity.expensereport;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import expensable.client.ClientFactory;
import expensable.client.place.CreateExpenseReportPlace;
import expensable.client.view.expensereport.CreateExpenseReportView;
import expensable.client.view.expensereport.CreateExpenseReportView.CreateExpenseReportPresenter;

public class CreateExpenseReportActivity extends AbstractActivity implements CreateExpenseReportPresenter {

  private ClientFactory clientFactory;

  public CreateExpenseReportActivity(CreateExpenseReportPlace place, ClientFactory clientFactory) {
    this.clientFactory = clientFactory;
  }

  @Override
  public void start(AcceptsOneWidget container, EventBus eventBus) {
	CreateExpenseReportView view = clientFactory.getCreateExpenseReportView();
    view.setPresenter(this);
    container.setWidget(view.asWidget());
  }

  @Override
  public void goTo(Place place) {
    clientFactory.getPlaceController().goTo(place);
  }
}
