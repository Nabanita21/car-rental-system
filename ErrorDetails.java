package com.example.carrentalproject.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.ZonedDateTime;

@AllArgsConstructor
@Getter
public class ErrorDetails {

        public ErrorDetails(String string, String description, ZonedDateTime now) {
		// TODO Auto-generated constructor stub
	}
		private final String message = "";
        private final String details = "";
        private final ZonedDateTime timestamp = null;

}
