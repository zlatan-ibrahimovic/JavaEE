package SessionListener;

import java.util.ArrayList;
import java.util.List;

import Entities.User;

public class UsersConnected {
	
	static private List<User> usersConnected;
	
	static {
		usersConnected = new ArrayList<User>();
	}
	
	public static boolean isConnected(User u){
		for(User user: usersConnected){
			if(user.getId().equals(u.getId())){
				return true;
			}
		}
		return false;
	}
	
	public static void add(User u){
		usersConnected.add(u);
	}
	
	public static void remove(User u){
		usersConnected.remove(u);
	}
	
	public static void printConnected(){
		System.out.println("Users Connected:");
		for(User u:usersConnected){
			System.out.println(u.getEmail());
		}
	}
	
}
