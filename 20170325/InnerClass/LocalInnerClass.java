//���󣺲����ֲ��ڲ���
//�½���
class Outter{
	//�½��ⲿ������г�Ա
	//int age = 10;
	static String name = "123";
	//�½�����
	public void method(){
		//�½��ֲ����������ڲ�����ʵľֲ���������ʹ��final����
		//����java8�еײ��Զ����final
		int age = 10;
		//�½��ڲ��࣬��ʵ�鲻��ʹ��public,private,protected,static����
		class Inner{
			//�����ھֲ��ڲ����н���̬��Ա,����
			//static int age = 20;
			//�ֲ��ڲ������ֱ�ӷ����ⲿ��ĳ�Ա
			void test(){
				System.out.println(age);
				System.out.println(name);
			}
		}
		//�ֲ��ڲ���ֻ���ڵ�ǰ������ʹ��,���ⲿ��ķ����д����ڲ���Ķ��󣬵��÷���
		new Inner().test();
	}
}
//����������
public class LocalInnerClass {
	//����������
	public static void main(String[] args) {
		//�½��ڲ���Ķ���,����ʹ���䷽����ʧ�ܣ���ֲ��ڲ���ֻ���ڵ�ǰ������ʹ��
		//new Inner().test();
		Outter out = new Outter();
		//�����ⲿ��Ķ��󣬵��÷����������ڲ��ᴴ���ֲ��ڲ�����󲢵��þֲ��ڲ���ķ���
		out.method();
		System.out.println(Math.E);
	}
}
/*
С�᣺�ֲ��ڲ���������ڲ��඼Ҫ������һ�����ڲ���һ�������ڲ�
�ֲ��ڲ���ֻ���ڵ�ǰ������ʹ�ã�Ҫͨ���ⲿ���ڷ����ڲ��½��ڲ���Ķ�����ͨ���ڲ���Ķ����������ķ���
*/