//���󣺽�����������ֵ
//����һ���࣬��SwapVar
class SwapVar {
	//����������
	public static void main(String[] args) {
		//����һ������һ���±�����ͨ����������������ֵ
		int a = 13;
		int b = 31;
		//����һ����ʱ����temp��������ʱ�洢a��ֵ
		int temp = a;
		//��b��ֵ����a
		a = b;
		//��temp��ֵ����b
		b = temp;
		//��ӡ�������a��b��ֵ
		System.out.println(a);
		System.out.println(b);
		//��������ʹ��λ�����^
		int c = 13;
		int d = 31;
		c = c ^ d;
		d = c ^ d;
		c = c ^ d;
		//ע�⣺һ������ͬһ��������������Σ������������
		System.out.println(c);
		System.out.println(d);
	}
}
/*
С�᣺ͬһ�����������м��ֽ��������������ʱҪѡ���׶��ģ���ʱҪѡ��������õ�
*/