package ie.lyit.testers;


import ie.lyit.hotel.Customer;
import ie.lyit.hotel.CustomerDAO;
import ie.lyit.hotel.CustomerDAOImpl;

public class CustomerDAOTester 
{
	public static void main(String[] args) 
	{
		CustomerDAO customerDao = new CustomerDAOImpl();
		
		//print all customers
	      for (Customer customer : customerDao.getAllCustomers()) 
	      {
	         System.out.println("Customer: [Number : " + customer.getNumber() + ", Name : " + customer.getName() + " ]");
	      }
		
	      //update customer
	      Customer customer = customerDao.getAllCustomers().get(0);
	      customer.setPhoneNumber("0861619828");
	      customerDao.updateCustomer(customer);
	      
	      //get the student
	      customerDao.getCustomer(0);
	      System.out.println("Customer: [Number : " + customer.getNumber() + ", Name : " + customer.getName() + " ]");	
	      
		
	}
}
