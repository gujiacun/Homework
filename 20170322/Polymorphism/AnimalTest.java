//�������벢��������̬�ĸ��ʹ�ö�̬�ĸ�ʽ��֪����̬��ǰ��
//������AnimalTest
public class AnimalTest {
	//����������
	public static void main(String[] args) {
		//����Ӷ�˶���
		Servant s = new Servant();
		//�������������ö�̬��Animal�Ǳ������ͣ�Dog����������
		Animal a = new Dog();
		//ͨ������s����feed�������������a����ʱ��ʾDog
		s.feed(a);
		//����è�������ö�̬��Animal�Ǳ������ͣ�Cat����������
		a = new Cat();
		//ͨ������s����feed�������������a����ʱ��ʾCat
		s.feed(a);
	}
}
//��������Animal
class Animal{
	//���ﹲͬ��״̬
	public void eat(){
		System.out.println("����ÿ���ʳά������");
	}
}
//��������Dog
class Dog extends Animal{
	//���Ƕ����е����࣬ʳ������������
	public void eat(){
		System.out.println("���Թ���");
	}
}
//��������Cat
class Cat extends Animal{
	//���Ƕ����е����࣬ʳ������������
	public void eat(){
		System.out.println("è��è��");
	}
}
//����һ���࣬��Servant
class Servant{
	//Ӷ�˸���ι����èʳ��
	public void feed(Animal a){
		//���û�ж�̬��Servant���feed������Ҫ�������أ��ֱ��ӦCat�Ķ����Dog�Ķ���
		System.out.println("Ӷ�˸�����ιʳ��");
		//���ݸ���Animal�ı���a�����ò�ͬ��eat��������ʱ����͸����з�����д����
		a.eat();
	}
}
/*
С�᣺��̬��Ĩƽ��ͬ���������֮��Ĳ��죬�����ǵ����������������
*/