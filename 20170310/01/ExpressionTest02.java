//���󣺸�ϰ���ʽ�Ĺ��ɡ�
//����һ���࣬����Expression02
class ExpressionTest02 
{
	//����������
	public static void main(String[] args) 
	{
		//���ʽ���ɳ������������������������ɵ����
		//һ�����ʽΪ�������ĵ����η�������ӡ������
		System.out.println(3*Math.pow(4, 3));
		//��8��16��ƽ�������ѽ���������result����ӡ����������Ҫǿ������ת����
		int result = (int)(8 / Math.sqrt(16));
		//��ӡ���
		System.out.println(result);
		//Math.sqrt(16)�Ľ����4.0 ����С����������������double���͡�
		double result1 = 8 / Math.sqrt(16);
		System.out.println(result1);
	}
}

