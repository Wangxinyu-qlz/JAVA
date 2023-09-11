/**
 * @author qiaolezi
 * @version 1.0
 */
public class Homework02 {
	public static void main(String[] args) {
		Mail mail1 = new Mail("qwe1", "123451", "1234@qq.com");
		System.out.println(mail1.getName() + mail1.getPwd() + mail1.getMail());
	}
}

class Mail {
	private String name;
	private String pwd;
	private String mail;

	public Mail(String name, String pwd, String mail) {
		if(!(name.length() >= 2 && name.length() <= 4)) {
			throw new RuntimeException("名字长度必须为2~4个字符");
		} else {
			this.name = name;
		}
		if(!(pwd.length() == 6 && isDigital(pwd))) {
			throw new RuntimeException("密码必须为6位数字");
		} else {
			this.pwd = pwd;
		}
		int i = mail.indexOf('@');
		int j = mail.indexOf('.');
		if (!(i > 0 && j > i)) {
			throw new RuntimeException("邮箱格式不正确！");
		} else {
			this.mail = mail;
		}
	}

	private boolean isDigital(String pwd) {
		char[] chars = pwd.toCharArray();
		for (char aChar : chars) {
			if (aChar < '0' || aChar > '9') {
				return false;
			}
		}
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}