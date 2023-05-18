package com.tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.Enum.RoomType;
import com.IOutils.Utils;
import com.Validation.PatientValidation;
import com.code.patient;

public class Tester {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			ArrayList<patient> p = new ArrayList<>();
			ArrayList<patient> r = new ArrayList<>();
			System.out.println(" Enter The File Name ");
			String s = sc.next();
			boolean status = false;

			do {
				try {
					System.out.println(" 1 : ADD PATIENT 2: Patient DETAILS 3:RoomType Details");
					System.out.println(" 4 : Remove Patient(Disease) 5: Change RoomType 6:Sort By Age 7:EXIT");
					System.out.println(" Enter The Choice ");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("serialNo,patientName,  age,  gender,  address,  phoneNo, disese,"
								+ "admitDate('YYYY-MM-DD'),annualIncomne,RoomType");
						patient t = PatientValidation.ValidatePatient(sc.nextInt(), sc.next(), sc.nextInt(), sc.next(),
								sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next().toUpperCase());

						p.add(t);
						Utils.storePatient(p, s);
						break;
					case 2:
						System.out.println("PATIENT DETAILS");
						r = Utils.RestorePatient(s);
						r.forEach(System.out::println);
						break;
					case 3:
						System.out.println(" ENTER THE TYPE OF ROOM");
						RoomType T = RoomType.valueOf(sc.next().toUpperCase());
						p.stream().filter(p1 -> p1.getT().name().equalsIgnoreCase(T.name()))
								.forEach(System.out::println);
						break;
					case 4:
						System.out.println(" ENTER THE TYPE OF DISEASE");
						String a = sc.next();
						p.removeIf(m -> m.getDisese().equalsIgnoreCase(a));
						Utils.storePatient(p, s);
						break;
					case 5:
						System.out.println(" SHIFTING ICU TO SPECIAL WARD");
						RoomType T1 = RoomType.ICU;
						for (patient l : p) {
							if (l.getT().name().equals(T1.name())) {
								l.setT(RoomType.SPECIAL);
							}
						}
						Utils.storePatient(p, s);
						break;
					case 6:
						System.out.println(" Sorted By Age ");
						p.stream().sorted((c, b) -> Integer.valueOf(c.getAge()).compareTo(b.getAge()))
								.forEach(System.out::println);
						break;
					case 7:
						status = true;
						break;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					sc.nextLine();
				}

			} while (!status);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}

//2000 aniket 22 male pune 60000 dengue 2023-05-18 74744 GENERAL
//2001 ram 20 male pune 5000 fever 2023-05-18 74844 GENERAL
//2004 rani 19 female pune 8000 diabetese 2023-05-18 84744 SPECIAL
//2002 amit 10 male pune 50050 vomiting 2023-05-18 70744 GENERAL
//2003 sham 25 male pune 500800 tierd 2023-05-18 74654 ICU
