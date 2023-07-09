package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreType
public class series extends BaseEntity {
	@Column(length = 50, nullable = false)
	private String sname;
	@Enumerated(EnumType.STRING)
	private Catagory cname;
	private LocalDate rdate;
	private double budget;
	@Column(length = 20, nullable = false)
	private String director;
	private LocalDate modifydate;
	@Email
	private String email;
	private String password;
}
