//�����˽ⷽ�����ص�ԭ����ν��з�������
//����һ���࣬��OverLoadTest
class OverLoadTest {
	//����������
	public static void main(String[] args) {
		//��������int���͵ı���
		int x = 20;
		int y = 36;
		//����getIntSum���������x��y�ĺ�
		//���������д���һ���±��������ܴ�getIntSum�������صĽ��
		//�������ø�ʽ��������������.������(����);
		int result1 = OverLoadTest.getIntSum(x,y);
		//������
		System.out.println(result1);
		double x1 = 20.1;
		double y1 = 36.1;
		//����getDoubleSum���������x1��y1�ĺ�
		//���������д���һ���±��������ܴ�getDoubleSum�������صĽ��
		//�������ø�ʽ��������������.������(����);
		double result2 = OverLoadTest.getDoubleSum(x1,y1);
		//������
		System.out.println(result2);
		//���þ����������غ��getSum����
		System.out.println(OverLoadTest.getSum(26,3));
		//��ʱjava���������Ĳ����������Զ��жϸõ����ĸ�����
		System.out.println(OverLoadTest.getSum(20.5,36.5));
	}
	//����ͬһ�����д����������Ʋ�ͬ�ķ������ֱ�ʵ�ֶ�����������С������Ͳ���
	//������������getIntSum����������int���͵�ֵ���������ǵĺͣ����ؽ��
	static int getIntSum(int a,int b){
		return a + b;
	}
	//������������getDoubleSum����������double���͵�ֵ���������ǵĺͣ����ؽ��
	static double getDoubleSum(double a,double b){
		return a + b;
	}
	//�����ϲ�����Կ��������������Ĺ���һ�������������Ʋ�ͬ���������ؿ��Ա�������⡣
	//�������أ���ͬһ�����У���������ͬ�������б�ͬ
	static int getSum(int a,int b){
		return a + b;
	}
	static double getSum(double a,double b){
		return a + b;
	}
}
/*
С�᣺�����ڷ����͹������ж���Ӧ�ã�������Ϊ��ʵ��ĳ�����ܵĴ��뼯�ϣ���ס��ͬһ��ͬ
��ס���������д���һ���±��������ܴӷ������صĽ��
*/