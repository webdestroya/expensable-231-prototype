package expensable.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

import expensable.client.ClientFactory;
import expensable.client.activity.dashboard.ShowDashboardActivity;
import expensable.client.activity.report.ShowExpenseReportActivity;
import expensable.client.place.DashboardPlace;
import expensable.client.place.ExpenseReportsPlace;

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
    if (place instanceof DashboardPlace) {
      return new ShowDashboardActivity((DashboardPlace) place, clientFactory);
    } else if (place instanceof ExpenseReportsPlace) {
      return new ShowExpenseReportActivity((ExpenseReportsPlace) place, clientFactory);
    } else {
      return null;
    }
  }

}
