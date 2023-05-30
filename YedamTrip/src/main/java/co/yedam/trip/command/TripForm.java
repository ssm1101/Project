package co.yedam.trip.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class TripForm implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) { 

		return "seller/trip/tripForm.tiles";
	}
}