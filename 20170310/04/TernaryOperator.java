//���󣺲�����Ԫ��������������ӡ�
//����һ���࣬��TernaryOperator
class TernaryOperator 
{
	//����������
	public static void main(String[] args) 
	{
		//����һ������:���ڸ�һ��С��3.14����Ҫ�������������֮��Ľ������ô��ɸù��ܣ�
		//�ⷨһ��Math.round()
		System.out.println(Math.round(3.14));
		//�ⷨ������3.14��С�����ֺ��������ַ��룬��С��������0.5�Ƚϣ����ڵ������1��С�������
		double num = 3.14;
		//ǿ������ת������ֻ����3.14����������
		int num1= (int)num;
		//��3.14������������������õ���С������
		double num2 = num - num1 ;
		//��С��������0.5�Ƚϣ����ڵ������1��С�������
		int result = num2 >= 0.5 ? num1 + 1 : num1;
		System.out.println(result);
		//���Ӷ��������ж�һ����������������ż����
		//����һ�������ж�
		int num3 = 65;
		//�ܱ�2������������ż��������Ϊ������
		String answer = num3 / 2 == 0 ? "ż��" : "����";
		//�����
		System.out.println(answer);
	}
}
/*
С�᣺X ? Y : Z  ,XΪboolean���ͱ��ʽ����Ϊtrue������Y��Ϊfalse������Z��Y��Z�͸�ֵ������ߵı���Ҫ��������һ��
������if-else if-else ��ͬ��
*/