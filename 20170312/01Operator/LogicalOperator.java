//���󣺲������е��߼������
//����һ���࣬��LogicalOperator
class LogicalOperator {
	//����������
	public static void main(String[] args) {
		//��·������,��0Ϊ0��ȫ1Ϊ1
		System.out.println(5 > 3 & 1 > 6);
		//��·������,��1Ϊ1��ȫ0Ϊ0
		System.out.println(5 > 3 | 1 > 6);
		//������,true & false���Ϊfalse�����Ϸ����㣬��Ϊtrue
		System.out.println(!(true & false));
		//������㣬��ͬΪ0����ͬΪ1
		System.out.println(true ^ false);
		//��·������,��0Ϊ0��ȫ1Ϊ1��������������ı��ʽ���Ϊfalse��ֹͣ����
		//System.out.println(5 > 3 && 5 / 0 == 1);
		System.out.println(5 < 3 && 5 / 0 == 1);
		//��·�����㣬��1Ϊ1��ȫ0Ϊ0��������������ı��ʽ���Ϊtrue��ֹͣ����
		System.out.println(5 > 3 || 5 / 0 == 1);
	}
}
/*
С�᣺�߼��������������boolean���ʽ��boolean������λ���������������
*/