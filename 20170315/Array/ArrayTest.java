//���󣺴��������������͵�����
//������,��ArrayTest
class ArrayTest{
	//����������
	public static void main(String[] args) {
		//�����������͵����飬�Ȳ����г�ʼ��
		byte[] b; 
		short[] s;
		int[] i;
		long[] l;
		float[] f;
		double[] d;
		char[] c;
		boolean[] whether;
		String[] str;
		//�����ϵ�������о�̬��ʼ��
		b = new byte[]{1,3,5};
		s = new short[]{63,69,98,20};
		i = new int[]{63,987};
		l = new long[]{6987L,166598L};
		f = new float[]{63.0F,58.064F};
		d = new double[]{98.036};
		c = new char[]{'A','��'};
		whether = new boolean[]{true,false,true,true};
		str = new String[]{"too young","too simple"};
		//�����ϵ�������ж�̬��ʼ��
		//b = new byte[3];
		//s = new short[4]
		//i = new int[2.;]
		//l = new long[2];
		//f = new float[4];
		//d = new double[1];
		//c = new char[2];
		//whether = new char[4];
		//str = new str[2];
		//System.out.println
		//����������ʼ���ϳ�һ���Ķ�̬��ʼ��
		int[] arr = new int[5];//���鳤����5
		//����������ʼ���ϳ�һ���ľ�̬��ʼ��
		String[] arrayDemo = new String[]{"�ڿ��۾�","�߸ߵĿ�����","�ᵯ�����ļ���"};
		//��������ɼ�Ϊ�������ּ�д�������������ʼ��ͬʱ����
		String[] arrayDemo1 = {"�ڿ��۾�","�߸ߵĿ�����","�ᵯ�����ļ���"};
		//�������´�������Ϊ7�����飬�������arr.ע�����������³�ʼ��ʱ�����۶�/��̬��new int[]������ʡ��
		arr = new int[7];

	}
}
/*
С�᣺����Ķ�̬��ʼ��������Աָ������ĳ��ȣ�ϵͳ�Զ�Ϊ����Ԫ�ط����ʼֵ��
��ʽΪ��Ԫ�ص���������[] ������ = new Ԫ�ص���������[X];
����ľ�̬��ʼ��������Աָ��ÿ��Ԫ�صĳ�ʼֵ��ϵͳ�Զ��������鳤�ȡ�
��ʽΪ��Ԫ�ص���������[] ������ = new Ԫ�ص���������[]{Ԫ��1��Ԫ��2...Ԫ��N};
new��ʾ�ڶѿռ俪��һ���ڴ��������洢���ݣ�null��ʾû�������κ��ڴ�ռ�
*/