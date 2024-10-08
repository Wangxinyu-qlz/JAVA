package castle.src;

import java.util.HashMap;

public class Room {
	private String description;
//	使用容器（Hash）表示方向，实现"软编码"
	private HashMap<String, Room> exits = new HashMap<String,Room>();

	public Room(String description) {
		this.description = description;
	}

	public void setExit(String dir, Room room) {
		exits.put(dir, room);
	}

	@Override
	public String toString() {
		return description;
	}

	// 返回房间的所有出口
	public String getExitDesc() {
		StringBuffer sb = new StringBuffer();
		for (String dir:exits.keySet()) {
			sb.append(dir);
			sb.append(" ");
		}
		return sb.toString();
	}

	// 说明房间的某个方向有没有东西
	public Room getExit(String direction) {
		return exits.get(direction);
	}
}
