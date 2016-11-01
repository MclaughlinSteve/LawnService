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

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;

@Entity
@Table(name="lawnarea")
public class LawnArea {
	@Id
	@GeneratedValue
	@Column(name="lawnId")
	private int id;
	
	@Column(name="name", unique=true)
	private String name;
	
	@Type( type = "db.customtypes.PositionCompositeType")
	@Columns(columns = {
			@Column(name = "latitude"),
			@Column(name = "longitude")
	})
	private Position position;
	
	@ManyToMany(fetch = FetchType.EAGER,
	        cascade =
	        {
	                CascadeType.DETACH,
	                CascadeType.MERGE,
	                CascadeType.REFRESH,
	                CascadeType.PERSIST,
	        },
	        targetEntity = Contract.class)
	@JoinTable(name = "lawn_contracts",
				inverseJoinColumns={@JoinColumn(name="contractId")},
				joinColumns={@JoinColumn(name="lawnId")},
				foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
				inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
	private Set<Contract> contracts = new HashSet<>(0);
	
	
	public LawnArea() {
		name = "DEFAULT";
		position = new Position();
	}
	
	public LawnArea(String name, Position position) {
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Set<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(Set<Contract> contracts) {
		this.contracts = contracts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "LawnArea [id=" + id + ", name=" + name + ", position=" + position + "]";
	}
	
	
	

}
