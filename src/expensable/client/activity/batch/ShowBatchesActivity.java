package expensable.client.activity.batch;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import expensable.client.ClientFactory;
import expensable.client.place.BatchesPlace;
import expensable.client.view.batch.BatchesView;
import expensable.client.view.batch.BatchesView.BatchesPresenter;

public class ShowBatchesActivity extends AbstractActivity implements BatchesPresenter {

  private ClientFactory clientFactory;

  public ShowBatchesActivity(BatchesPlace place, ClientFactory clientFactory) {
    this.clientFactory = clientFactory;
  }

  @Override
  public void start(AcceptsOneWidget container, EventBus eventBus) {
    BatchesView view = clientFactory.getBatchesView();
    view.setPresenter(this);
    container.setWidget(view.asWidget());
  }

  @Override
  public void goTo(Place place) {
    clientFactory.getPlaceController().goTo(place);
  }
}
