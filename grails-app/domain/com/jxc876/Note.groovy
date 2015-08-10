package com.jxc876

import grails.rest.Resource

/**
 * Domain class for storing simple text notes.
 * Exposed at: <pre>http://localhost:8080/LoginApp/api/notes</pre>
 * @author mike
 */
@Resource(uri='/api/notes', formats=['json', 'xml'])
class Note {

	String text
	Date date = new Date()
	
    static constraints = {
    }
}
