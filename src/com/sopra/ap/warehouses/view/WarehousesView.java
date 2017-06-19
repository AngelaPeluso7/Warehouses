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
					
					// Loading Warehouse DB
					warehouseData = new WarehouseData();
					warehouseController = new WarehouseController();
					List<WarehouseData> warehouses = new ArrayList<WarehouseData>();
					warehouses = warehouseController.getAll();
					for(int i = 0; i < warehouses.size(); i++) {
					    System.out.print("Warehouse: "+warehouses.get(i).getIdWarehouse()+" ");
					    System.out.println("MaxSize: "+warehouses.get(i).getMaxSize());
					}
					// Loading Order DB
					orderData = new OrderData();
					orderController = new OrderController();
					List<OrderData> orders = new ArrayList<OrderData>();
					orders = orderController.getAll();

					// Loading Invoice DB
					invoiceData = new InvoiceData();
					invoiceController = new InvoiceController();
					List<InvoiceData> invoices = new ArrayList<InvoiceData>();
					invoices = invoiceController.getAll();

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
					
						//Creating 2 Consignements 
						int idConsignement1=idConsignement+1;
						idConsignement++;
						ConsignementData consignementData1=new ConsignementData(idConsignement1,warehouseFound1,typeProduct1.toString(),stateConsignement1.toString());
						consignementController.newConsignement(consignementData1);
						//System.out.println(consignementController.newConsignementEsit(consignementData1));//Cannot add or update a child row: a foreign key constraint fails (`warehouses`.`consignement`, CONSTRAINT `consignement_ibfk_1` FOREIGN KEY (`idWarehouse`) REFERENCES `inventory` (`idWarehouse`))
						consignements.add(consignementData1);
						int idConsignement2=idConsignement+1;
						idConsignement++;
						ConsignementData consignementData2=new ConsignementData(idConsignement1,warehouseFound2,typeProduct2.toString(),stateConsignement2.toString());
						consignementController.newConsignement(consignementData2);
						consignements.add(consignementData2);
						//System.out.println(consignementController.newConsignementEsit(consignementData2));
					
						//Creating order
						int idOrder=orders.size()+1;
						OrderData orderData=new OrderData(idOrder,typeProduct1.toString(),idConsignement1,typeProduct2.toString(),idConsignement2);
						orderController.newOrder(orderData);
						System.out.println(orderController.newOrderEsit(orderData));
						orders.add(orderData);
					
						//Creating invoice
						int idInvoice=invoices.size()+1;
						StateOrder stateOrder;
						if(stateConsignement1.equals("AVAIABLE") && stateConsignement2.equals("AVAIABLE")){
							stateOrder=StateOrder.SHIPPED;
						}
						else  {
							stateOrder=StateOrder.CANCELED;
						}
						InvoiceData invoiceData=new InvoiceData(idInvoice,idOrder,stateOrder.toString());
						invoiceController.newInvoice(invoiceData);
						System.out.println(invoiceController.newInvoiceEsit(invoiceData));
						invoices.add(invoiceData);
						
						//Decrementing quantities in inventory if they are avaiable
						if(stateConsignement1.equals("AVAIABLE") && stateConsignement2.equals("AVAIABLE")){
						
							inventoryController.decrementQuantity(typeProduct1.toString(), warehouseFound1);
							inventoryController.decrementQuantityShow(typeProduct1.toString(), warehouseFound1);
						
							inventoryController.decrementQuantity(typeProduct2.toString(), warehouseFound2);
							inventoryController.decrementQuantityShow(typeProduct2.toString(), warehouseFound2);
						}
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
				System.out.println("ERROR!!!\n");
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
