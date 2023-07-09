package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class updateDTO {	
	@Future(message = "Date Must Be Future ")
	private LocalDate modifydate;
	@NotNull(message = "SID Never Be Null")
	private Long sid;
}
