package com.example.flightbookingmanager.model;

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

public class PassengerOutputModel {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNo;

}
