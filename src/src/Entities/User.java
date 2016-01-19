package Entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;

import SessionListener.UsersConnected;


@Entity
@NamedQueries({
	@NamedQuery(name="User.findAll",
			query="SELECT u FROM User u"),
			@NamedQuery(name="User.findByEmailAndPassword",
			query="SELECT u FROM User u WHERE u.email = :email AND u.password = :password"),
			@NamedQuery(name="User.findByEmail",
			query="SELECT u FROM User u WHERE u.email = :email"),
			@NamedQuery(name="User.removeFavoriteAnnounce",
			query="DELETE FROM ALDA_announce_ALDA_user f WHERE f.MYFAVORITESANNOUNCES_id = :announceId AND f.OBSERVORS_ID = :userId"),            
}) 
@Table(name="ALDA_user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Basic
	@Column(length = 30, nullable=true)
	private String name;

	@Basic
	@Column(length = 30, nullable=true)
	private String firstName;

	@Basic
	@Column(length = 60, nullable=false, unique=true)
	private String email;

	@Basic
	@Column(length = 20, nullable=false)
	private String password;

	@Basic
	@Column(length = 250, nullable=true)
	private String address;

	@Basic
	@Column(length = 5, nullable=true)
	private String postalCode;

	@Basic
	@Column(length = 20, nullable=true)
	private String phone;

	@OneToMany(mappedBy="seller", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Announce> myAnnounces = new ArrayList<Announce>();

	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Announce> myFavoritesAnnounces = new ArrayList<Announce>();
	
	@Basic
	@Column(nullable=false)
	private boolean sold;
	
	private String alert;

	public User(String email,String password){
		this.name = null;
		this.firstName = null;
		this.email = email;
		this.password = password;
		this.phone = null;
		this.myAnnounces = new ArrayList<Announce>();
		this.myFavoritesAnnounces = new ArrayList<Announce>();
		this.sold=false;
		this.alert="";
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Collection<Announce> getMyAnnounces() {
		return myAnnounces;
	}

	public void addMyAnnounce(Announce myAnnounce) {
		myAnnounce.setSeller(this);
		this.myAnnounces.add(myAnnounce);

	}

	public List<Announce> getMyFavoritesAnnounces() {
		return myFavoritesAnnounces;
	}

	public void addMyFavoritesAnnounces(Announce myAnnounce) {
		for (Announce a : myFavoritesAnnounces) {
			if(a.getId().equals(myAnnounce.getId())){
				return;
			}
		}
		myAnnounce.addObservors(this);
		this.myFavoritesAnnounces.add(myAnnounce);
	}


	public void removeMyFavoritesAnnounces(Announce myAnnounce) {
		for (Announce a : myFavoritesAnnounces) {
			if(a.getId().equals(myAnnounce.getId())){
				this.myFavoritesAnnounces.remove(a);
				return ;
			}	
		}
	}

	public boolean isConnected(){
		return UsersConnected.isConnected(this);
	}
	
	public void update(Announce a){
		System.out.println("Update");
		if(a.isSold()){
			System.out.println("Update is sold");
			alert = "L 'annonce"+ a.getId() +" "+ a.getTitle() +" a été vendu !!";
		}
	}
	public String getAlert() {
		System.out.println("GET ALERT !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+ alert );
		return alert;
	}
	public void setAlert(String alert) {
		this.alert = alert;
	}
	
}