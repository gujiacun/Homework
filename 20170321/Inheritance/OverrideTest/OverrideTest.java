//�����������в�����д��������ӡ��֤
class Son{
	//��д�����е�kill����
	public void kill(){
		System.out.println("����jose aldo�����ְ�13���ս�");
	}
}
//��������class����Father
class Father{
//�ڸ��ഴ������
	protected void kill(){
		System.out.println("����conor mcgregor����jose aldo�ְ�");
	}
}
//�����࣬��OverrideTest
public class OverrideTest {
	//�������������������
	public static void main(String[] args) {
		System.out.println("Hello World!");
		//����Son�Ķ���s��ͨ��������kill����
		Son s = new Son();
		s.kill();
	}
}
/*
С�᣺��д�������붼��ʵ����������̬�����ǽ����أ�ע������
����д�����У�ʵ������ǩ��������ͬ�����෽���ķ���Ȩ��Ҫ���ڵ��ڸ��෽��
���������ǽ������̳и���֮��,��������ĳ����������������ľ�������,��ʱ��Ҫ������������д����.

*/