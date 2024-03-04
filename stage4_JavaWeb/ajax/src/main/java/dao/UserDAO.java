package dao;

import ajax.entity.User;

//UserDAO 继承 BasicDAO , 并指定了User
//就可以使用BasicDAO 中的方法
public class UserDAO extends BasicDAO<User> {
}
