//������֤�������������������
//����һ���࣬��ArithmeticOperators
class ArithmeticOperators 
{
	//����������
	public static void main(String[] args) 
	{
		//�Ƚ��мӷ����������int�������ֵ
		System.out.println(Integer.MAX_VALUE);
		//���д�������Ľ��-2147483639��������Ϊjava������Ĭ����int���ͣ����ڵ����ս����Խ�磬Ҫ�������в�������ǿ��ת��Ϊlong
		System.out.println(Integer.MAX_VALUE + 10);
		//��(Integer.MAX_VALUE + 10)ǿ��ת���󣬵���������Ľ����Ϊ-2147483639������
		System.out.println((long)(Integer.MAX_VALUE + 10));
		/*ԭ��ΪInteger.MAX_VALUE��Ϊ���ֵ�����������ټ�10��(Integer.MAX_VALUE + 10)Խ���Ϊ����-2147483639����ʱ�ڽ�������ת������ȻΪ����
		�����������ǰ��Integer.MAX_VALUEת��Ϊlong����
		*/
		long result = ((long)Integer.MAX_VALUE + 10);
		//������
		System.out.println(result);
		/*���м�������
		�����ڻ��д�ӡ���������С������������
		*/
		System.out.println(10.32 - 2.98);
		//���г˷�����
		System.out.println(10 * 2);
		//���г������������ڶ����������������Ҳ������
		System.out.println(10 / 3);
		//���г���������������һ��С�������������Զ���������ת������intת��Ϊdouble�����Ҳ��double����
		System.out.println(10 / 3.0);
		//�����ַ������Խ�����������
		System.out.println('A' * 'B');
		//�ַ����ɺ����ֽ�����������
		System.out.println('A' + 1);
		//����ȡ���������ס" % "���������5���Ϸ�
		System.out.println('A' % 'B');
		//�ڳ��������У���������Ϊ0
	}
}
/*
С�᣺��Ҫ��ĳ�������͵ı߽�ֵ����������������ȰѸñ߽�ֵת�����ͣ��ڽ������㡣
*/