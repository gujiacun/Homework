//���󣺲���this�ؼ��֣�����this�����ã��ڹ��췽���б�ʾ��ǰ�����Ķ����ڷ����б�ʾ����this���ڵķ����Ķ���
//�����ͬһ���У���Ա�����;ֲ������Ķ�����
//ͬ���У�ʵ����������
//���췽�����صĻ���
//������װ��Person
class Person{
	//����ʵ������,��private����
	private int age;
	private String name;
	//���ڱ�private���Σ����Է���ֻ��ͨ��setter/getter
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		//����ʵ��������ֲ��������������������󲻷���Ҫ��this����ʵ������
		//this�ڷ���setAge�У���ʾ���ǵ��ô˷����Ķ���,�Ѵ�������ݸ�ֵ���ֶ�age
		this.age = age;
	}
	//����һ��ʵ������
	public void shout(){
		System.out.println("������������ʿ����֪�������Ǹߵ�����ȥ��");
	}
	//��ͬһ���д�����һ��ʵ������������this������һ������
	public void say(){
		//ͬ����ʵ�������以��,��ʽ��this.������(�����б�);
		this.shout();
		System.out.println("������ۼ��ߣ��ܵÿ�");
	}
}
//������װ��People
class People{
	//��д�������صĹ��췽��
	//��סҪдһ���ղ����Ĺ��췽��
	public People(){
		System.out.println("��������");
	}
	//дһ����һ�������Ĺ��췽��
	public People(int age){
		//��this������ǰһ�����췽����ע������б�һ��
		//����ǰһ�����췽���޲��������Բ���Ϊ��
		//���������صĻ�����this([����])����д�ڹ��췽����һ��;
		this();
		System.out.println("����������");
	}
	//дһ�������������Ĺ��췽��
	public People(int age,String name){
		//��this������ǰһ�����췽����ע������б�һ��
		//����ǰһ�����췽����һ�����������Բ���Ϊ��
		//���������صĻ�����this([����])����д�ڹ��췽����һ��;
		this(age);
		System.out.println("������������");
	}
}
//���������࣬��ThisTest
public class ThisTest {
	//����������
	public static void main(String[] args) {
		//��������
		Person p = new Person();
		//ΪPerson���е��ֶ�age��������,����set����ʱ�����б�Ҫ��set�����Ĳ����б�һ��
		p.setAge(28);
		//ͨ���������Person���еķ���������ֶ�age������
		System.out.println(p.getAge());
		//ͨ������p����say����
		p.say();
		//����People�Ķ��󣬵���������ͬʱҲ�ǵ��ù��췽����������������ֱ�Ӵ������
		People man = new People(28,"Ϊ����ǿ�д��봺��ֱ���ֳ�");
		//��ʽ2: new  Xxx(String str):
         Integer i2= new Integer("123");
     //�Ѱ�װ�����ת��ΪString.
        String  str =  i2.toString();
System.out.println(str);
	}
}
/*
С�᣺�Ժ�����ʼ�ʱע������ؼ��ֻ�֪ʶ��ʹ��ʱ�ĸ�ʽ���Ѹ�ʽ����Ӳ������
������ֻ�ܵ���һ�����صĹ�����
*/