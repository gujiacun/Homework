//���󣺴�������͸��࣬�ж�̬��ϵ������doWork�ֱ���������࣬���࣬ͬʱ���ڣ���static����ʱ������
//��������
class Father{
	static public void doWork(){
		System.out.println("���ǰְ�!");
	}
}
//��������
class Son extends Father{
	static public void doWork(){
		System.out.println("���Ƕ���!");
	}
}
class MethodCallTest {
	public static void main(String[] args) {
		//����������󣬵������෽���������ö�̬�������������������������͵ĸ���
		Father f = new Son();
		f.doWork();
		System.out.println("Hello World!");
	}
}
/*
С�᣺����ķ���������ķ��������ͬ���ݣ�����Ƚϡ�����������󣬵������෽����
��1��������doWorkͬʱ�����ڸ���������У�����ͨ��,������ʱ��ִ���������͵ķ����������෽��
��2��������doWorkֻ�����ڸ����У�����ͨ��,ִ�и����doWork����.
     Ӧ���ȴ�������ȥ��doWork����,�Ҳ���,��ȥ��������.
��3��������doWorkֻ�����������У��������.����ʱ��,��ȥ��������(SuperClass)�����Ƿ���doWork������
     ����f�ı�������������Father�ģ�����doWork������ȥ��������
��4����static���β�ͬʱ���ڸ���������ʱ��ͨ��������þ�̬������
	 �ڵײ���ͨ�����������෽�������ڶ���f�ı���������Father�����õ��Ǹ��ྲ̬����
*/