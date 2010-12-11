package expensable.client.activity.dashboard;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import expensable.client.ClientFactory;
import expensable.client.activity.batch.ShowBatchesActivity;
import expensable.client.activity.expensereport.ShowExpenseReportsActivity;
import expensable.client.place.DashboardPlace;
import expensable.client.view.dashboard.DashboardView;
import expensable.client.view.dashboard.DashboardView.DashboardPresenter;
import expensable.shared.models.NewsItem;

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

  @Override
  public List<NewsItem> getNewsItems() {
    List<NewsItem> items = Lists.newArrayList();
    ShowBatchesActivity.stubBatches(items);
    ShowExpenseReportsActivity.stubReports(items);
    Collections.sort(items, new Comparator<NewsItem>() {
      @Override
      public int compare(NewsItem item1, NewsItem item2) {
        return item1.getLastModified().compareTo(item2.getLastModified());
      }
    });
    return items;
  }

}
