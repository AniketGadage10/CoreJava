package com.Validation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import com.Exception.*;
import com.code.patient;
import com.Enum.RoomType;

public interface PatientValidation {


	public static patient ValidatePatient(int serialNo, String patientName, int age, String gender, String address,
			String phoneNo, String disese, String admitDate, double annualIncomne, String t) throws PatientException {
		
		;RoomType t1 = checkRoomType(t);
		LocalDate D = checkDate(admitDate);
		return new patient(serialNo, patientName, age, gender, address, phoneNo, disese, D, annualIncomne, t1);

	}

	public static LocalDate checkDate(String date) throws PatientException {

		LocalDate d = LocalDate.parse(date);
		if (d.equals(LocalDate.now())) {
			return d;
		} else
			throw new PatientException("WRONG Date Enter ");
	}

	public static RoomType checkRoomType(String room) throws PatientException {
		for (RoomType t1 : RoomType.values()) {
			if (t1.name().equalsIgnoreCase(room)) {
				return RoomType.valueOf(room);
			}
		}
		throw new PatientException("Wrong Room Type");
	}

}
