//������֤float��double����������������֮��Ļ���ת��
//����һ���࣬��TwoDecimals02
class TwoDecimals02 
{
	//����һ��������
	public static void main(String[] args) 
	{
		//С����java�ﱻĬ�ϱ�Ĭ�ϱ���Ϊdouble���ͣ���Ҫ����һ��float���͵�С����Ҫ���������������f��F
		float decimal1 = 63.21F;
		//��ӡdecimal1��ע�������Ҫ����һ��ı���������һ��
		System.out.println(decimal1);
		//����ת��Ϊ������Ҫע�⾫�ȶ�ʧ������
		//���������ͱ����У���ʾ16��������Ҫ��ǰ���0x��0X
		int i = 0X1000001;
		//��i���Ƹ�����f
		float f = i;
		//Integer.toBinaryString(i)��ʾ��i��ֵת��ΪString���͵Ķ�������
		System.out.println(Integer.toBinaryString(i) + ":" + i);
		//ע�����ŵ����ݣ�(int)f��ʾ�ѱ���f��floatת��Ϊint
		//��Integer.toBinaryString((int)f)��ʾ��(int)fת��ΪString���͵Ķ�������
		System.out.println(Integer.toBinaryString((int)f) + ":" + i);
		//������������int����ȡֵ��Χʱ����intת��float�����ȶ�ʧ
	}
}

