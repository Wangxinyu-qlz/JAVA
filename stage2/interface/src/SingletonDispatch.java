/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2025-02-27 16:52
 * @description:
 **/

// 演示 Java 是 single dispatch 的。
abstract class Shape {}

class Circle extends Shape {}

class Rectangle extends Shape {}

class Triangle extends Shape {}

abstract class AbstractResizer
{
	public abstract void resize(Circle c);
	public abstract void resize(Rectangle r);
	public abstract void resize(Shape s);
	public abstract void resize(Triangle t);
}

class Resizer extends AbstractResizer
{
	public void resize(Circle c) { System.out.println("缩放圆形"); }
	public void resize(Rectangle r) { System.out.println("缩放矩形"); }
	public void resize(Shape s) { System.out.println("缩放任意图形"); }
    public void resize(Triangle t) { System.out.println("缩放三角形"); }
}

public class SingletonDispatch
{
	public static void main(String[] args)
	{
		AbstractResizer resizer = new Resizer();
		Shape[] shapes = {new Circle(), new Rectangle(), new Triangle()};
		/**
		 * 缩放任意图形
		 * 缩放任意图形
		 * 缩放任意图形
		 */
		for (Shape shape : shapes)
		{
			resizer.resize(shape);
		}
	}
}
