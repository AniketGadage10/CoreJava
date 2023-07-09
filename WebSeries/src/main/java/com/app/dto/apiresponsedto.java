package com.app.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class apiresponsedto {

	private String msg;
	private LocalDate date;

	public apiresponsedto(String msg) {
		this.msg = msg;
		this.date = LocalDate.now();
	}
}
