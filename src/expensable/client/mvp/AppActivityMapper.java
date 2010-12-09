package expensable.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

import expensable.client.ClientFactory;
import expensable.client.activity.dashboard.ShowDashboardActivity;
import expensable.client.activity.expensereport.ShowExpenseReportsActivity;
import expensable.client.place.BatchesPlace;
import expensable.client.place.DashboardPlace;
import expensable.client.place.ExpenseReportsPlace;
import expensable.client.place.SpotAuditPlace;

public class AppActivityMapper implements ActivityMapper {

  private ClientFactory clientFactory;

  /**
   * AppActivityMapper associates each Place with its corresponding
   * {@link Activity}.
   *
   * @param clientFactory Factory to be passed to activities
   */
  public AppActivityMapper(ClientFactory clientFactory) {
    super();
    this.clientFactory = clientFactory;
  }

  @Override
  public Activity getActivity(Place place) {
    // TODO(dpurpura): change this to use gin
    if (place instanceof BatchesPlace) {
      throw new UnsupportedOperationException("not implemented yet");
    } else if (place instanceof DashboardPlace) {
      return new ShowDashboardActivity((DashboardPlace) place, clientFactory);
    } else if (place instanceof ExpenseReportsPlace) {
      return new ShowExpenseReportsActivity((ExpenseReportsPlace) place, clientFactory);
    } else if (place instanceof SpotAuditPlace) {
      throw new UnsupportedOperationException("not implemented yet");
    } else {
      throw new IllegalArgumentException("Unknown place: " + place);
    }
  }

}
