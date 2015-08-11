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
	
	
	@Secured(['permitAll'])
    def save() {
		def jsonObj = request.JSON
		
		User user = new User(jsonObj)
		user.enabled = false
		
		def map = [:]
		
		if (user.save()){
			map.status = "sucess"
		}else{
			map.status = "failure"
		}
		
		render map as JSON
	}
	
	private String randomString(){
		int randomStringLength = 32
		String charset = (('a'..'z') + ('A'..'Z') + ('0'..'9')).join()
		String randomString = RandomStringUtils.random(randomStringLength, charset.toCharArray())
		return randomString
	}
}
