package com.jxc876

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

class NoteController {

	//@Secured(['permitAll'])
	@Secured(['ROLE_ADMIN'])
    def index() { 
		println "inside index()"
		def notes = Note.list();
		render notes as JSON
	}
}
