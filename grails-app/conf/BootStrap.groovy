import com.jxc876.*;

class BootStrap {

    def init = { servletContext ->
		
		User user = new User(username:"admin", email: 'admin@gmail.com', password:"admin").save()
		Role role = new Role(authority:"ROLE_USER").save()
		UserRole uRole = new UserRole(user: user, role: role).save()
		
		new Note(text:'This note was fetched from the REST API at /api/notes').save();
		new Note(text:'These notes require authentication to view').save();
		
    }
    def destroy = {
    }
}
