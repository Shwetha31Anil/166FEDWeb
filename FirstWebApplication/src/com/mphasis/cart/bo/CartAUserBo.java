package com.mphasis.cart.bo;

import com.mphasis.cart.beans.CartAUser;
import com.mphasis.cart.exceptions.BuissnessException;

public interface CartAUserBo {
	
	public void register(CartAUser user)throws BuissnessException;
	public int changePassword(String oldpass,String newpass)throws BuissnessException;
	
	public CartAUser login(String email,String pass);
}
