//���󣺲�����װ���װ�䣬���估���Զ�����ʹ��switch��䣬��װ��ĳ����ͳ��÷���
//�����࣬��classTest
public class classTest {
	//����������
	public static void main(String[] args) {
		//װ�䣬���ѻ����������ͱ���ת��Ϊ��װ��Ķ���
		byte b = 15;
		Byte num02 = b;
		//Ҳ��дΪ
		Byte num020 = new Byte((byte)15);
		Byte num021 = Byte.valueOf((byte)15);
		System.out.println(num02);
		//���䣬���Ѱ�װ��Ķ���ת��Ϊ�����������ͱ���
		int num01 = num02.intValue();
		System.out.println(num01);
		//�Զ�װ��Ͳ���
		//ע�����д��������ֺ�Ҫ��L��l
		Long num03 = 32L;
		//���д�����Ϊ�Զ�����ֻ����Ѱ�װ�����ֱ�Ӹ�����Ӧ�Ļ����������ͱ���
		//int num04 = num03;
		long num04 = num03;
		Integer num05 = Integer.valueOf(100);
		//swytch֧��Byte��Short��Integer��Character�ĸ���װ�࣬��Ϊ�ײ��Զ�����
		switch (num05){
		case 50:
			System.out.println(num05);
			break;
		default :
			System.out.println("what the hell?");
		}
		//���һЩ��װ��ĳ����ͷ���
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.SIZE);
		System.out.println(Integer.toBinaryString(20));
		System.out.println(Integer.toHexString(20));
	}
}
/*
С�᣺��װ��Ķ��󣬻����������ͺ�String���͵�ת����ʵ���ǵ������еķ���
*/