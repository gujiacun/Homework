//����int���͵����������ö�/��/ʮ/ʮ�����Ƶ�������int��char����
//����һ���࣬��IntTest02
class IntTest02 
{
	//����һ��������
	public static void main(String[] args) 
	{
		//������Ϊ������������0B��0b��ͷ
		int num1 = 0B1111;
		//��ӡ�ö�����������Ӧ��ʮ��������
		System.out.println(num1);
		//������Ϊ�˽���������Ҫ����0��ͷ
		int num2 = 077;
		//��ӡ�ð˽���������Ӧ��ʮ��������
		System.out.println(num2);
		//������Ϊʮ����������ֱ���������ּ���
		int num3 = 698;
		//�����ʮ������
		System.out.println(num3);
		//������Ϊʮ������������Ҫ��0X��0x��ͷ
		int num4 = 0XAF;
		//��ӡ��ʮ������������Ӧ��ʮ��������
		System.out.println(num4);
		//int������char�����ڸ�ֵʱ�Զ�ת��
		char c = 65;
		//��ӡ65��Ӧ���ַ�
		System.out.println(c);
		//int������char�����ڸ�ֵʱ�Զ�ת��
		int i = 'B';
		//��ӡ�ַ�B����Ӧ��ʮ��������
		System.out.println(i);
		//cΪchar���ͣ�c + 3Ϊint���ͣ�Ҫǿ��ת������
		c = (char)(c + 3);
		//��ӡ����c����Ӧ���ַ�
		System.out.println(c);
	}
}
