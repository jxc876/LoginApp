class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
		
		"/api/notes"(resources: 'note', includes:['index'])
		"/api/users"(resources: 'user')
		
		
        "/"(view:"/index")
        "500"(view:'/error')
	}
}
