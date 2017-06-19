
public class Invoice {
	private int idInvoice;
	private Order order;
	private StateOrder stateOrder;
	
	public Invoice(int idInvoice, Order order, StateOrder stateOrder) {
		this.idInvoice = idInvoice;
		this.order = order;
		this.stateOrder = stateOrder;
	}

	public int getIdInvoice() {
		return idInvoice;
	}

	public void setIdInvoice(int idInvoice) {
		this.idInvoice = idInvoice;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public StateOrder getStateOrder() {
		return stateOrder;
	}

	public void setStateOrder(StateOrder stateOrder) {
		this.stateOrder = stateOrder;
	}
	
}
