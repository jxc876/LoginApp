import com.jxc876.Note

class BootStrap {

    def init = { servletContext ->
		
		new Note(text:'Hello this is my note').save();
		new Note(text:'This is another note').save();
    }
    def destroy = {
    }
}
