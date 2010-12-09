package expensable.client.view.spotaudit;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class SpotAuditViewImpl extends Composite implements SpotAuditView {

  private static Binder binder = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, SpotAuditViewImpl>{}

  private SpotAuditPresenter presenter;

  public SpotAuditViewImpl() {
    initWidget(binder.createAndBindUi(this));
  }

  @Override
  public void setPresenter(SpotAuditPresenter presenter) {
    this.presenter = presenter;
  }

}
