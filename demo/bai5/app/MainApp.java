package bai5.app;

import bai5.dao.AccountDAO;
import bai5.entity.Account;
import java.util.List;

public class MainApp {
	
	public static void main(String[] args) {
		/*
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.println("Nhap username: ");
		 String username = sc.nextLine();
		 
		 System.out.println("Nhap pass: ");
		 String pass = sc.nextLine();
		 
		 System.out.println("Nhap fullname: ");
		 String fullname = sc.nextLine();
		 
		 Account account = new Account();
		 account.setUsername(username);
		 account.setPass(pass);
		 account.setFullname(fullname);
		 
		 AccountDAO accountDAO = new AccountDAO();
		 
		 accountDAO.insert(account);
		 */
		AccountDAO accountDAO = new AccountDAO();
		
		List<Account> lstAccount = accountDAO.SelectAll();
		
		lstAccount.forEach(p -> {
			System.out.println(p.toString());
		});
		
		 
		 System.out.println("\n----> DONE !!! \n");
	}
	
	
}
