//������֤�ֶ��Ƿ���ڶ�̬����
//��������
class Father {
	//���������ֶ�
	public int age = 54;
	//�������෽��
	public void life(){
		System.out.println("������");
	}
}
//��������
class Son extends Father {
	//���������ֶΣ��븸���ֶ�ͬ��������
	public int age = 23;
	//�������෽�����븸�෽��ͬ�������ڶ���ʵ����������д
	public void life(){
		System.out.println("�һ�����");
	}
}
//���������࣬FieldTest
public class FieldTest {
	//����������
	public static void main(String[] args) {
		//�Զ�̬��ʽ��������󸳸��������
		Father f = new Son();
		//ͨ����������������ͷ���
		//�ö����������Ϊ���࣬�ڱ���ʱ�ھ����˵��ø����ڴ�ռ�����ݣ���ʾ�����ֶ�
		System.out.println(f.age);
		//������ʱ���ֳ���̬������ִ�������life����
		f.life();
	}
}
/*
С�᣺ע���̬ʱ�������õ���ʾ���⣬�Ͷ�̬ʱ�ֶβ���ʾ��̬���������������ͣ����ࣩ����ʾ
*/