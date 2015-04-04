import com.augurworks.crawler.Role
import com.augurworks.crawler.User
import com.augurworks.crawler.UserRole

class BootStrap {
	
	def createUser(name, password, role) {
		def me = new User(username: name, password: password, enabled: true).save()
		UserRole.create(me, role, true)
	}

    def init = { servletContext ->
		println 'Bootstrapping'
		def adminRole = new Role(authority: "ROLE_ADMIN").save()
		def userRole = new Role(authority: "ROLE_USER").save()
		createUser('admin', 'crawler!admin', adminRole)
		createUser('user', 'crawler!user', userRole)
    }
    def destroy = {
		
    }
}
