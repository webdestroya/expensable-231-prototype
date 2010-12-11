package expensable.client.activity.spotaudit;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import expensable.client.ClientFactory;
import expensable.client.place.SpotAuditPlace;
import expensable.client.view.spotaudit.SpotAuditView;
import expensable.client.view.spotaudit.SpotAuditView.SpotAuditPresenter;

public class ShowSpotAuditActivity extends AbstractActivity implements SpotAuditPresenter {

  private ClientFactory clientFactory;

  public ShowSpotAuditActivity(SpotAuditPlace place, ClientFactory clientFactory) {
    this.clientFactory = clientFactory;
  }

  @Override
  public void start(AcceptsOneWidget container, EventBus eventBus) {
    SpotAuditView view = clientFactory.getSpotAuditView();
    view.setPresenter(this);
    container.setWidget(view.asWidget());
  }

  @Override
  public void goTo(Place place) {
    clientFactory.getPlaceController().goTo(place);
  }
}
