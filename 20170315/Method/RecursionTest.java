//�����÷��������ݹ��㷨
//����һ���࣬��RecursionTest
class RecursionTest {
	//����������
	public static void main(String[] args) {
		//����recursion������������ֵ��ͬʱ���ܷ��ؽ��
		int result = RecursionTest.recursion(10);
		System.out.println(result);
	}
	/*����һ����������recursion������չʾ쳲���������
	���ڷ��������������static���Σ��˴�Ҫ����һ��int���͵�ֵ��ҲҪ����һ��int���͵�ֵ
	*/
	static int recursion(int x){
		//�ж������ֵ��ʲô��������������ѡ��
		switch (x)
		{
		//����x����0�����0
		case 0:
			return 0;
		//����x����1�����1
		case 1:
			return 1;
		//�������������ϣ�ִ�д���
		default :
			//���ڵݹ��㷨�漰���������������Ҫ�õ��÷����ĸ�ʽ
			return recursion(x - 1) + recursion(x - 2);
		}
	}
}
/*
С�᣺�ݹ��㷨�У�������������߽׵��õͽף��������޵ļ��㲽�衣���ݹ������ֱ�Ӹ���ֱ�ӵ�ֵ
ͬʱע�������������ĸ�ʽΪ��������(������)���м䲻�ӵ�
*/