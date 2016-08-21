package no.ciber.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;
	@Column(nullable = false)
	private String name;
	private String email;
	@Column(nullable = false)
	private String sex;
	@Column(nullable = false, columnDefinition = "boolean DEFAULT false")
	private boolean retired;
//	@Column(name = "created_at", nullable = false)
//	private Date createdAt;
//	@Column(name = "updated_at", nullable = false)
//	private Date updatedAt;

	public User() {
	}

	public User(String name, String sex) {
		this.name = name;
		this.sex = sex;
//		createdAt = new Date();
//		updatedAt = createdAt;
	}
}
