package alfa

class BootStrap {

    def init = { servletContext ->
        if(User.count()==0){
            new User(id: 1, email: 'test@gmail.com', password: 'test123456').save();
        }
    }
    def destroy = {
    }
}
