//���󣺽��л����������ͣ���װ��Ķ����String���͵Ļ���ת��
//�����࣬��WrapperClassTest
public class WrapperClassTest {
	//����������
	public static void main(String[] args) {
		//������������ת��Ϊ��װ��Ķ���
		//����һ�������������Ͱ�װ��.valueOf(����)����ʾ���ð�װ���еķ���
		Character c = Character.valueOf('B');
		System.out.println(c);
		//��������new �����������Ͱ�װ��(����)����ʾ�½�һ����װ��Ķ���
		Character c02 = new Character('9');
		System.out.println(c02);

		//��װ��Ķ���ת��Ϊ������������
		//��ʽ��������.������������Value();ͨ������������Ӧ�İ�װ���еķ���
		char i = c.charValue();
		System.out.println(i);

		//������������ת��ΪString����
		//����һ��String.valueOf(����);��ʾ����String���еķ���
		String str01 = String.valueOf(15);
		System.out.println(str01);
		//�������������������Ͱ�װ��.toString(����);��ʾ���ð�װ���еķ���
		String str02 = Integer.toString(365);
		System.out.println(str02);

		//String����ת��Ϊ������������
		//��ʽ�������������Ͱ�װ��.parse������������(����)
		int num = Integer.parseInt("123");
		System.out.println(num);

		//String����ת��Ϊ��װ��Ķ���
		//����һ�������������Ͱ�װ��.valueOf(����);��ʾ���ð�װ���еķ���
		int num02 = Integer.valueOf("987");
		System.out.println(num02);
		//����: �����ݵ�����: String�޷�ת��Ϊchar
		//Character ch = Character.valueOf("a");
		//��������new �����������Ͱ�װ��(����);��ʾ�½�һ����װ��Ķ���
		//����: �����ݵ�����: String�޷�ת��Ϊchar
		//Character ch = new Character("a"); 
		Integer num03 = new Integer("3695");
		System.out.println(num03);

		//��װ��Ķ���ת��ΪString����
		//��ʽ������.toString();���ð�װ���еķ���
		Character charTest = '3';
		//String str03 = charTest.toString();��д���������ʽ
		String str03 = Character.toString(charTest);
		System.out.println(str03);
	}
}
/*
С�᣺�����ǵ��÷������������췽��������IDE�п�����������
*/