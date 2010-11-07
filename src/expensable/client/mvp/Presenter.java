package expensable.client.mvp;

import com.google.gwt.place.shared.Place;

/**
 * Presenter in the Model, View, Presenter (MVP) architecture.
 *  
 * @author dpurpura (David Purpura)
 */
public interface Presenter {
  
  void goTo(Place place);

}
