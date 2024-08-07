/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-07 23:02
 * @description:
 **/
public class Clone_ {
	public static void main(String[] args) {
		PersonClone personClone = new PersonClone(new Address("武汉"));
		PersonClone personClone_ = personClone.clone();

		System.out.println(personClone==personClone_);//false
		//TODO 如果Person.clone()没有复制Address：true
		//     如果Person.clone()复制Address：false
		System.out.println(personClone.getAddress()
				== personClone_.getAddress());
	}
}

class Address implements Cloneable {
	private String name;

	public Address(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Address clone() {
		try {
			Address clone = (Address) super.clone();
			// TODO: 复制此处的可变状态，这样此克隆就不能更改初始克隆的内部项
			return clone;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}
}

class PersonClone implements Cloneable {
	private Address address;

	public PersonClone(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	//personClone.getAddress() == personClone_.getAddress()
	//@Override
	//public PersonClone clone() {
	//	try {
	//		PersonClone person = (PersonClone) super.clone();
	//		return person;
	//	} catch (CloneNotSupportedException e) {
	//		throw new RuntimeException(e);
	//	}
	//}

	//personClone.getAddress() != personClone_.getAddress()
	@Override
	public PersonClone clone() {
		try {
			PersonClone person = (PersonClone) super.clone();
			//TODO 这里将Person内部的 Address 对象也复制了
			person.setAddress(person.getAddress().clone());
			return person;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

}