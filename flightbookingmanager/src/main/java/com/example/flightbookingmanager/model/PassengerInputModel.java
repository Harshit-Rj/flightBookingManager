package com.example.flightbookingmanager.model;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class PassengerInputModel {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNo;
	private String password;

}
 