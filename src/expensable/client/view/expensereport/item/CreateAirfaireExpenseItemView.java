package expensable.client.view.expensereport.item;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class CreateAirfaireExpenseItemView extends Composite implements CreateItemPanel {

  private static Binder uiBinder = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, CreateAirfaireExpenseItemView> {}

  public CreateAirfaireExpenseItemView() {
    initWidget(uiBinder.createAndBindUi(this));
  }

}
