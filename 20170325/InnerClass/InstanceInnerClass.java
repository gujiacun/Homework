//������Ϥʵ���ڲ���Ķ��巽�����ص�
//����һ����
class Father{
	//�����ⲿ����ֶΣ�������ʵ���ڲ���
	int age = 23;
	void say(){
		System.out.println("��������дbug�ˣ�");
	}
	//û��static���Σ������ⲿ���ʵ�������Խ�ʵ���ⲿ��
	class Son{
		//�����ڲ����ֶΣ�����
		int age = 33;
		//��ʵ���ڲ����г��Զ��徲̬��Ա,����: �ڲ���Father.Son�еľ�̬�����Ƿ�
		//static int age1 = 0;
		void say(){
			System.out.println("��������debug");
			//���������ڵľֲ�����
			int age = 43;
			System.out.println(age);//��������ڵľֲ�����
			System.out.println(this.age);//����ڲ����ֶ�
			System.out.println(Father.this.age);//����ⲿ����ֶ�
			//this.say();
		}
	}
}
//����������,��InstanceInnerClass
public class InstanceInnerClass {
	//����������
	public static void main(String[] args) {
		//����Ҫ����ʵ���ڲ�����ֶ�,����Ҫ�������Ķ���
		//����ʵ���ڲ������ⲿ������ʵ���ֶΣ�ʵ������ͬ����Ҫͨ���ⲿ��Ķ���������
		//����Ҫ�ȴ��ⲿ��Ķ���
		Father f = new Father();
		//ͨ���ⲿ���������ڲ���Ĺ��췽����������ߵ��ⲿ��.�ڲ��� ������
		Father.Son s = f.new Son();
		//System.out.println(s.age);
		//��������ɼ�дΪ
		Father.Son s2 = new Father().new Son();
		//System.out.println(s2.age);
		//����Son�е�say����,��֤���ⲿ���ֶΣ��ڲ����ֶκ��ڲ��෽������ͬ��ʱ�ķ��ʷ�ʽ
		s2.say();
		//ͨ���ⲿ���ʵ�������ⲿ����ֶκͷ���
		f.say();
		System.out.println("Hello World!");
		//Random random = new Random();
		//int num09 = random.nextInt(10);
		//System.out.println(num09);
	}
}
/*
С�᣺ʵ���ڲ��࣬������static���Σ�����������ֱ�ӷ����ⲿ���Ա��Ҫ�����ⲿ����ֶΣ�
���ⲿ����.this.�ⲿ���ֶ���
�μǴ���ʵ���ⲿ��Ķ����ʽ  �ⲿ����.�ڲ����� ������ = new �ⲿ����().�ڲ�����([�����б�]);
*/