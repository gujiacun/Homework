//���󣺲�����̬�ڲ��࣬�˽���������ص�
//�����ⲿ��
class Outter{
	//�����ⲿ��ľ�̬�ֶ�
	static int age = 20;
	//�����ⲿ���ʵ����Ա
	String name = "����������";
	//������̬�ڲ��࣬��static����
	static class Inner{
		//������̬�ڲ���ľ�̬�ֶ�
		static int age03 = 30;
		//������̬�ڲ����ʵ���ֶ�
		int age02 = 40;
		//��������test
		public void test(){
			//��̬�ڲ����ֱ�ӷ����ⲿ��ľ�̬��Ա
			System.out.println(age);
			System.out.println(age02);
			System.out.println(age03);
			//��̬�ڲ�������ⲿ���ʵ����Ա��ͨ���½��ⲿ��Ķ������
			System.out.println(new Outter().name);
		}
	}
}
//����������
public class StaticInnerClass {
	//����������
	public static void main(String[] args) {
		//������̬�ڲ����ʵ��
		Outter.Inner in = new Outter.Inner();
		in.test();
		//ͨ�������������ʾ�̬�ڲ���ľ�̬�ֶ�
		System.out.println(Outter.Inner.age03);
	}
}
/*
С�᣺������̬�ڲ���Ķ��󣬸�ʽΪ �ⲿ����.�ڲ����� ������ = new �ⲿ����.�ڲ�����([����]);
��ֵ�����ұ�Ϊͨ���ⲿ��������
*/