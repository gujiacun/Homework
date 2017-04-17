//���󣺲���enum���������������˽��ص㣬ʹ�ó��÷���
//����һ��	��,ʹ��һ������restday����ʾ����һ����Ϣ
//����һ���½��࣬��int���ͱ�ʾ����һ����
class Person{
	private int restday;
	public int getRestday(){
		return restday;
	}
	public void setRestday(int restday){
		this.restday = restday;
	}
}
//������������ҵ������ģ�������Ͳ���ȫ��int�м������ݣ�����ֻ��7�����ݣ��Ľ�Ϊ
//ר�Ŵ��������洢���ڣ���ֹ����
class Weekday{
	//˽�л�����������ֹ�����¶���
	private Weekday(){
	}
	//����7�����󣬴��������������ݣ�ͬʱ��final���Σ���ֹ������
	//��static���Σ�����ֱ������������
	static final Weekday MONDAY = new Weekday();
	static final Weekday TUESDAY = new Weekday();
	static final Weekday WEDNESDAY = new Weekday();
	static final Weekday THURSDAY = new Weekday();
	static final Weekday FRIDAY = new Weekday();
	static final Weekday SATURDAY = new Weekday();
	static final Weekday SUNDAY = new Weekday();
}
class Person02{
	//ֻ�ܴ���Weekday���������ݣ���private�޶�����Ȩ��
	private Weekday restday;
	public Weekday getRestday(){
		return restday;
	}
	//Weekday����������
	public void setRestday(Weekday restday){
		this.restday = restday;
	}
}

//�����Ѿ��ն��ˣ�����ö����
enum Weekend{
	MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY;
	//���幹�췽��
	Weekend(){
	}
	//�����Ա����
	int age = 10;
	//������ͨ����
	public void way(){
		System.out.println("233");
	}

}
class Person03{
	//ֻ�ܴ���Weekend���������ݣ���private�޶�����Ȩ��
	private Weekend restday;
	public Weekend getRestday(){
		return restday;
	}
	//Weekday����������
	public void setRestday(Weekend restday){
		this.restday = restday;
	}
}
//����������
public class EnumTest {
	//��������
	public static void main(String[] args) {
		//����������������
		Person p = new Person();
		p.setRestday(3);
		int result = p.getRestday();
		System.out.println(result);
		Person02 pp = new Person02();
		//������������Weekday���Ƕ�������Ҫ����������
		pp.setRestday(Weekday.TUESDAY);
		//�޷�ʵ����ö������
		//Weekend w = new Weekend();
		//w.way();
		//����ö���ж���ȫ�ֹ�����̬��������������������
		System.out.println(Weekend.MONDAY);
		//����Enum���еķ���
		//����ö�ٶ���ĳ�������
		System.out.println(Weekend.MONDAY.name());
		//����ö�ٶ�������,��0��ʼ.
		System.out.println(Weekend.SUNDAY.ordinal());
		//����ö�ٶ���ĳ�������
		System.out.println(Weekend.SUNDAY.toString());
		//��һ��ָ�������ַ���ת��Ϊ��ǰö������ͬ���ĳ���
		Weekend day = Weekend.valueOf("SUNDAY");
		//���ص�ǰö���������еĳ���,ʹ��һ�������װ����
		Weekend[] array = Weekend.values();
		//��for each ѭ����ӡ����Ԫ��
		for(Weekend x : array){
			System.out.print(x);
			System.out.print(" , ");
		}
	}
}
/*
С�᣺ö���Ƕ���̶��ĳ�������ļ��ϣ���public static final ���εĶ���
*/