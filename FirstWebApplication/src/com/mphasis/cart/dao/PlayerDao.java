package com.mphasis.cart.dao;

import java.util.Date;
import java.util.List;

import com.mphasis.cart.beans.Player;
import com.mphasis.cart.exceptions.BuissnessException;



public interface PlayerDao {
	public Player getPlayerById(int id) throws BuissnessException;
	public List<Player> getPlayerByName(String name)throws BuissnessException;
	public List<Player> getPlayerByGender(String gender)throws BuissnessException;
	public Player getPlayerByContact(long contact)throws BuissnessException;
	public List<Player> getPlayerByTeamname(String teamname)throws BuissnessException;
	public List<Player> getPlayerByAge(int age)throws BuissnessException;
	public List<Player> getPlayerByDob(Date dob) throws BuissnessException;
	public List<Player> getPlayerByScore(int score)throws BuissnessException;
	public List<Player> getAllPlayers()throws BuissnessException;
	public void addPlayer(Player p);
	public int deletePlayer(int id);
	public int updateScore(int id, long score);
	public Player getPlayerByEmail(String email);

}
