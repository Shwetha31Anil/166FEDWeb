package com.mphasis.cart.bo;

import com.mphasis.cart.beans.CartAUser;
import com.mphasis.cart.dao.CartAUserDao;
import com.mphasis.cart.dao.CartAUserDaoImpl;
import com.mphasis.cart.exceptions.BuissnessException;

public class CartAUserBoImpl implements CartAUserBo {

	CartAUserDao cartAUserDao;
	 public CartAUserBoImpl() {
		cartAUserDao=new CartAUserDaoImpl();
	}
			
	
	@Override
	public void register(CartAUser user)
			throws BuissnessException {
		if(user.getGender().matches("[mMfF]{1}")) {
			cartAUserDao.register(user);
		}else {
			throw new BuissnessException
			("entered invalid gender");
		}
		
	}

	@Override
	public int changePassword(String oldpass, String newpass)throws BuissnessException {
		int i=0;
		if(!oldpass.equals(newpass))
		{
			cartAUserDao.changePassword(oldpass, newpass);
		}else {
			throw new BuissnessException("old and new password "
					+ "should not be same");
		}
		return i;
	}


	@Override
	public CartAUser login(String email, String pass) {
		return cartAUserDao.login(email, pass);
	}

}
