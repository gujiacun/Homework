//������ǰ�����ҵ�У����Կ�����д�����á����������е�ĳһ��������,����ȥ���ø��౻��д�ķ�����
//��������
class Son extends Father{
	//�������๹�������ֶΣ�����
	Son(){
	}
	int lossInUfc = 1;
	//����Son�е�shout�����븸��Father�е�shout����ǩ����ͬ������ֵ������ͬ������Ȩ����ͬ������д
	public void shout(){
		//��Ҫ���ʸ����б���д�ķ�����Ҫ��super.������(ʵ��);  ʵ�������ʡ��
		super.shout();
		System.out.println("I wanna revenge.");
		//����ø��౻���ص��ֶΣ���super.�ֶ���
		System.out.println(super.lossInUfc + "��conor �İܼ�");
	}
}
//��������
class Father{
	//�������๹�������ֶΣ�����
	Father(){
	}
	int lossInUfc = 0;
	public void shout(){
		System.out.println("Timing beats speed,accuracy beats power.");
	}
}
//���������࣬��SuperTest
public class SuperTest {
	//�������������������
	public static void main(String[] args) {
		//�������󣬵���Son�еĳ�Ա
		Son s = new Son();
		//���Son����ֶ�lossInUfc��ֵ
		System.out.println(s.lossInUfc);
		//����Son�е�shout����
		s.shout();
		//System.out.println(s.lossInUfc);
	}
}
/*
С�᣺��סsuper��ʾ��ǰ����ĸ���������ڷ��ʱ�������д�ĸ����еķ��������ʱ��������صĸ�����ֶ�
*/