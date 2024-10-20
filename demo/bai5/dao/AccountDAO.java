package bai5.dao;

import bai5.entity.Account;
import bai5.utils.UtilJDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {

	public void insert(Account account) {
		String sql = "insert into Accounts(username, pass, fullname) values (?, ?, ?)";
		UtilJDBC.update(sql,
			account.getUsername(),
			account.getPass(),
			account.getFullname()
		);
	}

	public void update(Account account) {
		String sql = "update Accounts set pass = ?, fullname = ? where username = ?";
		UtilJDBC.update(sql,
			account.getPass(),
			account.getFullname(),
			account.getUsername()
		);
	}

	public void delete(String username) {
		String sql = "delete Accounts where username = ?";
		UtilJDBC.update(sql, username);
	}

	public List<Account> SelectBySQL(String sql, Object... args) {
		List<Account> lstAccount = new ArrayList<>();
		try {
			ResultSet rs = null;
			try {
				rs = UtilJDBC.query(sql, args);
				while (rs.next()) {
					Account account = new Account();
					account.setUsername(rs.getString("username"));
					account.setPass(rs.getString("pass"));
					account.setFullname(rs.getString("fullname"));
					lstAccount.add(account);
				}
			} finally {
				rs.getStatement().getConnection().close();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return lstAccount;
	}
	
	public List<Account> SelectAll(){
		String sql = "select * from Accounts";
		return SelectBySQL(sql);
	}
	
	public Account SelectByUsername(String username){
		String sql = "select * from Accounts where username = ?";
		List<Account> lstAccount = SelectBySQL(sql, username);
		return lstAccount.size() > 0 ? lstAccount.get(0) : null;
	}
	
	public Account SelectByUsernameAndPass(String username, String pass){
		String sql = "select * from Accounts where username = ? and pass = ?";
		List<Account> lstAccount = SelectBySQL(sql, username, pass);
		return lstAccount.size() > 0 ? lstAccount.get(0) : null;
	}
	
	public List<Account> SelectUsernameLike(String username){
		String sql = "select * from Accounts where username like ?";
		return  SelectBySQL(sql, "%" + username  + "%");
	}
	

}
