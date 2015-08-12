package com.jxc876
import grails.plugin.springsecurity.annotation.Secured
import grails.converters.JSON

class UserController {	
	
	@Secured(['permitAll'])
	def index(){
		def users = User.list();
		render users as JSON
	}
	
	@Secured(['permitAll'])
	def show(int id){
		def user = User.findById(id)
		render user as JSON
	}
	
	
	/**
	 * Creates a new user and assigns it a default role of user.
	 * @return
	 */
	@Secured(['permitAll'])
    def save() {
		//TODO: Move logic to a Service
		def jsonObj = request.JSON
		def jsonReponse = [:]
		
		def username = jsonObj.username
		def email = jsonObj.email
		
		if (User.findByUsername(username) || User.findByEmail(email)){
			jsonReponse.message = "Username/Email not available."
			response.status = 400;
		}
		else {
			User user = new User(jsonObj)
			user.enabled = false
			user.activationCode = randomString()
			Role role = Role.findByAuthority('ROLE_USER')
			UserRole uRole = new UserRole(user: user, role: role)
			
			boolean userSaved = user.save(flush: true, insert: true)
			boolean uRoleSaved = uRole.save(flush: true, insert: true)
					
			if (userSaved && uRoleSaved){
				jsonReponse.message = "success"
				jsonReponse.code = user.activationCode
				jsonReponse.link = "/LoginApp/api/activations/${user.activationCode}"
				println "activationLink --> /LoginApp/api/activations/${user.activationCode}"
			}else{
				response.status = 400
				jsonReponse.message = "server error occured while creating account"
			}
		}
		
		render jsonReponse as JSON
	}
	
	private String randomString(){
		def pool = ['a'..'z','A'..'Z',0..9,'_'].flatten()
		Random rand = new Random(System.currentTimeMillis())
		def passChars = (0..10).collect { pool[rand.nextInt(pool.size())] }
		def randomString = passChars.join()
		return randomString
	}
}
