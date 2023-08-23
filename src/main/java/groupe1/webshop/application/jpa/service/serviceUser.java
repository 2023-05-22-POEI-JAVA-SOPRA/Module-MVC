package groupe1.webshop.application.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groupe1.webshop.application.jpa.dao.UserDao;
import groupe1.webshop.application.jpa.entity.User;

@Service
public class serviceUser {

	@Autowired
	private UserDao monUserDao;

	public List<User> getAll() {
		return this.monUserDao.findAll();
	}

	/**
	 * @param login
	 * @return
	 */
	public List<User> getByLoginContainingIgnoreCase(String login) {
		if (login == null) {
			return getAll();
		}
		return this.monUserDao.findByLoginContainingIgnoreCase(login);
	}

	/**
	 * @param id
	 * @return
	 */
	public Optional<User> getById(Integer id) {
		return this.monUserDao.findById(id);
	}

	/**
	 * @param user
	 * @return
	 */
	public User save(User user) {
		return this.monUserDao.save(user);
	}

	/**
	 * @param id
	 */
	public void deleteById(Integer id) {
		this.monUserDao.deleteById(id);
	}
}
