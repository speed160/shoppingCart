package org.springmvcshoppingcart.dao;

import org.springmvcshoppingcart.entity.Account;

public interface AccountDAO {

	public Account findAccount(String userName);

}
