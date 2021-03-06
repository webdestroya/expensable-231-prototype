package expensable.client.view.expensereport.item;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class CreateHotelExpenseItemView extends Composite implements CreateItemPanel {

  private static Binder uiBinder = GWT
      .create(Binder.class);

  interface Binder extends UiBinder<Widget, CreateHotelExpenseItemView> {
  }

  public CreateHotelExpenseItemView() {
    initWidget(uiBinder.createAndBindUi(this));
  }


  public CreateHotelExpenseItemView(String firstName) {
    initWidget(uiBinder.createAndBindUi(this));
    
  }

}
