//���󣺲��������������͵�ת����ϵ������ instanceof �����
//��������
class Animal{

}
//��������
class Dog extends Animal{

}
//����������InstanceOfTest
class InstanceOfTest {
	//����������
	public static void main(String[] args) {
		//�Զ�����ת�������������ͱ���ת��Ϊ�������ͱ���
		//Dog d = new Dog();
		//Animal a = new Animal();
		//a = d;
		//�������пɺϲ�Ϊ����һ��
		Animal a = new Dog();
		//�Զ�����ת�����Ƕ�̬����������󸳸��������������ʱ������������
		System.out.println("Hello World!");
		//ǿ������ת�����Ѹ������Ͷ��󸳸��������ͱ���
		Dog d = (Dog)a;
		//���� instanceof ��������ж϶���a�Ƿ�����Dog���ͺ�Animal����
		System.out.println(a instanceof Dog);
		System.out.println(a instanceof Animal);
		//ʹ��getClass()�������õ�����a����ʵ���ͣ����Ǳ�������
		System.out.println(a.getClass() == Dog.class);
		System.out.println(a.getClass() == Animal.class);
	}
}
/*
С�᣺�����ڶ�̬�У������ڱ���ʱ�Ǳ������ͣ�������ʱ����ʵ�����ͣ�instanceof�ж϶����Ƿ���
ĳ�����͵�ʵ����getClass()�����õ��������ʵ����
*/