package expensable.client.view.dashboard;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

import expensable.shared.models.NewsItem;

public class NewsFeedView extends Composite {

  private static Binder uiBinder = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, NewsFeedView> {
  }

  @UiField FlowPanel panel;

  public NewsFeedView() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  public NewsFeedView(List<NewsItem> items) {
    this();
    add(items);
  }

  public void add(List<NewsItem> items) {
    for (NewsItem item : items) {
      panel.add(new NewsItemView(item));
    }
  }

  public void clear() {
    panel.clear();
  }

}
