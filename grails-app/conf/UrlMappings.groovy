class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/info"(view:"/info")
		"/"(view:"/info")
		
		"500"(view:'/error')
	}
}
