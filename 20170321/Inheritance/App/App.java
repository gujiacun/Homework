//���󣺲������أ����ظ��ྲ̬���������ظ����ֶΣ����ر����ֶβ��������֤
//��������
class Father{
	//���������ֶ�
	protected int age = 0;
	//�������ྲ̬����
	static void kill(){
		System.out.println("���ǰְ�");
	}
}
//��������
class Son extends Father{
	//���������ֶ�
	int age = 1;
	//�������ྲ̬���������ظ�����ͬ����
	static void kill(){
		//��ʱ���෽��������ͬ����������
		System.out.println("���Ƕ���");
	}
	void kill02(){
		//��ʱ�����ֶα������ֶ�����,���������û��age�ֶλ򲻷��ϼ̳з���Ȩ�ޣ����������ageֵ
		//��Ҫ��������б����ص��ֶΣ�super.�ֶ���
		System.out.println(super.age);
	}
	public void kill03(int age){
		//�����˱����е��ֶΣ���ʱ����������������������ֵ������Ҫ����ֶ�ֵ��Ҫ�ڱ�����ǰ����this.
		//System.out.println(age);
		//��������ֶε�ֵ
		System.out.println(this.age);
	}
}
//����һ���࣬��App
public class App {
	//����������
	public static void main(String[] args) {
		//ͨ����������Son���е�kill��̬��������
		Son.kill();
		System.out.println("Hello World!");
		Son s = new Son();
		//����kill02����
		s.kill02();
		//����kill03����
		s.kill03(15);
	}
}
/*
С�᣺static���ܺ�super�Լ�this����.ǰһ�����ε����༶��ģ����������ε��Ƕ��󼶱��
���ص�ǰ���Ƿ��ϼ̳з���Ȩ��
*/