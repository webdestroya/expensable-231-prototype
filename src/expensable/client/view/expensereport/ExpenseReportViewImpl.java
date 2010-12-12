package expensable.client.view.expensereport;

import java.util.Date;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionModel;

import expensable.client.activity.expensereport.ShowExpenseReportActivity;
import expensable.shared.models.ExpenseItem;

public class ExpenseReportViewImpl extends Composite implements ExpenseReportView {

  private static Binder uiBinder = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, ExpenseReportViewImpl> {
  }

  @UiField(provided = true) CellTable<ExpenseItem> reports;


  private ExpenseReportPresenter presenter;

  public ExpenseReportViewImpl() {
    reports = new CellTable<ExpenseItem>(ShowExpenseReportActivity.KEY_PROVIDER);


    initWidget(uiBinder.createAndBindUi(this));


  }

  @Override
  public void setPresenter(ExpenseReportPresenter presenter) {
    this.presenter = presenter;

    // Add a selection model so we can select cells.
    final MultiSelectionModel<ExpenseItem> selectionModel
        = new MultiSelectionModel<ExpenseItem>(presenter.getKeyProvider());
    reports.setSelectionModel(selectionModel);
    initTableColumns(selectionModel);
    presenter.addReportsDisplay(reports);
  }

  @Override
  public CellTable<ExpenseItem> getReportsTable() {
    return reports;
  }

  private volatile int numCols = 0; // TODO(dpurpura): get this from table somehow

  /**
   * Add the columns to the table.
   */
  private void initTableColumns(final SelectionModel<? super ExpenseItem> selectionModel) {
    while (numCols-- > 0) {
      reports.removeColumn(0);
    }

    // Checkbox column. This table will uses a checkbox column for selection.
    // Alternatively, you can call reports.setSelectionEnabled(true) to enable
    // mouse selection.
    Column<ExpenseItem, Boolean> checkColumn
        = new Column<ExpenseItem, Boolean>(new CheckboxCell(true)) {
      @Override
      public Boolean getValue(ExpenseItem object) {
        return selectionModel.isSelected(object);
      }
    };
    checkColumn.setFieldUpdater(new FieldUpdater<ExpenseItem, Boolean>() {
      @Override
      public void update(int index, ExpenseItem object, Boolean value) {
        // Called when the user clicks on a checkbox.
        selectionModel.setSelected(object, value);
      }
    });
    reports.addColumn(checkColumn, SafeHtmlUtils.fromSafeConstant("<br>"));

    // Created date
    Column<ExpenseItem, Date> createdDateColumn
        = new Column<ExpenseItem, Date>(new DateCell()) {
      @Override
      public Date getValue(ExpenseItem report) {
        return report.getPurchaseDate();
      }
    };
    reports.addColumn(createdDateColumn, "Date Entered");

    // Amount
    Column<ExpenseItem, Number> amountColumn
        = new Column<ExpenseItem, Number>(new NumberCell()) {
      @Override
      public Number getValue(ExpenseItem report) {
        return report.getAmount();
      }
    };
    reports.addColumn(amountColumn, "Amount");

    // Employee Name
    Column<ExpenseItem, String> nameColumn
        = new Column<ExpenseItem, String>(new TextCell()) {
      @Override
      public String getValue(ExpenseItem report) {
        return report.getName();
      }
    };
    reports.addColumn(nameColumn, "Type");


    // Attachment
    Column<ExpenseItem, String> attachmentColumn
        = new Column<ExpenseItem, String>(new TextCell()) {
      @Override
      public String getValue(ExpenseItem report) {
        return report.getMerchant();
      }
    };
    reports.addColumn(attachmentColumn, "Location");

    numCols = 6;
  }

}
