package Entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(name="Announce.findAll",
                query="SELECT a FROM Announce a"),
    @NamedQuery(name="Announce.findForSale",
                query="SELECT a FROM Announce a WHERE a.sold = '0'"),            
    @NamedQuery(name="Announce.find",
                query="SELECT a FROM Announce a WHERE a.id = :id"),    
    @NamedQuery(name="Announce.remove",
                query="DELETE FROM Announce a WHERE a.id = :id"), 
    @NamedQuery(name="Announce.findAllOBPostalCode",
                query="SELECT a FROM Announce a  WHERE a.sold = '0' ORDER BY a.postalCode"),
    @NamedQuery(name="Announce.findAllOBPriceASC",
                query="SELECT a FROM Announce a  WHERE a.sold = '0' ORDER BY a.price ASC"),
    @NamedQuery(name="Announce.findAllOBPriceDESC",
                query="SELECT a FROM Announce a  WHERE a.sold = '0' ORDER BY a.price DESC"),            
    @NamedQuery(name="Announce.findAllOBAreaASC",
                query="SELECT a FROM Announce a  WHERE a.sold = '0' ORDER BY a.area ASC"), 
    @NamedQuery(name="Announce.findAllOBAreaDESC",
                query="SELECT a FROM Announce a  WHERE a.sold = '0' ORDER BY a.area DESC"),
}) 
@Table(name="ALDA_announce")
public class Announce {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Basic
	@Column(length = 120, nullable=false)
	private String title;

	@Basic
	@Column(length = 560, nullable=true)
	private String description;

	@Basic	
	@Column(nullable=false)
	private Date date;

	@Basic
	@Column(nullable=false)
	private Double price;

	@Basic
	@Column(nullable=false)
	private Double area;
	
	@ManyToOne
	private User seller;

	@Basic
	@Column(length = 250, nullable=false)
	private String address;
	
	@Basic
	@Column(length = 5, nullable=false)
	private String postalCode;
	
	@ManyToMany(mappedBy="myFavoritesAnnounces",fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<User> observors = new ArrayList<User>();
	

	@ElementCollection(fetch=FetchType.EAGER)
	private List<String> photo;
	
	
	

	@Basic
	@Column(nullable=false)
	private boolean sold;
	
	public Announce(){
		title = "";
		description = "";
		date = new Date();
		price = 0.0;
		area = 0.0;
		seller = null;
		address = "";
		observors = new ArrayList<User>();
		photo = new ArrayList<String>();
		sold = false;
		
	}
	
	public Announce(Announce a){
		this.title=a.getTitle();
		this.address=a.getAddress();
		this.description=a.getDescription();
		this.date=a.getDate();
		this.area=a.getArea();
		this.seller=a.getSeller();
		this.observors=	a.getObservors();
		//this.photo=a.getPhoto();
		this.sold=a.sold;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}
	
	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public List<User> getObservors() {
		return observors;
	}

	public void addObservors(User observer) {
		for(User u : observors){
			if(u.getId().equals(observer.getId())){
				return ;
			}
		}
		observors.add(observer);
	}
	public void removeObservors(User observer) {
		for(User u : observors){
			if(u.getId().equals(observer.getId())){
				observors.remove(u);
			}
		}
	}
	public boolean isObservor(User user){
		for(User u : observors){
			if(u.getId().equals(user.getId())){
				return true;
			}
		}
		return false;
	}
	public void notifyAllObservor(){
		System.out.println("Notify--------------------------------------------------------------");
		for(User u : observors){
			if(u.isConnected()){
				u.update(this);
			}
		}
	}
	public void addPhoto(String img){
		this.photo.add(img);
	}
	
	public void removePhoto(String img){
		this.photo.remove(img);
	}
	public void removeAllPhoto(){
		this.photo.removeAll(this.photo);
	}
	public List<String> getPhoto(){
		return this.photo;
	}
	
	public void setPhoto(List<String> photo){
		this.photo=photo;
	}
	
	public boolean isSold(){
		return sold;
	}
	
	public void setSold(boolean s){
		if(sold != s){
			this.sold = s;
			notifyAllObservor();
		}
		this.sold = s;
		
	}
}
