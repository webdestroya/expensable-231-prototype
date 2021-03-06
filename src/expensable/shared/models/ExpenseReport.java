package expensable.shared.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.view.client.ProvidesKey;

public class ExpenseReport implements NewsItem {

	private final List<ExpenseItem> expenseItems;

	private String id; //aka Tracking Id
	private String name;
	private Integer amount;
	private ExpenseType type;
	private Date createdDate;
	private String attachment;
	private String status;
	private Date submitted;
	private String department;
	private String batchId;

	public ExpenseReport() {
		expenseItems = new ArrayList<ExpenseItem>();
	}

	/**
	 * @return the id (Tracking Id)
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param the id (Tracking Id)
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the amount
	 */
	@Override
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	/**
	 * @return the type
	 */
	public ExpenseType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(ExpenseType type) {
		this.type = type;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public Date getLastModified() {
		return getCreatedDate();
	}

	/**
	 * @return the expenseItems
	 */
	public List<ExpenseItem> getExpenseItems() {
		return expenseItems;
	}

	/**
	 *
	 * @param the attachment
	 */
	public void setAttachment(String attachment){
		this.attachment = attachment;
	}

	/**
	 *
	 * @return the status
	 */
	public String getStatus(){
		return status;
	}

	/**
	 *
	 * @param the status
	 */
	public void setStatus(String status){
		this.status = status;
	}

	/**
	 *
	 * @return the attachment
	 */
	public String getAttachment(){
		return attachment;
	}

	/**
	 *
	 * @param submitted
	 */
	public void setSubmitted(Date submitted){
		this.submitted = submitted;
	}

	/**
	 *
	 * @return submitted
	 */
	public Date getSubmitted(){
		return submitted;
	}
	
	/**
	 *
	 * @param department
	 */
	public void setDepartment(String department){
		this.department = department;
	}

	/**
	 *
	 * @return department
	 */
	public String getDepartment(){
		return department;
	}
	
	/**
	 *
	 * @param Batch Id
	 */
	public void setBatchId(String batchId){
		this.batchId = batchId;
	}

	/**
	 *
	 * @return Batch Id
	 */
	public String getBatchId(){
		return batchId;
	}

	/**
	 * The key provider that provides the unique ID of a report.
	 */
	public static final ProvidesKey<ExpenseReport> KEY_PROVIDER = new ProvidesKey<ExpenseReport>() {

		@Override
		public Object getKey(ExpenseReport report) {
			return (report == null) ? null : report.getId();
		}

	};

}
