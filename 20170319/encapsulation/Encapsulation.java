//���󣺰Ѵ��밴��JavaBean�淶����д��ͬʱ����private��getter��setter
//������װ�࣬��Person���洢�ֶκͷ���
class Person{
	//������һ��public���ε��޲ι�����
	public Person(){

	}
	//���е��ֶα�����private����
	private int age;
	//���е��ֶζ�Ҫ�����ṩһ��getter/setter����
	//get������ʽ��public �������� get�ֶ�(){
	//					return �ֶ���;
	//				}
	public int getAge(){
		return age;
	}
	//set������ʽ��public void set�ֶ���(�������� �β���){
	//					�ֶ��� = �β���;
	//				}
	public void setAge(int a){
		if(a < 0){
			System.out.println("����������");
		}
		age = a;
	}
	private String name;
	public String getName(){
		return name;
	}
	public void setName(String n){
		name = n;
	}
	//������������������ֶ�age���
	public void tell() {
        System.out.println("���g��" + getAge() + " ������" + getName());
    }
}
//����һ�������࣬ͬʱ��public������
public class Encapsulation {
	//����������
	public static void main(String[] args) {
		//�ȴ���һ������
		Person p = new Person();
        // p.age = 30;//�޷�����
        // ͨ��"����.set�ֶ���(ʵ��)"�����Å���
        p.setAge(30);
		p.setName("��ۼ����ű���");
		p.tell();
	}
}
/*
С�᣺private: ��ʾ˽�е�, ��ʾ�����Ȩ��. ֻ���ڱ����з���,�뿪����֮��,�Ͳ���ֱ�ӷ���.
��סsetter��getter�������������ر���
*/