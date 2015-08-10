import com.jxc876.Note
import com.jxc876.User

class BootStrap {

    def init = { servletContext ->
		
		new User(username:"admin", password:"admin").save();
		
		new Note(text:'Hello this is my note').save();
		new Note(text:'This is another note').save();
    }
    def destroy = {
    }
}
