package com.jxc876

import grails.plugin.springsecurity.annotation.Secured
import grails.converters.JSON

class ActivationController {
	
	@Secured(['permitAll'])
	def activate(){
		String activationCode = params.activationCode
		User user = User.findByActivationCode(activationCode)
		def jsonResponse = [:]
		if (user){
			user.enabled = true
			user.save(flush:true, failOnError:true)
			jsonResponse.message = "user account was activated"
			jsonResponse.username = user.username
		}
		else {
			response.status = 400
			jsonResponse.message = "account not activated"
		}
		render jsonResponse as JSON
	}

}
