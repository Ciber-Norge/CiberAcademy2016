package no.ciber.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue
	@Column(nullable = false)
	private Long id;
	@Column(nullable = false)
	private String name;
	private String email;
	@Column(nullable = false)
	private String sex;
	@Column(nullable = false, columnDefinition = "false")
	private boolean retired;
	@Column(name = "created_at", nullable = false)
	private Date createdAt;
	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;

	public User() {
	}

	public User(String name, String sex) {
		this.name = name;
		this.sex = sex;
		createdAt = new Date();
		updatedAt = createdAt;
	}
}
