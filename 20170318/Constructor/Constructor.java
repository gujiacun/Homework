//���󣻲������췽����������Ķ��壬�ص㣬���ã�����
//����һ���࣬��Person
class Person{
	String name;
//�����ǿ�ʼ�������Զ��幹�췽��ʱ��ϵͳ���ٸ����Ƿ��乹�췽��
//���췽���ĸ�ʽ��[���η�] ������(��ʽ����){�������;}���췽���ķ�����������������ͬ���޷�������
	Person(String n){
		//��n������ֵ�����ֶ�name�����Ը��ֶ����ó�ʼֵ
		name = n;
		System.out.println(n);
	}
		
}
//����һ���࣬��Constructor
class Constructor {
	//�������������������
	public static void main(String[] args) {
		//�������ڴ���һ����Ķ���ʱ�������ڵ��ù�����
		//���ڴ�ʱPerson�������Զ��幹�췽����������Ҫ����������ڴ�������ʱֱ����������
		Person p = new Person("����������ʿ̸Ц�����ĳ���");
		//���ѹ��췽�����name = n;ע�͵�����n��ֵ������������ʿ̸Ц�����ĳ��ߣ�name��Ĭ��ֵ
		System.out.println(p.name);
		//�����¶��󣬵����޲������췽��
		Overload load1 = new Overload();
		//�����¶��󣬵�����Ϊint���͵Ĺ��췽��
		Overload load2 = new Overload(3);
		//�����¶��󣬵��ò���Ϊint���ͺ�String���͵Ĺ��췽��
		Overload load3 = new Overload(6,"���");
	}
}
//���󣺲����������أ���ʶ�����췽��Ҳ�Ƿ������������뷽����ͬ
//����һ���࣬��Overload
class Overload{
	//���·���Ϊ���أ���ͬһ���࣬��������ͬ�������б�ͬ���뷵��ֵ�����޹�
	Overload(){
		System.out.println("��Ϊ�޲������췽��");
	}
	//���ڶ��ǹ��췽��������д����ֵ����
	Overload(int age){
		System.out.println("�˹��췽������Ϊint����");
	}
	Overload(int age,String name){
		System.out.println("�˹��췽������Ϊint���ͺ�String����");
	}
}
/*
С�᣺���췽���ܴ���������ɶ���ĳ�ʼ�����������Ը��ֶ����ó�ʼֵ��
*/