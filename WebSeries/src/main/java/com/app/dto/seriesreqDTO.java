package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import com.app.entities.Catagory;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class seriesreqDTO {
	@NotBlank(message = "series name need not be empty")
	private String sname;
	//@Enumerated(EnumType.STRING)
	private Catagory cname;
	@Future(message = "Future Date Needed")
	private LocalDate rdate;
	@Positive(message = "Number Must Be Positive")
	private double budget;
	private String director;
	private LocalDate modifydate;
	@Email(message = "Enter the valid email")
	private String email;
	@Pattern(regexp ="^(?=.*[0-9])(?=.*[@#])[a-zA-Z0-9@#]{5,10}$",message = "Enter the Valid password")
	private String password;
}
