package com.mphasis.cart.bo;

import java.util.Date;
import java.util.List;

import com.mphasis.cart.beans.Player;
import com.mphasis.cart.dao.PlayerDao;
import com.mphasis.cart.dao.PlayerDaoImpl;
import com.mphasis.cart.exceptions.BuissnessException;


public class PlayerBOImpl implements PlayerBO {
	PlayerDao playerDao=null;
	
	public PlayerBOImpl() {
	playerDao=new PlayerDaoImpl();
	}
	
	@Override
	public Player getPlayerById(int id) throws BuissnessException {
		Player player = null;
		if (id > 1 && id < 16) {
			player = playerDao.getPlayerById(id);
		} else {
			throw new BuissnessException("Entered ID is invalid");
		}
		return player;
	}

	@Override
	public List<Player> getPlayersByGender(String gender) throws BuissnessException {
		List<Player> playerList = null;
		if (gender != null && gender.matches("[mMfF]{1}")) {
			// code for dao
			playerList = playerDao.getPlayerByGender(gender);
		} else {
			throw new BuissnessException("Enter gender " + gender + " is invalid");
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersByAge(int age) throws BuissnessException {
		List<Player> playerList = null;
		// code for dao
		if (age > 16 && age < 48) {
			playerList = playerDao.getPlayerByAge(age);
		} else {
			throw new BuissnessException("Entered age " + age + " is invalid");
		}
		return playerList;
	}

	@Override
	public Player getPlayerByEmail(String email) throws BuissnessException {
		Player player = null;
		if (email != null && email.matches(
				"[a-zA-Z0-9]{4,15}@gmail.com")) {
			player = playerDao.getPlayerByEmail(email);
		} else {
			throw new BuissnessException("Entered email " + email + " is invalid");
		}
		return player;
	}

	@Override
	public Player getPlayerByNumber(Long contact) throws BuissnessException {
		Player player = null;
		if (contact >1L) {
			
			
			player = playerDao.getPlayerByContact(contact);
		} else {
			throw new BuissnessException("Entered number is invalid");
		}

		return player;
	}

	@Override
	public List<Player> getPlayersByTeamname(String teamname) throws BuissnessException {
		List<Player> playerList = null;
		if (teamname != null && teamname.matches("[A-Z]{1,}")) {
			
			playerList = playerDao.getPlayerByTeamname(teamname);
		} else {
			throw new BuissnessException("Entered Teamname " + teamname + " is invalid");
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersByName(String name) throws BuissnessException {
		List<Player> playerList = null;
		if (name != null && name.matches("[a-zA-Z]{3,10}")) {
			
			playerList = playerDao.getPlayerByName(name);
		} else {
			throw new BuissnessException("Entered Name " + name + " is invalid");
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersByDob(Date dob) throws BuissnessException {
		List<Player> playerList = null;
		if (dob != null) {
			playerList = playerDao.getPlayerByDob(dob);
		} else {
			throw new BuissnessException("Entered Name " + dob + " is invalid");
		}
		return playerList;
	}

	@Override
	public void addPlayer(Player p)throws BuissnessException {
		if(((p.getPid() >1)  &&  (p.getPid()< 16) )
		&& (p.getName().matches("[A-Za-z]{3,10}")) &&
			(p.getGender().matches("[MmFf]{1}")) &&
			(p.getContact()> 1L)&& 
	(p.getEmail().matches("[a-zA-Z0-9]{4,15}@gmail.com"))
			&& (p.getTeamname().matches("[A-Z]{1,}"))
			&& ((p.getAge()> 16) && (p.getAge()<42))
			&& (p.getDob()!=null)) {
		playerDao.addPlayer(p);
		}else {
			throw new BuissnessException("Problem with input");
		}
	}

	@Override
	public int deletePlayer(int id) {
		return playerDao.deletePlayer(id);
	}

	@Override
	public int updateScore(int id, long score) {
		
		return playerDao.updateScore(id, score);
	}

	@Override
	public List<Player> getAllPlayers() throws com.mphasis.cart.exceptions.BuissnessException {
		
		return playerDao.getAllPlayers();
	}

}
