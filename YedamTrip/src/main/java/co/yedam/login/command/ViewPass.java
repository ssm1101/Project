package co.yedam.login.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class ViewPass implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		return "user/login/viewPass.tiles";
	}

}
