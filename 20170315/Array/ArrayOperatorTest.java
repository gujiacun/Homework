//���󣺽�������Ļ����������õ�����ĳ��ȣ���ȡĳ��Ԫ�أ�֪�������������Χ��������Ԫ�ظ�ֵ,��������Ԫ��
//�������ļ�����ArrayOperatorTest
class ArrayOperatorTest {
	//����������
	public static void main(String[] args) {
		//�ȶ���һ������
		int[] arrayTest = new int[]{10,36,89,65};
		//ͨ��length��������ȡ����ĳ��ȣ������Ԫ�ظ�����
		System.out.println(arrayTest.length);
		//�����������Χ��0��ʼ����һ���������ֵΪ���鳤�ȼ�1
		//��ȡ�������һ��Ԫ�ص�ֵ,ע�����һ��Ԫ�ص�����ֵΪ���鳤�ȼ�1
		int num = arrayTest[arrayTest.length - 1];
		System.out.println(num);
		//������ڶ���Ԫ�����¸�ֵΪ963������ӡ����
		arrayTest[1] = 963;
		System.out.println(arrayTest[1]);
		//ʹ��forѭ����������Ԫ��
		//���������ֵ��0��ʼ�������鳤��-1����
		for(int i = 0;i < arrayTest.length;i++){
			System.out.println(arrayTest[i]);
		}
	}
}
/*
С�᣺��ȡ����Ԫ�صĸ�ʽ�� Ԫ������ ������ = ������[����ֵ];
������Ԫ�ظ�ֵ�ĸ�ʽ�� ������[����ֵ] = ����;
*/