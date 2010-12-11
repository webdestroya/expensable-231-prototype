/**
 *
 */
package expensable.client.view.dashboard;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author dpurpura
 */
public class DashboardViewImpl extends Composite implements DashboardView {

  private static Binder binder = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, DashboardViewImpl>{}

  private DashboardPresenter presenter;

  @UiField NewsFeedView newsfeed;

  public DashboardViewImpl() {
    initWidget(binder.createAndBindUi(this));
  }

  @Override
  public void setPresenter(DashboardPresenter presenter) {
    this.presenter = presenter;
    newsfeed.clear();
    newsfeed.add(presenter.getNewsItems());
  }

}
