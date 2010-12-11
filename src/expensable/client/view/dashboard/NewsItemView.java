package expensable.client.view.dashboard;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import expensable.shared.models.NewsItem;

public class NewsItemView extends Composite {

  private static Binder uiBinder = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, NewsItemView> {
  }

  @UiField HeadingElement name;
  @UiField SpanElement date;

  public NewsItemView() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  public NewsItemView(NewsItem item) {
    initWidget(uiBinder.createAndBindUi(this));
    name.setInnerText(item.getName());
    date.setInnerText(
        DateTimeFormat.getFormat(PredefinedFormat.DATE_MEDIUM).format(item.getLastModified()));
  }

}
