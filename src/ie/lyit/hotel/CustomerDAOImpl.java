package ie.lyit.hotel;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerDAOImpl implements CustomerDAO 
{
	//List is working as a database
	List<Customer> customers;
	
	public CustomerDAOImpl()
	{
		customers = new ArrayList<Customer>();
		Customer customer1 = new Customer("Mr", "Rory", "Friel", "Clonblosk", "08612345678", "Roryfriel@yahoo.com");
		Customer customer2 = new Customer("Mr", "James", "Friel", "Clonblosk", "0869876543", "Jamesfriel@yahoo.com");	
		Customer customer3 = new Customer("Mr", "John", "Doherty", "Buncrana", "0865654645", "JohnDoherty@yahoo.com");
		Customer customer4 = new Customer("Mr", "Mark", "McLaughlin", "Cockhill", "08636564543", "MarkMcLaughlin@yahoo.com");
		Customer customer5 = new Customer("Mrs", "Mary", "McLaughlin", "Ardravan", "0865738526", "MaryMcLaughlin@yahoo.com");
		Customer customer6 = new Customer("Mr", "Darren", "Coyle", "Gransha", "0869575023", "DarrenCoyle@yahoo.com");
		customers.add(customer1);
		customers.add(customer2);
		customers.add(customer3);
		customers.add(customer4);
		customers.add(customer5);
		customers.add(customer6);
	}
	
	//Retrive list of students from the database
	@Override
	public List<Customer> getAllCustomers()
	{
		return customers;
	}
	
	@Override
	 public Customer getCustomer(int number) 
	 {
	      return customers.get(number);
	   }
	
	 @Override
	 public void deleteCustomer(Customer customer) 
	 {
	      customers.remove(customer.getNumber());
	      System.out.println("Customer: Customer No " + customer.getNumber() + ", deleted from database");
	 }
	 
	 @Override
	 public void updateCustomer(Customer customer)
	 {
		 customers.get(customer.getNumber()).setName(customer.getName());
		 System.out.println("Customer: Customer No  " + customer.getNumber() + ", updated in the database");
	 }
	
	
	@Override
	public void add()
	{
		// Create a Customer object
		Customer customer = new Customer();
		// Read its details
		customer.read();
		// And add it to the customers ArrayList
		customers.add(customer);
	}
	@Override
	public Customer view()
	{
		Scanner keyboard = new Scanner(System.in);		

		// Read the number of the customers to be viewed from the user
		System.out.println("ENTER CUSTOMER NUMBER TO VIEW : ");
		int customerToView=keyboard.nextInt();
		
		// for every Customer object in customers
	    for(Customer tmpCustomer:customers)
	    {
		   // if it's number equals the number of the customerToView
		   if(tmpCustomer.getNumber() == customerToView)
		   {
		      // display it
			  System.out.println(tmpCustomer);
			  return tmpCustomer;
		   }
		}
	    // if we reach this code the customer was not found so return null
	    return null;
	}
	@Override
	public void list()
	{
		// for every Customer object in customers
		System.out.println("LIST ALL CUSTOMERS");
        for(Customer tmpCustomer:customers)
			// display it
			System.out.println(tmpCustomer);
	}
	@Override
	public void edit()
	{
		// Call view() to find, display, & return the customers details to edit
		Customer tempCustomer = view();
		System.out.print("ENTER CUSTOMER NUMBER TO EDIT");
		// If the customer != null, i.e. it was found then...
	    if(tempCustomer != null)
	    {
		   // get it's index
		   int index=customers.indexOf(tempCustomer);
		   // read in a new Customer
		   tempCustomer.read();
		   customers.set(index, tempCustomer);
		   System.out.print(" Customers have been edited ");
	    }
	}
	 
	@Override
	public void delete()
	{
		
		    // Call view() to find, display, & return the customer to delete
			Customer tempCustomer = view();
			System.out.print("ENTER CUSTOMER NUMBER TO DELETE");
			// If the customer != null, i.e. it was found then...
			if(tempCustomer != null)
			// ...remove it from customers
			customers.remove(tempCustomer);
			System.out.println(" Customer " +tempCustomer + " has been deleted ");
			    
		
	}
	
	
}
