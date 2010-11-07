package expensable.client.mvp;

import com.google.gwt.user.client.ui.IsWidget;

/**
 * View in the Model, View, Presenter (MVP) architecture.
 * 
 * @author dpurpura (David Purpura)
 */
public interface View extends IsWidget {
  
  void setPresenter(Presenter presenter);

}
