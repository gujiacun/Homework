//�����˽�ʲô�Ǳ�����ΪʲôҪ�ñ�����������������������ʼ���ĸ�ʽ��ʲô��
//����һ���࣬��StepInVariable
class StepInVariable 
{
	//����һ��������
	public static void main(String[] args) 
	{
		//����������ʽ  type variableName;
		int num;
		//�����������ʼֵ  variableName = constant
		num = 16;
		//��ӡ�ñ���
		System.out.println(num);
		//�ֱ���16��289��ƽ������ע�⣺Math.sqrt()�Ľ��Ϊdouble����
		//������Ҫ���в��������������������޸�
		//���Ƽ�ͬʱ��һ���ﶨ������������Ϊ��Ӱ��ɶ���
		double num1;
		double num2;
		//��ʼ��������������16
		num1 = 16;
		//��ʼ��������������289
		num2 = 289;
		//�ֱ�����
		double result1 = Math.sqrt(num1);
		double result2 = Math.sqrt(num2);
		//���16��ƽ����
		System.out.println(result1);
		//���289��ƽ����
		System.out.println(result2);
		//��16��ƽ��������289��ƽ�����ĺ�
		System.out.println(result1 + result2);
		//��16��ƽ������ȥ289��ƽ�����Ĳ�
		System.out.println(result1 - result2);
		//��16��ƽ��������289��ƽ�����Ļ�
		System.out.println(result1 * result2);
		//��16��ƽ��������289��ƽ��������
		System.out.println(result1 / result2);
		//String��Ϊ��������ʱ����ĸ��д��������Ҫ��˫���Ű�Χ
		String str = "too young,too simple";
		//��ӡ�ַ���
		System.out.println(str);
		//char���ͱ�����ʼֵ��ʱ��������Ҫ�õ����Ű�Χ
		char alphabet = '��';
		//��ӡ���ַ�
		System.out.println(alphabet);
		//boolean��ֵֻ��true��false���ж��������ĵ����η��Ƿ����8��16��ƽ����
		boolean whether = 3*Math.pow(4, 3) >= 8 / Math.sqrt(16);
		//����ж����
		System.out.println(whether);
	}
}
/*
С�᣺�����һ��Ҫ���������ٳ�ʼ���������ܽ��в�����
char���ͺ�String��������Ҫ�ֱ��õ����ź�˫���Ű�Χ��
Math.sqrt(16)�Ľ����4.0����double����
*/
