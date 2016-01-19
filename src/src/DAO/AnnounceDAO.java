package DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.Announce;
import Entities.User;

@Stateless
public class AnnounceDAO implements IAnnounceDAO{

	@PersistenceContext(unitName ="persistenceUnit")
	private EntityManager em; 

	@Override
	public void create(Announce announce) {
		if(announce.getId()!=null){
			em.merge(announce);
		}else{
			em.persist(announce);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Announce> findAllAnnounce() {
		List<Announce> announces = null;
		try{
			announces = em.createNamedQuery("Announce.findAll").getResultList();
		}catch(Exception e){}
		return announces;
	}

	@Override
	public void remove(Announce announce){
		try{
			//em.remove(announce);
			em.createNamedQuery("Announce.remove").setParameter("id", announce.getId()).executeUpdate();
		}catch(Exception e){}
	}

	@Override
	public Announce find(int id) {
		Announce announce = null;
		try{
			//em.find(Announce.class, id);
			announce = (Announce) em.createNamedQuery("Announce.find")
					.setParameter("id", id)
					.getSingleResult();
		}catch(Exception e){}
		return announce;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Announce> findAllOBPostalCode() {
		List<Announce> announces = null;
		try{
			announces = em.createNamedQuery("Announce.findAllOBPostalCode").getResultList();
		}catch(Exception e){}
		return announces;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Announce> findAllOBPriceASC() {
		List<Announce> announces = null;
		try{
			announces = em.createNamedQuery("Announce.findAllOBPriceASC").getResultList();
		}catch(Exception e){}
		return announces;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Announce> findAllOBPriceDESC() {
		List<Announce> announces = null;
		try{
			announces = em.createNamedQuery("Announce.findAllOBPriceDESC").getResultList();
		}catch(Exception e){}
		return announces;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Announce> findAllOBAreaASC() {
		List<Announce> announces = null;
		try{
			announces = em.createNamedQuery("Announce.findAllOBAreaASC").getResultList();
		}catch(Exception e){}
		return announces;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Announce> findAllOBAreaDESC() {
		List<Announce> announces = null;
		try{
			announces = em.createNamedQuery("Announce.findAllOBAreaDESC").getResultList();
		}catch(Exception e){}
		return announces;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Announce> findForSale() {
		List<Announce> announces = null;
		try{
			announces = em.createNamedQuery("Announce.findForSale").getResultList();
		}catch(Exception e){}
		return announces;
	}
	
	@Override
	public void detach(Announce A) {
		em.detach(A);	
	}

}
