package com.eventapp.dto;

public class TicketBookingResponse {
	
		private String message;
		private double amountPayable;
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public double getAmountPayable() {
			return amountPayable;
		}
		public void setAmountPayable(double amountPayable) {
			this.amountPayable = amountPayable;
		}
		public TicketBookingResponse() {
			super();
			// TODO Auto-generated constructor stub
		}

		
}
