//���󣺼�סfinal��˼���ֱ������࣬��������̬������ʵ���������ֲ�����
//������Eunuch��������final���Σ��޷����ּ̳�
final class Eunuch{
	int age = 23;
}
//���Դ���Eunuch������,���ִ���: �޷�������Eunuch���м̳�
//class Son extends Eunuch{
//}
//�������࣬��final�����䷽��
class Father{
	//��final���Σ������޷���д
	public final void tell(){
		System.out.println("Hello World!");
	}
}
//��������
class Son extends Father{
	//���뱨������: Son�е�tell()�޷�����Father�е�tell()
	//public void tell(){
		//System.out.println("Hello World!");
	//}
}
class FinalTest {
	public static void main(String[] args) {
		//��final���α���
		final int age = 17;
		//��������Ϊage��ֵ������: �޷�Ϊ���ձ���age����ֵ
		//age = 18;
		System.out.println("Hello World!");
	}
}
//���������࣬���ڿ����в���ı�ĳ����洢���������
class Constant{
	//����ȫ�־�̬����
	public static final int a = 73;
	//���幹������������final����,����: �˴�������ʹ�����η�final
	//final Constant(){
	//}
}
/*
С�᣺���췽������ʹ��final���Σ���Ϊ���췽�����ܱ��̳У��϶������յġ�
������η�֮����û���Ⱥ��ϵ��.
*/