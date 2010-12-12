package expensable.client.activity.expensereport;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import expensable.client.ClientFactory;
import expensable.client.place.CreateExpenseItemPlace;
import expensable.client.view.expensereport.item.CreateExpenseItemView;
import expensable.client.view.expensereport.item.CreateExpenseItemView.CreateExpenseItemPresenter;

public class CreateExpenseItemActivity extends AbstractActivity
    implements CreateExpenseItemPresenter {

  private ClientFactory clientFactory;

  public CreateExpenseItemActivity(CreateExpenseItemPlace place, ClientFactory clientFactory) {
    this.clientFactory = clientFactory;
  }

  @Override
  public void start(AcceptsOneWidget container, EventBus eventBus) {
    CreateExpenseItemView view = clientFactory.getCreateExpenseItemView();
    view.setPresenter(this);
    container.setWidget(view.asWidget());
  }

  @Override
  public void goTo(Place place) {
    clientFactory.getPlaceController().goTo(place);
  }
}