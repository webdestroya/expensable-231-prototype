package expensable.client.mvp;

import com.google.common.base.Strings;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

import expensable.client.ClientFactory;
import expensable.client.activity.batch.ShowBatchesActivity;
import expensable.client.activity.dashboard.ShowDashboardActivity;
import expensable.client.activity.expensereport.ShowExpenseItemActivity;
import expensable.client.activity.expensereport.ShowExpenseReportActivity;
import expensable.client.activity.expensereport.ShowExpenseReportsActivity;
import expensable.client.activity.spotaudit.ShowSpotAuditActivity;
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
      return new ShowBatchesActivity((BatchesPlace) place, clientFactory);
    } else if (place instanceof DashboardPlace) {
      System.out.println("dashboard");
      return new ShowDashboardActivity((DashboardPlace) place, clientFactory);
    } else if (place instanceof ExpenseReportsPlace) {
      ExpenseReportsPlace p = (ExpenseReportsPlace) place;
      if (Strings.isNullOrEmpty((p).getReportId())) {
        return new ShowExpenseReportsActivity(p, clientFactory);
      } else if (Strings.isNullOrEmpty(p.getItemId())) {
        return new ShowExpenseReportActivity(p, clientFactory);
      } else {
        return new ShowExpenseItemActivity(p, clientFactory);
      }
    } else if (place instanceof SpotAuditPlace) {
      System.out.println("we have a sa");

      return new ShowSpotAuditActivity((SpotAuditPlace) place, clientFactory);
    } else {
      throw new IllegalArgumentException("Unhandled place: " + place);
    }
  }

}
