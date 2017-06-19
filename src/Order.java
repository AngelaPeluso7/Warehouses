
public class Order {
	private int idOrder;
	private TypeProduct typeProduct1;
	private Consignement consignement1;
	private TypeProduct typeProduct2;
	private Consignement consignement2;
	
	public Order(int idOrder, TypeProduct typeProduct1, Consignement consignement1, TypeProduct typeProduct2,
			Consignement consignement2) {
		this.idOrder = idOrder;
		this.typeProduct1 = typeProduct1;
		this.consignement1 = consignement1;
		this.typeProduct2 = typeProduct2;
		this.consignement2 = consignement2;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public TypeProduct getTypeProduct1() {
		return typeProduct1;
	}

	public void setTypeProduct1(TypeProduct typeProduct1) {
		this.typeProduct1 = typeProduct1;
	}

	public Consignement getConsignement1() {
		return consignement1;
	}

	public void setConsignement1(Consignement consignement1) {
		this.consignement1 = consignement1;
	}

	public TypeProduct getTypeProduct2() {
		return typeProduct2;
	}

	public void setTypeProduct2(TypeProduct typeProduct2) {
		this.typeProduct2 = typeProduct2;
	}

	public Consignement getConsignement2() {
		return consignement2;
	}

	public void setConsignement2(Consignement consignement2) {
		this.consignement2 = consignement2;
	}
	
	
}
