package expensable.client.mvp;

import com.google.gwt.user.client.ui.IsWidget;

/**
 * View in the Model, View, Presenter (MVP) architecture.
 *
 * @author dpurpura (David Purpura)
 */
public interface View<P extends Presenter> extends IsWidget {

  void setPresenter(P presenter);

}
