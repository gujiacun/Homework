//����ʵ����case�󲻼���break���ĺ��
//������
class SwitchTest03 
{
	//����������
	public static void main(String[] args) 
	{
		//С������60�֣���֪��ϵͳ����Զ��������ĳɼ�
		//��ʼ��ֵ
		int score = 60;
		//switch�����ж��������������ʽ�Ƿ����ĳ��int���͵�ֵ��
		switch (score){
		//����break��switch������д��붼��ִ��
			case 60:
				System.out.println("�ϸ�");
			case 70:
				System.out.println("����");
			case 80:
				System.out.println("����");
			case 90:
				System.out.println("����");
		}
	}
}
/*
С�᣺break����switch����У���������������顣
*/