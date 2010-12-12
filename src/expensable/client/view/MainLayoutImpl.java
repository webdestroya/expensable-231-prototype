package expensable.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.UListElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public class MainLayoutImpl extends Composite implements MainLayout {

  private static Binder uiBinder = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, MainLayoutImpl> {}

  @UiField Style style;
  @UiField SpanElement username;
  @UiField UListElement tabs;
  @UiField LIElement dashboard;
  @UiField LIElement reports;
  @UiField LIElement spotAudit;
  @UiField LIElement batches;
  @UiField HasWidgets content;

  public MainLayoutImpl() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  @Override
  public Widget asWidget() {
    return this;
  }

  @Override
  public void setWidget(IsWidget w) {
    if (w == null) return;
    content.clear();
    content.add(w.asWidget());
  }

  @Override
  public void selectTab(Tab tab) {
    for (int i = 0; i < tabs.getChildCount(); i++) {
      Node n = tabs.getChild(i);
      if (n instanceof LIElement) {
        LIElement li = ((LIElement) n);
        if (li.getClassName() != null
            && !li.getClassName().isEmpty()
            && li.getClassName().contains(style.selected())) {
          li.removeClassName(style.selected());
        }
      }
    }

    LIElement li;
    switch(tab) {
      case BATCHES:         li = batches;   break;
      case DASHBOARD:       li = dashboard; break;
      case EXPENSE_REPORTS: li = reports;   break;
      case SPOT_AUDIT:      li = spotAudit; break;
      default: throw new UnsupportedOperationException("unhandled tab: " + tab);
    }
    System.out.println(li.getNodeValue());
    li.addClassName(style.selected());
  }

  public HasWidgets getContent() {
    return content;
  }

  public String getUserName() {
    return username.getInnerText();
  }

  @Override
  public void setUserName(String username) {
    this.username.setInnerText(username);
  }

}
