package expensable.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

import expensable.client.mvp.AppActivityMapper;
import expensable.client.mvp.AppPlaceHistoryMapper;
import expensable.client.place.DashboardPlace;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ExpensableEntryPoint implements EntryPoint {
  
  private Place defaultPlace = new DashboardPlace("id:123");
  private SimplePanel appWidget = new SimplePanel();
 
   /**
   * This is the entry point method.
   */
  @Override
  public void onModuleLoad() {
    // Create ClientFactory using deferred binding so we can replace with different
    // impls in gwt.xml
    ClientFactory clientFactory = GWT.create(ClientFactory.class);
    EventBus eventBus = clientFactory.getEventBus();
    PlaceController placeController = clientFactory.getPlaceController();

    // Start ActivityManager for the main widget with our ActivityMapper
    ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
    ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
    appWidget.setWidth("300px");
    appWidget.setStyleName("test");
    activityManager.setDisplay(appWidget);

    // Start PlaceHistoryHandler with our PlaceHistoryMapper
    AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
    PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
    historyHandler.register(placeController, eventBus, defaultPlace);

    RootPanel.get().add(appWidget);
    // Goes to place represented on URL or default place
    historyHandler.handleCurrentHistory();
  }
}
