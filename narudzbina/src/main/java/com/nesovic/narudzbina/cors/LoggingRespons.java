package com.nesovic.narudzbina.cors;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
@Provider
public class LoggingRespons implements ContainerRequestFilter,ContainerResponseFilter{

	@Override
	public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
		System.out.println("Response fileter");
		System.out.println("Heder: "+response.getHeaders());
	}

	@Override
	public void filter(ContainerRequestContext request) throws IOException {
		System.out.println("Request fileter");
		System.out.println("Heder: "+request.getHeaders());
	}

}
