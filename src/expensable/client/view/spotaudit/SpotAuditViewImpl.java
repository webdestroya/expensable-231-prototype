package expensable.client.view.spotaudit;

import java.util.Date;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.SafeHtmlCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionModel;

import expensable.client.activity.expensereport.ShowExpenseReportsActivity;
import expensable.client.view.widget.Button;
import expensable.shared.models.ExpenseReport;

public class SpotAuditViewImpl extends Composite implements SpotAuditView {

	private static Binder binder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, SpotAuditViewImpl>{}

	@UiField ListBox statusType;
	@UiField ListBox employeeName;
	@UiField ListBox year;
	@UiField Button display;
	@UiField(provided = true) CellTable<ExpenseReport> reports;
	@UiField(provided = true) SimplePager pager;

	private SpotAuditPresenter presenter;

	public SpotAuditViewImpl() {
		reports = new CellTable<ExpenseReport>(ShowExpenseReportsActivity.KEY_PROVIDER);

		// Create a Pager to control the table.
		SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
		pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
		pager.setDisplay(reports);

		initWidget(binder.createAndBindUi(this));

		//Initializing the status type list box
		statusType.addItem("All");
		statusType.addItem("In Progress");
		statusType.addItem("Pending Approval");
		statusType.addItem("In Accounting Review");
		statusType.addItem("Apvd Pending Reciepts");
		statusType.addItem("Approved for Payment");
		statusType.addItem("Batched");
		statusType.addItem("Exported");
		statusType.addItem("Paid Reports");
		statusType.addItem("Rejected");

		//Initializing the select department list box
		employeeName.addItem("Select One");
		employeeName.addItem("Jean, Al");
		employeeName.addItem("Law, Dennis");
		employeeName.addItem("Rodney, Mike");

		//Initializing the list box for Years
		year.addItem("2010");
		year.addItem("2009");
	}

	@Override
	public void setPresenter(SpotAuditPresenter presenter) {
		this.presenter = presenter;
		
		 // Add a selection model so we can select cells.
	    final MultiSelectionModel<ExpenseReport> selectionModel
	        = new MultiSelectionModel<ExpenseReport>(presenter.getKeyProvider());
	    reports.setSelectionModel(selectionModel);
	    initTableColumns(selectionModel);
	    presenter.addReportsDisplay(reports);
	}

	private volatile int numCols = 0;

	private void initTableColumns(final SelectionModel<? super ExpenseReport> selectionModel){
		while (numCols-- > 0) {
			reports.removeColumn(0);
		}

		// Status
		Column<ExpenseReport, String> statusColumn
		= new Column<ExpenseReport, String>(new TextCell()) {
			@Override
			public String getValue(ExpenseReport report) {
				return report.getStatus();
			}
		};
		reports.addColumn(statusColumn, "Status");	  

		// Amount
		Column<ExpenseReport, Number> amountColumn
		= new Column<ExpenseReport, Number>(new NumberCell()) {
			@Override
			public Number getValue(ExpenseReport report) {
				return report.getAmount();
			}
		};
		reports.addColumn(amountColumn, "Amount");

		// Submitted
		Column<ExpenseReport, Date> submittedColumn
		= new Column<ExpenseReport, Date>(new DateCell()) {
			@Override
			public Date getValue(ExpenseReport report) {
				return report.getSubmitted();
			}
		};
		reports.addColumn(submittedColumn, "Submitted");	  

		// Batch Id
		Column<ExpenseReport, String> batchIdColumn
		= new Column<ExpenseReport, String>(new TextCell()) {
			@Override
			public String getValue(ExpenseReport report) {
				return report.getBatchId();
			}
		};
		reports.addColumn(batchIdColumn, "Batch Id");

		//  Tracking ID
		Column<ExpenseReport, SafeHtml> idColumn
		= new Column<ExpenseReport, SafeHtml>(new SafeHtmlCell()) {
			@Override
			public SafeHtml getValue(ExpenseReport report) {
				return new OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(
						"<a href=\"#reports:rid=1\">"+report.getId()+"</a>");
			}
		};
		reports.addColumn(idColumn, "Tracking Id");
		
		// Employee Name
		Column<ExpenseReport, String> nameColumn
		= new Column<ExpenseReport, String>(new TextCell()) {
			@Override
			public String getValue(ExpenseReport report) {
				return report.getName();
			}
		};
		reports.addColumn(nameColumn, "Employee Name");
		
		// Department Name
		Column<ExpenseReport, String> departmentColumn
		= new Column<ExpenseReport, String>(new TextCell()) {
			@Override
			public String getValue(ExpenseReport report) {
				return report.getDepartment();
			}
		};
		reports.addColumn(departmentColumn, "Department");
		
		numCols=7;
	}

}
