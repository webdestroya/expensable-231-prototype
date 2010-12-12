package expensable.client.activity.spotaudit;

import java.util.Date;
import java.util.List;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.ProvidesKey;

import expensable.client.ClientFactory;
import expensable.client.place.SpotAuditPlace;
import expensable.client.view.spotaudit.SpotAuditView;
import expensable.client.view.spotaudit.SpotAuditView.SpotAuditPresenter;
import expensable.shared.models.ExpenseReport;
import expensable.shared.models.ExpenseType;

public class ShowSpotAuditActivity extends AbstractActivity implements SpotAuditPresenter {

	/**
	 * The key provider that provides the unique ID of a report.
	 */
	public static final ProvidesKey<ExpenseReport> KEY_PROVIDER = new ProvidesKey<ExpenseReport>() {

		@Override
		public Object getKey(ExpenseReport report) {
			return (report == null) ? null : report.getId();
		}

	};

	/**
	 * The provider that holds the list of reports in the database.
	 */
	private final ListDataProvider<ExpenseReport> dataProvider; 	
	private ClientFactory clientFactory;

	public ShowSpotAuditActivity(SpotAuditPlace place, ClientFactory clientFactory) {
		this.dataProvider = new ListDataProvider<ExpenseReport>();
		this.clientFactory = clientFactory;
		stubReports(dataProvider.getList());
	}

	@Override
	public void start(AcceptsOneWidget container, EventBus eventBus) {
		SpotAuditView view = clientFactory.getSpotAuditView();
		view.setPresenter(this);
		container.setWidget(view.asWidget());
	}

	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}

	@Override
	public void onButtonClick(ClickEvent e) {
		Window.alert("button clicked!");
	}

	@Override
	public ProvidesKey<ExpenseReport> getKeyProvider() {
		return KEY_PROVIDER;
	}

	@Override
	public void addReportsDisplay(CellTable<ExpenseReport> reports) {
		dataProvider.addDataDisplay(reports);
	}

	@Override
	  public void refreshDisplays() {
	    dataProvider.refresh();
	  }
	
	@SuppressWarnings("deprecation") // Using deprecated date for quick stub
	private void stubReports(List<? super ExpenseReport> reports) {
		ExpenseReport report = new ExpenseReport();
		report.setStatus("Pending");
		report.setAmount(5623);
		report.setSubmitted(new Date(110, 5, 23));
		report.setBatchId("12345678");
		report.setId("BCR25723272");
		report.setName("Griffin, Brian");
		report.setDepartment("Accounting");
		reports.add(report);

		report = new ExpenseReport();
		report.setStatus("Approved");
		report.setAmount(2387);
		report.setSubmitted(new Date(110, 4, 13));
		report.setBatchId("35324521");
		report.setId("BCR25399991");
		report.setName("Griffin, Brian");
		report.setDepartment("Accounting");
		reports.add(report);

	    report = new ExpenseReport();
		report.setStatus("Approved");
		report.setAmount(8738);
		report.setSubmitted(new Date(110, 4, 13));
		report.setBatchId("35324521");
		report.setId("BCR25723277");
		report.setName("Griffin, Brian");
		report.setDepartment("Accounting");
		reports.add(report);

	}
}
