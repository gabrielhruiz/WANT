package org.app.want.parasite.converters;

import org.app.want.parasite.useraccount.UserAccount;

public class ToUserAccount {
	public static UserAccount urlToUserAccount(String queryString){
		UserAccount user = new UserAccount();
		String[] userDates = queryString.split("&");
		
		user.setName(userDates[0].split("=")[1]);
		user.setSurname(userDates[1].split("=")[1]);
		user.setUserName(userDates[2].split("=")[1]);
		user.setPassword(userDates[3].split("=")[1]);
		user.setMail(userDates[4].split("=")[1]);
		user.setPhone(userDates[5].split("=")[1]);
		user.setZipcode(new Integer(userDates[6].split("=")[1]));
		user.setuType("user");
		
		return user;
	}
}
