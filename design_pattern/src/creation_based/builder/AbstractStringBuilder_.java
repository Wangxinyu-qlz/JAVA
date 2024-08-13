package creation_based.builder;

import java.util.Arrays;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-13 15:38
 * @description:
 **/
public class AbstractStringBuilder_ {
	protected char[] value;
	protected int count;

	public AbstractStringBuilder_ (int capacity) {
		count = 0;
		value = new char[capacity];
	}

	public AbstractStringBuilder_ append(char c) {
		ensureCapacityInternal(count + 1);
		value[count++] = c;
		return this;
	}

	private void ensureCapacityInternal(int minimumCapacity) {
		if(minimumCapacity - value.length > 0) {
			expandCapacity(minimumCapacity);
		}
	}

	private void expandCapacity(int minimumCapacity) {
		int newCapacity = value.length * 2 + 2;
		if(newCapacity - minimumCapacity < 0) {
			newCapacity = minimumCapacity;
		}
		if(newCapacity<0) {
			if(minimumCapacity < 0) {
				throw new OutOfMemoryError();
			}
			newCapacity = Integer.MAX_VALUE;
		}
		value = Arrays.copyOf(value, newCapacity);
	}
}

