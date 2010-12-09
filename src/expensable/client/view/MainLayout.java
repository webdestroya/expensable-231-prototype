package expensable.client.view;

import com.google.gwt.resources.client.CssResource;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;

public interface MainLayout extends IsWidget, AcceptsOneWidget {

  public enum Tab {
    BATCHES,
    DASHBOARD,
    EXPENSE_REPORTS,
    SPOT_AUDIT;
  }

  interface Style extends CssResource {
    String selected();
  }

  /**
   * Sets the username to {@code text}.
   *
   * <p>The provided text will be escaped.
   *
   * @param text the text to display for the user name.
   */
  void setUserName(String text);

  /**
   * Selects the given tab.  No event is fired.
   *
   * @param tab the tab to select
   */
  void selectTab(Tab tab);

}
