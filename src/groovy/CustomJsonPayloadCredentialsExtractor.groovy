import grails.plugin.springsecurity.rest.credentials.AbstractJsonPayloadCredentialsExtractor
import groovy.util.logging.Slf4j
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import javax.servlet.http.HttpServletRequest

@Slf4j
class CustomJsonPayloadCredentialsExtractor extends AbstractJsonPayloadCredentialsExtractor {
	String usernamePropertyName
	String passwordPropertyName

	UsernamePasswordAuthenticationToken extractCredentials(HttpServletRequest httpServletRequest) {
		def jsonBody = getJsonBody(httpServletRequest)

		if (jsonBody) {
			String username = jsonBody."${usernamePropertyName}"
			String password = jsonBody."${passwordPropertyName}"

			log.debug "Extracted credentials from JSON payload. Username: ${username}, password: ${password?.size()?'[PROTECTED]':'[MISSING]'}"

			new UsernamePasswordAuthenticationToken(username, password)
		} else {
			log.debug "No JSON body sent in the request"
			return null
		}
	}

}