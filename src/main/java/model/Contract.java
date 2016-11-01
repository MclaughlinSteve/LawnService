package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "contract")
public class Contract {
	
	@Id
	@GeneratedValue
	@Column(name="contractId")
	private int id;
	
	@Column(name="name", unique=true)
	private String name;
	
	@Column(name="duration")
	private int duration;
	
	@ManyToMany(fetch = FetchType.EAGER,
	        cascade =
	        {
	                CascadeType.DETACH,
	                CascadeType.MERGE,
	                CascadeType.REFRESH,
	                CascadeType.PERSIST,
	        },
	        targetEntity = LawnArea.class)
	@JoinTable(name = "lawn_contracts",
				joinColumns={@JoinColumn(name="contractId")},
				inverseJoinColumns={@JoinColumn(name="lawnId")},
				foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
		        inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
	private Set<LawnArea> lawns;
	
	@Column(name="cost")
	private double cost;
	
	public Contract() {
		name = "ENTER NAME";
		duration = 0;
		lawns = new HashSet<>();
		cost = 0.00;
	}
	
	public Contract(String name, int duration, Set<LawnArea> lawns, double cost) {
		this.name = name;
		this.duration = duration;
		this.lawns = lawns;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Set<LawnArea> getLawns() {
		return lawns;
	}

	public void setLawns(Set<LawnArea> lawns) {
		this.lawns = lawns;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Contract [id=" + id + ", name=" + name + ", duration=" + duration + ", lawns=" + lawns + ", cost="
				+ cost + "]";
	}
	
	

}
