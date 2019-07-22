package com.mphasis.cart.bo;



import java.util.Date;
import java.util.List;

import com.mphasis.cart.beans.Player;
import com.mphasis.cart.exceptions.BuissnessException;





public interface PlayerBO {
	public Player getPlayerById(int id) throws BuissnessException;
	public List<Player> getPlayersByGender(String gender) throws BuissnessException;
	public List<Player> getPlayersByAge(int age) throws BuissnessException;
	public Player getPlayerByEmail(String email) throws BuissnessException;
	public Player getPlayerByNumber(Long contact) throws BuissnessException;
	public List<Player> getPlayersByTeamname(String teamname) throws BuissnessException;
	public List<Player> getPlayersByName(String name) throws BuissnessException;
	public List<Player> getPlayersByDob(Date dob) throws BuissnessException;
	public void addPlayer(Player p)throws BuissnessException;
	public int deletePlayer(int id);
	public int updateScore(int id, long score);
	public List<Player> getAllPlayers()throws BuissnessException;
	

}
