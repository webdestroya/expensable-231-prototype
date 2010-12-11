package expensable.client.view.batch;

import java.util.Date;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.DatePickerCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.SafeHtmlCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionModel;

import expensable.shared.models.ExpenseReport;

public class BatchViewImpl extends Composite implements BatchView {

  private static Binder uiBinder = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, BatchViewImpl> {
  }

  @UiField HeadingElement batchName;
  @UiField(provided = true) final CellTable<ExpenseReport> reports;
  /*@UiField(provided = true)*/ SimplePager pager;

  private BatchPresenter presenter;


  public BatchViewImpl() {
    reports = new CellTable<ExpenseReport>(ExpenseReport.KEY_PROVIDER);

    // Create a Pager to control the table.
    SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
    pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
    pager.setDisplay(reports);
    initWidget(uiBinder.createAndBindUi(this));
  }

  @Override
  public void setPresenter(BatchPresenter presenter) {
    this.presenter = presenter;

    // Add a selection model so we can select cells.
    final MultiSelectionModel<ExpenseReport> selectionModel
        = new MultiSelectionModel<ExpenseReport>(presenter.getKeyProvider());
    reports.setSelectionModel(selectionModel);
    initTableColumns(selectionModel);
    //batchName.setInnerText(presenter.getBatchName());
    batchName.setInnerText("November Billing");
    presenter.addReportsDisplay(reports);
  }

  private volatile int numCols = 0; // TODO(dpurpura): get this from table somehow

  /**
   * Add the columns to the table.
   */
  private void initTableColumns(final SelectionModel<? super ExpenseReport> selectionModel) {
    while (numCols-- > 0) {
      reports.removeColumn(0);
    }

    // Checkbox column. This table will uses a checkbox column for selection.
    // Alternatively, you can call reports.setSelectionEnabled(true) to enable
    // mouse selection.
    Column<ExpenseReport, Boolean> checkColumn
        = new Column<ExpenseReport, Boolean>(new CheckboxCell(true)) {
      @Override
      public Boolean getValue(ExpenseReport object) {
        return selectionModel.isSelected(object);
      }
    };
    checkColumn.setFieldUpdater(new FieldUpdater<ExpenseReport, Boolean>() {
      @Override
      public void update(int index, ExpenseReport object, Boolean value) {
        // Called when the user clicks on a checkbox.
        selectionModel.setSelected(object, value);
      }
    });
    reports.addColumn(checkColumn, SafeHtmlUtils.fromSafeConstant("<br/>"));

    // Name
    Column<ExpenseReport, SafeHtml> nameColumn
        = new Column<ExpenseReport, SafeHtml>(new SafeHtmlCell()) {
      @Override
      public SafeHtml getValue(ExpenseReport report) {
        return new OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(
            "<a href=\"#reports:rid=12345\">"+report.getName()+"</a>");
      }
    };
    reports.addColumn(nameColumn, "Name");

    // Created date
    Column<ExpenseReport, Date> createdDateColumn
        = new Column<ExpenseReport, Date>(new DatePickerCell(
            DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT))) {
      @Override
      public Date getValue(ExpenseReport report) {
        return report.getCreatedDate();
      }
    };
    reports.addColumn(createdDateColumn, "Created Date");

    // Amount
    Column<ExpenseReport, Number> amountColumn
        = new Column<ExpenseReport, Number>(new NumberCell()) {
      @Override
      public Number getValue(ExpenseReport report) {
        return report.getAmount();
      }
    };
    reports.addColumn(amountColumn, "Amount");
    amountColumn.setFieldUpdater(new FieldUpdater<ExpenseReport, Number>() {
      @Override
      public void update(int index, ExpenseReport report, Number value) {
        // Called when the user changes the value.
        report.setAmount(value.intValue());
        presenter.refreshDisplays();
      }
    });

    numCols = 4;
  }

}
