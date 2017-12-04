package ie.lyit.hotel;
import java.util.List;
import java.util.ArrayList;

public interface CustomerDAO 
{
	public List<Customer> getAllCustomers();
	
	public void add();
	
	public Customer view();
	
	public void list();
	
	public void edit();
		
	public void delete();

	public void deleteCustomer(Customer customer);

    Customer getCustomer(int numberNo);

	public void updateCustomer(Customer customer);
	
}
