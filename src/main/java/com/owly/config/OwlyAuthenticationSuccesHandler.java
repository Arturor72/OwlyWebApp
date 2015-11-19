package com.owly.config;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.owly.constants.OwlyConstants;

public class OwlyAuthenticationSuccesHandler implements AuthenticationSuccessHandler {
	
		RedirectStrategy redirect=new DefaultRedirectStrategy();
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
			handleRedirect(request, response, authentication);
			clearAuthenticationAttributes(request);
	}
	
	public void handleRedirect(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException{
		String target=determineUrl(authentication);
		if(response.isCommitted()){
			System.out.println("Error, Unable to redirect to"+target);
		}
		redirect.sendRedirect(request,response, target);
	}
	public String determineUrl(Authentication authentication){
		boolean isAlumno = false;
        boolean isTutor = false;
        
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        
        for (GrantedAuthority grantedAuthority : authorities) {
            if (OwlyConstants.ROLE_ALUMNO.equals(grantedAuthority.getAuthority()) ) {
                isAlumno = true;
                break;
            } else if ( OwlyConstants.ROLE_TUTOR.equals(grantedAuthority.getAuthority()) ) {
                isTutor = true;
                break;
            }
        }
        if (isAlumno) {
            return OwlyConstants.ALUMNO_HOME;
        } else if (isTutor) {
            return OwlyConstants.TUTOR_HOME;
        } else {
            throw new IllegalStateException();
        }
        
	}
	public void clearAuthenticationAttributes(HttpServletRequest request){
		HttpSession session=request.getSession(false);
		if(session==null){
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}
	  public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
	        this.redirect = redirectStrategy;
	    }
}
