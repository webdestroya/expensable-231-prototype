package expensable.client.activity.expensereport;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import expensable.client.ClientFactory;
import expensable.client.place.ExpenseReportsPlace;
import expensable.client.view.expensereport.item.CreateExpenseItemView;
import expensable.client.view.expensereport.item.CreateExpenseItemView.CreateExpenseItemPresenter;

public class ShowExpenseItemActivity extends AbstractActivity
    implements CreateExpenseItemPresenter {

  private final ExpenseReportsPlace place;
  private final ClientFactory clientFactory;

  public ShowExpenseItemActivity(ExpenseReportsPlace place, ClientFactory clientFactory) {
    this.place = place;
    this.clientFactory = clientFactory;
  }

  @Override
  public void start(AcceptsOneWidget container, EventBus eventBus) {
    CreateExpenseItemView view;
//    switch (place.getItemType()) {
//      // TODO(dpurpura): map other view types
//      case AIRFAIRE:
//        view = clientFactory.getCreateExpenseItemViewFactory().getCreateAirfaireExpenseItemView();
//        break;
//      case NULL_TYPE: // fall through to default
//      default:
//        view = clientFactory.getCreateExpenseItemViewFactory().getCreateAirfaireExpenseItemView();
//    }
//    view.setPresenter(this);
//    container.setWidget(view.asWidget());
    throw new UnsupportedOperationException("implement me!");
  }

  @Override
  public void goTo(Place p) {
    clientFactory.getPlaceController().goTo(p);
  }

}
