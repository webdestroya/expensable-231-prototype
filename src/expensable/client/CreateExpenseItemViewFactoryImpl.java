package expensable.client;

import expensable.client.view.expensereport.item.CreateAirfaireExpenseItemView;

public class CreateExpenseItemViewFactoryImpl implements CreateExpenseItemViewFactory {

  // The following are lazily initialized
  private CreateAirfaireExpenseItemView airfaireView;

  @Override
  public CreateAirfaireExpenseItemView getCreateAirfaireExpenseItemView() {
    if (airfaireView == null) {
      airfaireView = new CreateAirfaireExpenseItemView();
    }
    return airfaireView;
  }

}
