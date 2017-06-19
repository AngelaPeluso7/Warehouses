package com.sopra.ap.warehouses.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sopra.ap.warehouses.controllers.ConsignementController;
import com.sopra.ap.warehouses.controllers.InventoryController;
import com.sopra.ap.warehouses.controllers.InvoiceController;
import com.sopra.ap.warehouses.controllers.OrderController;
import com.sopra.ap.warehouses.controllers.WarehouseController;
import com.sopra.ap.warehouses.data.ConsignementData;
import com.sopra.ap.warehouses.data.InventoryData;
import com.sopra.ap.warehouses.data.InvoiceData;
import com.sopra.ap.warehouses.data.OrderData;
import com.sopra.ap.warehouses.data.WarehouseData;
import com.sopra.ap.warehouses.models.StateConsignement;
import com.sopra.ap.warehouses.models.StateOrder;
import com.sopra.ap.warehouses.models.TypeProduct;

public class WarehousesView {

	private static WarehouseController warehouseController;
	private static WarehouseData warehouseData;
	private static OrderController orderController;
	private static OrderData orderData;
	private static InvoiceController invoiceController;
	private static InvoiceData invoiceData;
	private static InventoryController inventoryController;
	private static InventoryData inventoryData;
	private static ConsignementController consignementController;
	private static ConsignementData consignementData;

