// 需求：主板接收来自IUSB设备（键盘，鼠标）的插入，工作和拔出
// 在工作方法中
package review;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MotherBorad {
	// 创建一个容器，用来装载所有的IUSB设备，key为设备名字，value为设备的类型
	Map<String, IUSB> map = new HashMap<String, IUSB>();

	// 创建插口的插入方法，要求输入设备名字（key），设备的类型（value）
	public void install(String name, IUSB usb) {
		map.put(name, usb);
	}

	// 进行工作
	public void doWork() {
		// 创建一个Set集合来接收key值，返回所有设备的名字形成的数组
		Set<String> set = map.keySet();
		// 通过循环获取每个设备的名字（Map的每一个key）
		for (String s : set) {
		    // 通过key获得value
			IUSB usb = map.get(s);
			usb.swapData();

		}
	}
	// 插口拔出方法
	public void unistall(String name){
		if(map.containsKey(name)){
			map.remove(name);
		}
	}
}
	/**
	 * 小结：以后多用集合，深刻理解各个集合之间的特性，用可读性更强，性能更高的写法来实现功能
	 */
