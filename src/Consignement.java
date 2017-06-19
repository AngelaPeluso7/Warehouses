
public class Consignement {
		private int idConsignement;
		private Warehouse warehouse;
		private TypeProduct typeProduct;
		private StateConsignement stateConsignement;
		
		public Consignement(int idConsignement, Warehouse warehouse, TypeProduct typeProduct,
				StateConsignement stateConsignement) {
			this.idConsignement = idConsignement;
			this.warehouse = warehouse;
			this.typeProduct = typeProduct;
			this.stateConsignement = stateConsignement;
		}

		public int getIdConsignement() {
			return idConsignement;
		}

		public void setIdConsignement(int idConsignement) {
			this.idConsignement = idConsignement;
		}

		public Warehouse getWarehouse() {
			return warehouse;
		}

		public void setWarehouse(Warehouse warehouse) {
			this.warehouse = warehouse;
		}

		public TypeProduct getTypeProduct() {
			return typeProduct;
		}

		public void setTypeProduct(TypeProduct typeProduct) {
			this.typeProduct = typeProduct;
		}

		public StateConsignement getStateConsignement() {
			return stateConsignement;
		}

		public void setStateConsignement(StateConsignement stateConsignement) {
			this.stateConsignement = stateConsignement;
		}
		
}
