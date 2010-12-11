package expensable.client.view.dashboard;

import java.util.List;

import expensable.client.mvp.Presenter;
import expensable.client.mvp.View;
import expensable.client.view.dashboard.DashboardView.DashboardPresenter;
import expensable.shared.models.NewsItem;

/**
 * @author dpurpura (David Purpura)
 */
public interface DashboardView extends View<DashboardPresenter> {

  public interface DashboardPresenter extends Presenter {
    List<NewsItem> getNewsItems();
  }

}
