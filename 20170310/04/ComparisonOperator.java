//���󣺲����Ƚ������
//����һ���࣬��ComparisonOperator
class ComparisonOperator {
	//����һ��������
	public static void main(String[] args) {
		//�Ƚ��������Ĵ�С����������������������������">"�Ƚ�
		int i1 = 65;
		int i2 = 64;
		//�жϱ��ʽΪi1 > i2�����Ϊboolean���ͣ�����Ϊtrue��ִ�е�һ������ִ���壬����Ϊfalse��ִ��else{}���������ִ����
		if(i1 > i2){
			//����Ϊtrue��ִ�д˾�
			System.out.println("���ֵΪ�� " + i1);
		}else{
			//����Ϊtrue����ִ�д˾�
			System.out.println("���ֵΪ�� " + i2);
		}
		//�������Ҳ��дΪ���£��ж�i1 < i2�Ƿ�Ϊ������
		boolean whichbigger = i1 < i2;
		//������
		System.out.println(whichbigger);
		//"="��ʾ��ֵ,"=="���������ĵȺţ���ʾ�Ƚ��Ƿ���ȣ��ж�i1�Ƿ����i2
		boolean whether = i1 == i2;
		System.out.println(whether);
		//�ж�3������4�Ƿ�Ϊ������
		System.out.println(3 != 4);
		//ע�⣺boolean���͵ı��ʽ����ֱ�ӷ��ڴ�ӡ����У�Ҳ�����Ȱ�����ֵ��boolean���͵ı���
		System.out.println(3 >= 4);
	}
}
/*
С�᣺�Ƚ���������������࣬�ȿ����Ǳ�����������Ҳ�����Ǳ��ʽ
*/