//���󣺲�����ֵ�����
//����һ���࣬��AssigningOperator02
class AssigningOperator02 
{
	//����������
	public static void main(String[] args) 
	{
		//��ֵ����"="��Ϊά������Ŀɶ��ԣ�����һ��ֻ����һ������
		byte b = 6;
		short s = 69;
		int i = 15;
		//ע�⣺javaĬ������Ϊint���ͣ���Ҫ����������һ��long���ͱ����������������L��l
		long l = 69999999999L;
		//ע�⣺javaĬ��С��Ϊdouble���ͣ���Ҫ����������һ��float���ͱ����������������F��f
		float f = 6.32F;
		double d = 6.3333;
		//char����������������һ�����֣�Ӣ����ĸ���ַ��������������֡��ڳ�ʼ��ʱҪ�ǵ��õ����Ű�Χ
		char c = 'A';
		//String�����ڳ�ʼ��ʱҪ��˫���Ű�Χ
		String str = "������ä��x����";
		//����+=
		short num = 6;
		//���д��������ΪnumΪshort���ͣ�num + 3 Ϊint���ͣ���Ҫ��������ת��
		//num = num + 3;
		//����������û�д�����Ϊ�Դ���ʽ����ת��
		num += 3;
		System.out.println(num);
		//����������/=
		int a1 = 98;
		int a2 = 63;
		//���д���ȼ���a1 = a1 / a2
		a1 /= a2;
		System.out.println(a1);
		//����ȡ�����/%=
		int a3 = 98;
		//���д���ȼ���a3 = a3 / a2 ...35,������Ϊ����35
		a3 %= a2;
		System.out.println(a3);
		//�¾��е�"-"��ʾ���ţ���6ȡ��
		System.out.println(5 * -6);
		//�¾��е�"+"��ʾ����
		System.out.println(5 * +6);
	}
}
