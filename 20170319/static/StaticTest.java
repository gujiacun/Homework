//���������ļ��в���static���η�����֤��static���εĳ�ԱΪ���Ա�������౾��
//û��static���εĳ�ԱΪʵ����Ա�����ڶ���
//����һ����װ�࣬��Static
class Static{
	//�����ֶ�age�ͷ���method������static���Σ���ʾ������Ա�����౾��
	static int age;
	//�ڷ����д�������a���ܴ����ֵ
	static void method(int a){
		//�������a��ֵ�����ֶ�age
		age = a;
		//����ֶ�age��ֵ
		System.out.println(age);
	}
	//�ڷ����д���ʵ����Ա,����static���Σ���ʾ���ڶ���
	int age1;
	void method01(int b){
		//��b��ֵ�����ֶ�age1
		age1 = b;
		System.out.println(age1);
	}
}
//����һ�������࣬��StaticTest
public class StaticTest {
	//����������
	public static void main(String[] args) {
		//�������Ա����ʽΪ����.���Ա;�����Աage��ֵ30
		Static.age = 30;
		//��ӡ�ֶ�age��ֵ
		System.out.println(Static.age);
		//������StaticTest�Ķ���
		Static s = new Static();
		//ͨ������s������Static�е���������ʵ������
		int num = s.age1;
		//��������Static�л�û�и��ֶ�age1��ֵ�������������Ĭ��ֵ0
		System.out.println(num);
		//ͨ������s�������е�ʵ������method01����ֵ���������
		s.method01(63);
		//���������а�b��ֵ63����age1�������������s1��ֵΪ63
		System.out.println(s.age1);
		//ͨ������s�������Աmethod,���3�����ڵײ���Ȼ��ͨ�������������Ա
		s.method(3);
	}
}
/*
С�᣺���Աֻ�ܷ������Ա��ʵ����Աֻ�ܷ���ʵ����Ա�������ڵײ�ͨ���������������Ա��
*/