	public static void main(String[] args) {
		// Loading Warehouse DB
		warehouseData = new WarehouseData();
		warehouseController = new WarehouseController();
		List<WarehouseData> warehouses = new ArrayList<WarehouseData>();
		warehouses = warehouseController.getAll();
		for(int i = 0; i < warehouses.size(); i++) {
		    System.out.print("Warehouse: "+warehouses.get(i).getIdWarehouse()+" ");
		    System.out.println("MaxSize: "+warehouses.get(i).getMaxSize());
		}
		
		Scanner scan = new Scanner(System.in);
		String choise;
		String menu = "***Warehouses*** SCEGLI L'OPERAZIONE DA ESEGUIRE E INSERISCI IL NUMERO CORRISPONDENTE:\n"
				+ "1) Genera Nuovo Ordine\n" + "2) Chiudi applicazione\n";
		do {
			System.out.println(menu);
			choise = scan.nextLine();
			if ((choise.length() == 1) && (Integer.parseInt(choise)==1 || Integer.parseInt(choise)==2)) {
				switch (Integer.parseInt(choise)) {
				case 1: {
					System.out.println("***Genera Nuovo Ordine***");
					
					// Loading Order DB
					orderData = new OrderData();
					orderController = new OrderController();
					List<OrderData> orders = new ArrayList<OrderData>();
					orders = orderController.getAll();
					int idOrder=orders.size();

					// Loading Invoice DB
					invoiceData = new InvoiceData();
					invoiceController = new InvoiceController();
					List<InvoiceData> invoices = new ArrayList<InvoiceData>();
					invoices = invoiceController.getAll();
					int idInvoice=invoices.size()+1;

					// Loading Inventory DB
					inventoryData = new InventoryData();
					inventoryController = new InventoryController();
					List<InventoryData> inventories = new ArrayList<InventoryData>();
					inventories = inventoryController.getAll();
				
					// Loading Consignement DB
					consignementData = new ConsignementData();
					consignementController = new ConsignementController();
					List<ConsignementData> consignements = new ArrayList<ConsignementData>();
					consignements = consignementController.getAll();
					int idConsignement=consignements.size();
					
					//Generating casual Order
					TypeProduct typeProduct1 = TypeProduct.values()[(int)(Math.random()*(TypeProduct.values().length))];
					TypeProduct typeProduct2 = TypeProduct.values()[(int)(Math.random()*(TypeProduct.values().length))];
					System.out.println("Il nuovo ordine è composto da questi due prodotti: "+typeProduct1+" e "+typeProduct2);
					
						//Searching Products
						int warehouseFound1=0;
						StateConsignement stateConsignement1 = null;
						if (inventoryController.searchProduct(typeProduct1.toString(), 1)){
							warehouseFound1=1;
							stateConsignement1=StateConsignement.AVAIABLE;
							System.out.println(inventoryController.searchProductShow(typeProduct1.toString(), 1));
						}
						else if(inventoryController.searchProduct(typeProduct1.toString(), 2)){
							warehouseFound1=2;
							stateConsignement1=StateConsignement.AVAIABLE;
							System.out.println(inventoryController.searchProductShow(typeProduct1.toString(),2));
						}
						else {
							stateConsignement1=StateConsignement.UNAVAIABLE;
							System.out.println("Il prodotto "+typeProduct1+" NON è presente in nessuna Warehouse ");
						}
						int warehouseFound2=0;
						StateConsignement stateConsignement2 = null;
						if (inventoryController.searchProduct(typeProduct2.toString(), 1)){
							warehouseFound2=1;
							stateConsignement2=StateConsignement.AVAIABLE;
							System.out.println(inventoryController.searchProductShow(typeProduct2.toString(), 1));
						}
						else if(inventoryController.searchProduct(typeProduct2.toString(), 2)){
							warehouseFound2=2;
							stateConsignement2=StateConsignement.AVAIABLE;
							System.out.println(inventoryController.searchProductShow(typeProduct2.toString(), 2));
						}
						else {
							stateConsignement2=StateConsignement.UNAVAIABLE;
							System.out.println("Il prodotto "+typeProduct2+" NON è presente in nessuna Warehouse ");
						}
						System.out.println("");
					
						//Creating 2 Consignements 
						int idConsignement1=idConsignement+1;
						idConsignement++;
						ConsignementData consignementData1=new ConsignementData(idConsignement1,warehouseFound1,typeProduct1.name(),stateConsignement1.name());
						if(consignementController.newConsignement(consignementData1)){
							System.out.println("La consignement 1 è stata creata");
						}
						//System.out.println(consignementController.newConsignementEsit(consignementData1));//Cannot add or update a child row: a foreign key constraint fails (`warehouses`.`consignement`, CONSTRAINT `consignement_ibfk_1` FOREIGN KEY (`idWarehouse`) REFERENCES `inventory` (`idWarehouse`))
						consignements.add(consignementData1);
						int idConsignement2=idConsignement+1;
						idConsignement++;
						ConsignementData consignementData2=new ConsignementData(idConsignement2,warehouseFound2,typeProduct2.name(),stateConsignement2.name());
						if(consignementController.newConsignement(consignementData2)){
							System.out.println("La consignement 2 è stata creata");
							System.out.println("");
						}
						consignements.add(consignementData2);
						//System.out.println(consignementController.newConsignementEsit(consignementData2));
						for(int i = consignements.size()-2; i < consignements.size(); i++) {
						    System.out.print("Consignement: "+consignements.get(i).getIdConsignement()+" ");
						    System.out.print("Warehouse: "+consignements.get(i).getWarehouse()+" ");
						    System.out.print("Type Product: "+consignements.get(i).getTypeProduct()+" ");
						    System.out.println("State Consignement: "+consignements.get(i).getStateConsignement()+" ");
						}
						System.out.println("");
						
						//Creating order
						idOrder++;
						OrderData orderData=new OrderData(idOrder,typeProduct1.name(),idConsignement1,typeProduct2.name(),idConsignement2);
						if(orderController.newOrder(orderData)){
							System.out.println("L'ordine è stato creato:");
						}
						//System.out.println(orderController.newOrderEsit(orderData));
						orders.add(orderData);
						for(int i = orders.size()-1; i < orders.size(); i++) {
						    System.out.print("Order: "+orders.get(i).getIdOrder()+" ");
						    System.out.print("Type Product 1: "+orders.get(i).getTypeProduct1()+" ");
						    System.out.print("Consignement 1: "+orders.get(i).getConsignement1()+" ");
						    System.out.print("Type Product 2: "+orders.get(i).getTypeProduct2()+" ");
						    System.out.println("Consignement 2: "+orders.get(i).getConsignement2()+" ");
						}
						System.out.println("");
						
					
						//Creating invoice
						StateOrder stateOrder=null;
						if((stateConsignement1.name()).equals("AVAIABLE") && (stateConsignement2.name()).equals("AVAIABLE")){
							stateOrder=StateOrder.SHIPPED;
						}
						else  {
							stateOrder=StateOrder.CANCELED;
						}
						InvoiceData invoiceData=new InvoiceData(idInvoice,idOrder,stateOrder.name());
						if(invoiceController.newInvoice(invoiceData)){
							System.out.println("L'invoice è stato creato:");
						}
						//System.out.println(invoiceController.newInvoiceEsit(invoiceData));
						invoices.add(invoiceData);
						for(int i = invoices.size()-1; i < invoices.size(); i++) {
						    System.out.print("Invoice: "+invoices.get(i).getIdInvoice()+" ");
						    System.out.print("Order: "+invoices.get(i).getIdInvoice()+" ");
						    System.out.println("Sate Order: "+invoices.get(i).getStateOrder()+" ");
						}
						System.out.println("");
						idInvoice++;
						
						//Decrementing quantities in inventory if they are avaiable
						if((stateConsignement1.name()).equals("AVAIABLE") && (stateConsignement2.name()).equals("AVAIABLE")){
							if (inventoryController.decrementQuantity(typeProduct1.name(), warehouseFound1))
							System.out.println("Il prodotto "+typeProduct1+" è stato decrementato nell'inventario del warehouse "+warehouseFound1);
							if (inventoryController.decrementQuantity(typeProduct2.name(), warehouseFound2))
								System.out.println("Il prodotto "+typeProduct2+" è stato decrementato nell'inventario del warehouse "+warehouseFound2);
						}
						System.out.println("");
					}
				
				
					break;
				case 2:
					System.out.println("***Chiudi applicazione***");
					break;
				default:
					System.out.println("Scelta errata!");
					break;
				}
			} else {
				System.out.println("INSERT ERROR!!!\n");
			}
		}while(Integer.parseInt(choise)!=2);System.out.println("Arrivederci!");scan.close();

	}

