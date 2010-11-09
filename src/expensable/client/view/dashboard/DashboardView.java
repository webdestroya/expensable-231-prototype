package expensable.client.view.dashboard;

import expensable.client.mvp.Presenter;
import expensable.client.mvp.View;
import expensable.client.view.dashboard.DashboardView.DashboardPresenter;

/**
 * @author dpurpura (David Purpura)
 */
public interface DashboardView extends View<DashboardPresenter> {

  public interface DashboardPresenter extends Presenter {}

}
