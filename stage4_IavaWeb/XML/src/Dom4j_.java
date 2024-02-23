import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class Dom4j_ {
	/*演示如何加载XML文件*/
	@Test
	public void loadXml() throws DocumentException {
		SAXReader reader = new SAXReader();
		//代码技巧->debug查看document对象的成员属性
		/*
		 * document
		 * rootElement->[\n, s1, \n\n, s2, \n]->s1:[\n, name, ......]
		 * */
		Document document = reader.read(new File("src/students.xml"));
		System.out.println(document);
	}

	/*遍历所有的student的信息
	 * */
	@Test
	public void listStudents() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/students.xml"));
		//	1.得到rootElement
		Element rootElement = document.getRootElement();
		//	2.得到rootElement的student的Element
		List<Element> students = rootElement.elements("student");
		System.out.println(students.size());//2
		for (Element student : students) {//element就是Student元素/节点
			//	获取Student元素的name元素
			Element name = student.element("name");
			Element gender = student.element("gender");
			Element age = student.element("age");
			Element resume = student.element("resume");
			System.out.println("学生信息：" + name.getText() + " " + gender.getText()
					+ " " + age.getText() + " " + resume.getText());
		}
	}

	/*
	 * 指定读取第一个学生的信息
	 * */
	@Test
	public void readOne() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/students.xml"));
		//	1.得到rootElement
		Element rootElement = document.getRootElement();
		//	2.获取第一个学生
		Element student = (Element) rootElement.elements("student").get(0);
		//	3.输出该学生的信息
		Element name = student.element("name");
		Element age = student.element("age");
		Element gender = student.element("gender");
		Element resume = student.element("resume");
		System.out.println("学生信息：" + name.getText() + " " + gender.getText()
				+ " " + age.getText() + " " + resume.getText());
		//	4.获取student元素的属性
		System.out.println(student.attributeValue("id"));//01
	}

	/**
	 * 加元素(要求: 添加一个学生到xml 中) [不要求，使用少，了解]
	 *
	 * @throws Exception
	 */
	@Test
	public void add() throws Exception {

		//1.得到解析器
		SAXReader saxReader = new SAXReader();
		//2.指定解析哪个xml 文件
		Document document = saxReader.read(new File("src/students.xml"));

		//首先我们来创建一个学生节点对象
		Element newStu = DocumentHelper.createElement("student");
		Element newStu_name = DocumentHelper.createElement("name");
		//如何给元素添加属性
		newStu.addAttribute("id", "04");
		newStu_name.setText("宋江");
		//创建age 元素
		Element newStu_age = DocumentHelper.createElement("age");
		newStu_age.setText("23");
		//创建resume 元素
		Element newStu_intro = DocumentHelper.createElement("resume");
		newStu_intro.setText("梁山老大");

		//把三个子元素（节点）加到 newStu 下
		newStu.add(newStu_name);
		newStu.add(newStu_age);
		newStu.add(newStu_intro);
		//再把newStu 节点加到根元素
		document.getRootElement().add(newStu);
		//直接输出会出现中文乱码:
		OutputFormat output = OutputFormat.createPrettyPrint();
		output.setEncoding("utf-8");//输出的编码utf-8

		//把我们的xml 文件更新
		// lets write to a file
		//new FileOutputStream(new File("src/myClass.xml"))
		//使用到io 编程 FileOutputStream 就是文件字节输出流
		XMLWriter writer = new XMLWriter(
				new FileOutputStream(new File("src/students.xml")), output);
		writer.write(document);
		writer.close();

	}

	/**
	 * //删除元素(要求：删除第一个学生) 使用少，了解
	 *
	 * @throws Exception
	 */
	@Test
	public void del() throws Exception {
//1.得到解析器
		SAXReader saxReader = new SAXReader();
//2.指定解析哪个xml 文件
		Document document = saxReader.read(new File("src/students.xml"));
//找到该元素第一个学生
		Element stu = (Element)
				document.getRootElement().elements("student").get(2);
//删除元素
		stu.getParent().remove(stu);
// //删除元素的某个属性
// stu.remove(stu.attribute("id"));
//更新xml
//直接输出会出现中文乱码:
		OutputFormat output = OutputFormat.createPrettyPrint();

		output.setEncoding("utf-8");//输出的编码utf-8
//把我们的xml 文件更新
		XMLWriter writer = new XMLWriter(
				new FileOutputStream(new File("src/students.xml")), output);
		writer.write(document);
		writer.close();
		System.out.println("删除成功~");

	}

	/**
	 * //更新元素(要求把所有学生的年龄+3) 使用少，了解
	 *
	 * @throws Exception
	 */
	@Test
	public void update() throws Exception {

//1.得到解析器
		SAXReader saxReader = new SAXReader();
//2.指定解析哪个xml 文件
		Document document = saxReader.read(new File("src/students.xml"));

//得到所有学生的年龄
		List<Element> students = document.getRootElement().elements("student");
//遍历, 所有的学生元素的age+3
		for (Element student : students) {
//取出年龄
			Element age = student.element("age");
			age.setText((Integer.parseInt(age.getText()) + 3) + "");

		}

//更新
//直接输出会出现中文乱码:
		OutputFormat output = OutputFormat.createPrettyPrint();
		output.setEncoding("utf-8");//输出的编码utf-8

//把我们的xml 文件更新
		XMLWriter writer = new XMLWriter(
				new FileOutputStream(new File("src/students.xml")), output);
		writer.write(document);
		writer.close();
		System.out.println("更新成功~");

	}
}
