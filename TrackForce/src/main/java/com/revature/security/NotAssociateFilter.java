package com.revature.security;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import com.revature.services.JWTService;

/**
 * 
 * @author Michael Tseng
 * 
 * Class made in reference to:
 * https://javapapers.com/web-service/intercept-jax-rs-request-with-jersey-containerrequestfilter/
 * 
 * Checks to make sure user has a valid token and it not an associate
 *
 **/
@Provider //denotes a filter
@NotAssociate //binds it to an interface, so it can be used as an annotation
public class NotAssociateFilter implements ContainerRequestFilter {
	/**
	 * Method that intercepts HttpRequest before they hit the endpoints
	 * Extracts the token under the 'Authorization' header
	 * 
	 * @param request
	 * The intercepted ContainerRequestContext
	 * 
	 * @return nothing if the user is not an associate, otherwise an WebApplicationException
	 * is thrown
	 * 
	 */
	@Override
	public void filter(ContainerRequestContext request) throws IOException {

		String token = request.getHeaderString("Authorization");
		
		JWTService jwt = new JWTService();

		boolean status = jwt.isAssociate(token);
		
		if (status) {
			throw new WebApplicationException(Status.UNAUTHORIZED);
		}
		
	}
}
