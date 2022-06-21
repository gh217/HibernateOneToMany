package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "fullName")
	private String name;  

	// mapped to insert forein key automatic no
	@OneToMany( cascade = CascadeType.ALL, mappedBy = "student",fetch = FetchType.LAZY)
	private List<Information> listInfo = new ArrayList();
	
	
	public List<Information> getListInfo() {
		return listInfo;
	}

	public void setListInfo(List<Information> listInfo) {
		this.listInfo = listInfo;
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
	
	
}
