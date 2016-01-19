package DAO;

import java.util.List;

import javax.ejb.Local;

import Entities.Announce;

@Local
public interface IAnnounceDAO {
	
	void create(Announce announce);
	List<Announce> findAllAnnounce();
	List<Announce> findForSale();
	Announce find(int id);
	void remove(Announce annonce);
	
	List<Announce> findAllOBPostalCode();
	
	List<Announce> findAllOBPriceASC();
	List<Announce> findAllOBPriceDESC();
	
	List<Announce> findAllOBAreaASC();
	List<Announce> findAllOBAreaDESC();
	
	void detach(Announce A);
}
