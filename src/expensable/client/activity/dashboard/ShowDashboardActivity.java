package expensable.client.activity.dashboard;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import expensable.client.ClientFactory;
import expensable.client.place.DashboardPlace;
import expensable.client.view.dashboard.DashboardView;
import expensable.client.view.dashboard.DashboardView.DashboardPresenter;

public class ShowDashboardActivity extends AbstractActivity implements DashboardPresenter {

  private ClientFactory clientFactory;

  public ShowDashboardActivity(DashboardPlace place, ClientFactory clientFactory) {
    this.clientFactory = clientFactory;
  }

  @Override
  public void start(AcceptsOneWidget container, EventBus eventBus) {
    DashboardView view = clientFactory.getDashboardView();
    view.setPresenter(this);
    container.setWidget(view.asWidget());
  }

  @Override
  public void goTo(Place place) {
    clientFactory.getPlaceController().goTo(place);
  }

}