	public WarehouseController getWarehouseController() {
		return warehouseController;
	}

	public void setWarehouseController(WarehouseController warehouseController) {
		WarehousesView.warehouseController = warehouseController;
	}

	public static WarehouseData getWarehouseData() {
		return warehouseData;
	}

	public static void setWarehouseData(WarehouseData warehouseData) {
		WarehousesView.warehouseData = warehouseData;
	}

	public static OrderController getOrderController() {
		return orderController;
	}

	public static void setOrderController(OrderController orderController) {
		WarehousesView.orderController = orderController;
	}

	public static OrderData getOrderData() {
		return orderData;
	}

	public static void setOrderData(OrderData orderData) {
		WarehousesView.orderData = orderData;
	}

	public static InvoiceController getInvoiceController() {
		return invoiceController;
	}

	public static void setInvoiceController(InvoiceController invoiceController) {
		WarehousesView.invoiceController = invoiceController;
	}

	public static InvoiceData getInvoiceData() {
		return invoiceData;
	}

	public static void setInvoiceData(InvoiceData invoiceData) {
		WarehousesView.invoiceData = invoiceData;
	}

	public static InventoryController getInventoryController() {
		return inventoryController;
	}

	public static void setInventoryController(InventoryController inventoryController) {
		WarehousesView.inventoryController = inventoryController;
	}

	public static InventoryData getInventoryData() {
		return inventoryData;
	}

	public static void setInventoryData(InventoryData inventoryData) {
		WarehousesView.inventoryData = inventoryData;
	}

	public static ConsignementController getConsignementController() {
		return consignementController;
	}

	public static void setConsignementController(ConsignementController consignementController) {
		WarehousesView.consignementController = consignementController;
	}

	public static ConsignementData getConsignementData() {
		return consignementData;
	}

	public static void setConsignementData(ConsignementData consignementData) {
		WarehousesView.consignementData = consignementData;
	}

}
