package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "product", uniqueConstraints = { @UniqueConstraint(columnNames = { "id" }) })

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//vallo a vedere..............
	@Column(name = "id", nullable = false, unique = true)
	private int id;

	@Column(name = "name", length = 40, nullable = true)
	private String name;

	@Column(name = "url", length = 100, nullable = true)
	private String url;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Product( String name, String url) {
		this.name = name;
		this.url = url;
	}

}
