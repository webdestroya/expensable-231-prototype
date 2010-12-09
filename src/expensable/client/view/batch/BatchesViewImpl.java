package expensable.client.view.batch;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class BatchesViewImpl extends Composite implements BatchesView {

  private static Binder binder = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, BatchesViewImpl>{}

  private BatchesPresenter presenter;

  public BatchesViewImpl() {
    initWidget(binder.createAndBindUi(this));
  }

  @Override
  public void setPresenter(BatchesPresenter presenter) {
    this.presenter = presenter;
  }

}
