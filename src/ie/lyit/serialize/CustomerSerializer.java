package ie.lyit.serialize;

import java.util.ArrayList;
import ie.lyit.hotel.Customer;
import java.io.*;
import java.util.*;

public class CustomerSerializer 
{
	private ArrayList<Customer> customers;
	
	private final String FILENAME = "customers.ser";
	
	//DEFAULT CONSTRUCTOR
	public CustomerSerializer()
	{
		//Construct CustomerList ArrayList
		customers = new ArrayList<Customer>();
	}
	
	public void add()
	{
		// Create a Customer object
		Customer customer = new Customer();
		// Read its details
		customer.read();
		// And add it to the customers ArrayList
		customers.add(customer);
	}
	
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
	
	public void list()
	{
		// for every Customer object in customers
		System.out.println("LIST ALL CUSTOMERS");
        for(Customer tmpCustomer:customers)
			// display it
			System.out.println(tmpCustomer);
	}
	
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
	
	
		// This method will serialize the customers ArrayList when called, 
		// i.e. it will write it to a file called customers.ser
		public void writeRecordsToFile()
		{
			ObjectOutputStream os=null;
			try 
			{
				// Serialize the ArrayList...
				FileOutputStream fileStream = new FileOutputStream(FILENAME);
			
				os = new ObjectOutputStream(fileStream);
					
				os.writeObject(customers);
			}
			catch(FileNotFoundException fNFE)
			{
				System.out.println("Cannot create file to store customers.");
			}
			catch(IOException ioE)
			{
				System.out.println(ioE.getMessage());
			}
			finally 
			{
				try 
				{
					os.close();
				}
				catch(IOException ioE)
				{
					System.out.println(ioE.getMessage());
				}
			}
		}
		
		// This method will deserialize the customers ArrayList when called, 
		// i.e. it will restore the ArrayList from the file customers.ser
		public void readRecordsFromFile()
		{
			ObjectInputStream is=null;
			
			try {
				// Deserialize the ArrayList...
				FileInputStream fileStream = new FileInputStream(FILENAME);
			
				is = new ObjectInputStream(fileStream);
					
				customers = (ArrayList<Customer>)is.readObject();	
			}
			catch(FileNotFoundException fNFE)
			{
				System.out.println("Cannot create file to store customers.");
			}
			catch(IOException ioE)
			{
				System.out.println(ioE.getMessage());
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			finally 
			{
				try 
				{
					is.close();
				}
				catch(IOException ioE){
					System.out.println(ioE.getMessage());
				}
			}
		
		}
	
}
