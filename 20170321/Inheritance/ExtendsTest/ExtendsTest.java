//���󣺲���extend�ؼ��֣���ס����Ķ����ʽ
//�������࣬Father
class Father{
	//���������Ա
	public int age = 1;
	String hobbit = "����������̸Ц������ŭ����ۼ���";
	protected void tell(){
		System.out.println("�ܲ�����ֻ����һ��΢С�Ĺ���");
	}
}
public class ExtendsTest {
	//����������
	public static void main(String[] args) {
		//����son��Ķ��󣬲��������еķ���
		Son s = new Son();
		s.say();
		System.out.println("Hello World!");
	}
}
//��������son,��ʽΪ[���η�] class Subclass extends SuperClass{} 
class Son extends Father{
	//��������̳��˸���ĳ�Ա����˽�к͹��췽���⣩�����Կ��Խ��е���
	protected void say(){
		super.tell();
		System.out.println("��" + age + "��," + hobbit);
	}	
}
/*
С�᣺��ͨ���������ʵ������ʱ����ʽΪ����.������(ʵ��);ʵ�ο����ʡ�ԣ����Ų���ʡ��
*/