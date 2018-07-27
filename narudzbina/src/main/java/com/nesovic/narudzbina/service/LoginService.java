package com.nesovic.narudzbina.service;

import java.sql.SQLException;
import java.util.Date;

import javax.ws.rs.core.Application;

import com.nesovic.narudzbina.exception.AuthFaildException;
import com.nesovic.narudzbina.model.Credentials;
import com.nesovic.narudzbina.model.Klijent;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class LoginService extends Application{
	ServiceKlijent dao=new ServiceKlijent();
	
	public String Login(Credentials crd) throws ClassNotFoundException, SQLException, AuthFaildException {
		Klijent klijent=dao.Login(crd);
		String jwt="";
		if(klijent.getUsername()!="") {
			Long time=System.currentTimeMillis();
			jwt=Jwts.builder().claim("id", klijent.getId_klijenta())
					 .setSubject(String.valueOf(klijent.getId_klijenta()))
					.claim("ime", klijent.getIme())
					.claim("prezime", klijent.getPrezime())
					.claim("role", klijent.getRole())
					.setExpiration(new Date(time+90000))
					.signWith(SignatureAlgorithm.HS256, "password".getBytes())
					.compact();
		//	json=Json.createObjectBuilder().add(jwt).build();
			return jwt;
		}
		return jwt;
	}
}
