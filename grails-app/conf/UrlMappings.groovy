class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
		
		"/api/notes"(resources: 'note', includes:['index'])
		"/api/users"(resources: 'user')
		"/api/activations/$activationCode"(controller: "activation", action:"activate")
		
        "/"(view:"/index")
        "500"(view:'/error')
	}
}
