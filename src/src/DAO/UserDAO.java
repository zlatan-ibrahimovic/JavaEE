package DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.User;


@Stateless
public class UserDAO implements IUserDAO{

	@PersistenceContext(unitName ="persistenceUnit")
	private EntityManager em; 

	public void create(User user) {
		if(user.getId()!=null){
			em.merge(user);
		}else{
			em.persist(user);
		}
		
	}

	public void printNameAllUser(){
		Query query = em.createQuery("SELECT u.name FROM User u");
		List names = query.getResultList();
		for(Object n : names){
			System.out.println("Utilisateur:"+ n);
		}
	}

	public User find(String email, String password){
		User user = null;
		try{
			user = (User) em.createNamedQuery("User.findByEmailAndPassword")
					.setParameter("email", email)
					.setParameter("password", password)
					.getSingleResult();
		}catch(Exception e){}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUser() {
		List<User> users = null;
		try{
			users = em.createNamedQuery("User.findAll").getResultList();
		}catch(Exception e){}
		return users;
	}

	@Override
	public User find(String email) {
		User user = null;
	try{
		user = (User) em.createNamedQuery("User.findByEmail")
				.setParameter("email", email)
				.getSingleResult();
	}catch(Exception e){}
	return user;
	}

	@Override
	public void detach(User user) {
		em.detach(user);
	}
	
	
}

