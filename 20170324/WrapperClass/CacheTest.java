//����ͨ���Ƚ��������Ĵ�С����ס��װ�����������Ԫģʽ
//�����࣬CacheTest
public class CacheTest {
	//����������
	public static void main(String[] args) {
		//ͨ�����ַ�ʽ������װ��Ķ���,���Ƚ����Ǵ�С
		//����һ���½���װ��Ķ���
		Integer num01 = new Integer(60);
		Integer num02 = new Integer(60);
		//�����¶�������������ͬ���ڴ��ַ��==�ڱȽ���������ʱ�Ƚ��ڴ��ַ
		System.out.println(num01 == num02);
		//�����������ð�װ���еķ���
		Integer num03 = Integer.valueOf(30);
		Integer num04 = Integer.valueOf(30);
		//���true����Ϊ�����������Integer�Ļ�����[-128��127]��,ֱ�ӻ������
		System.out.println(num03 == num04);
		//���������Զ�װ��
		Integer num05 = 15;
		Integer num06 = 15;
		//������ĵײ�Ϊ���������ֶ�ʵ��
		System.out.println(num05 == num06);
		System.out.println("----------------");
		//��һ������������������
		Integer num07 = Integer.valueOf(300);
		Integer num08 = Integer.valueOf(300);
		//���false����Ϊ��������ݳ���Integer�Ļ��������ڵײ㴴�������¶���
		//��==�ڱȽ���������ʱ�Ƚ��ڴ��ַ�����Բ�ͬ
		System.out.println(num07 == num08);
		System.out.println("----------------");
		//����Ҫ��Ƚ������������͵����ݣ���equals����
		System.out.println(num07.equals(num08));
		System.out.println(num03.equals(num04));
	}
}
/*
С�᣺��װ���Ͷ���֮��ıȽϲ���:ͳͳʹ��equals���������Ƚ�,�Ƚϵ��ǰ�װ������
*/