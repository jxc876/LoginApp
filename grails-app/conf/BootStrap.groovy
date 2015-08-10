import com.jxc876.*;

class BootStrap {

    def init = { servletContext ->
		
		User user = new User(username:"admin", password:"admin").save()
		Role role = new Role(authority:"ROLE_ADMIN").save()
		UserRole uRole = new UserRole(user: user, role: role).save()
		
		new Note(text:'Hello this is my note').save();
		new Note(text:'This is another note').save();
    }
    def destroy = {
    }
}
