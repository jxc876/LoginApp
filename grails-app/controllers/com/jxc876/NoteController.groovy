package com.jxc876

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.SpringSecurityService

class NoteController {
	
	SpringSecurityService springSecurityService

	//@Secured(['permitAll'])
	@Secured(['ROLE_ADMIN'])
    def index() { 
		
		User user = springSecurityService.currentUser
		println user
		
		def notes = Note.list();
		render notes as JSON
	}
}
