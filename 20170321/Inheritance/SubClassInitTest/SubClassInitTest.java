//���������ʼ��������super�����๹������,ȥ���ø��๹����

//��������
class Father{
	//���������޲ι�����
	Father(){
		System.out.println("I am your father.");
	}
}
//��������,��סһ����ؾ��Ա���Ҫдextends Father������super();����޷�ִ��
class Son extends Father{
	//���������޲ι�����
	Son(){
		//��super���ø����е��޲ι��췽������Ҫע�⣬���췽������д���ķ�����������ͨ����Ҫ
		super();
		System.out.println("You are not my father!");
	}
}
//���������࣬SubClassInitTest
public class SubClassInitTest {
	//����������
	public static void main(String[] args) {
		//����Son�Ĺ��췽��
		Son s = new Son();
	}
}
/*
С�᣺super������췽��������д���ķ����������������ͨ������Ҫд������
*/