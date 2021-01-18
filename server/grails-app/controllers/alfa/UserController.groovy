package alfa
import grails.converters.JSON
class UserController {
    def index() { }
    def list(int max, int pageNumber) {
        int offset = pageNumber * max
        def listOfUser = User.executeQuery("from User order by email, password",
            [offset:offset, max:max])
        def count = User.count()
        
        int numberOfPages = (count + max - 1) / max
        
        def result = [listOfUser:listOfUser, numberOfPages:numberOfPages]

        render result as JSON
    }

}
