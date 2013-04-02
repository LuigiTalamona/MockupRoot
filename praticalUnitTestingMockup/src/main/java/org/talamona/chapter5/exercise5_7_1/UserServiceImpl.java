package org.talamona.chapter5.exercise5_7_1;

/**
 *
 * @author luigi
 */
class UserServiceImpl implements UserService {

    private UserDAO dao;
    private SecurityService securityService;

    public UserServiceImpl() {
    }

    public void setDao(UserDAO dao) {
        this.dao = dao;
    }

    public void setSecurityService(SecurityService ss) {
        this.securityService = ss;
    }

    public void assignPassword(User user) throws Exception {
        String newPwd = this.securityService.md5(user.getPassword());
        if (newPwd != null) {
            user.setPassword(newPwd);
            this.dao.updateUser(user);
        } else {
            throw new NullPointerException();
        }

    }
}
