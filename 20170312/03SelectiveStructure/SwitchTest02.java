//����ִ��switch����У�����м��������Ӧ����һ�ִ���Ĵ��룬����ʡ��
//�����࣬��SwitchTest02
class SwitchTest02 {
	//����������
	public static void main(String[] args) {
		//����һ����Ϊ�����գ�����������Ϊ��Ϣ��
		int weekday = 5;
		switch(weekday){
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				System.out.println("�����ǹ�����");
				//һ��Ҫ�ǵ���case�������дbreak
				break;
			case 6:
			case 7:
				System.out.println("��������Ϣ��");
				break;
			//ע�⣺"default"��":"֮����һ���ո�
			default :
				System.out.println("����������");
		}
	}
}
/*
С�᣺д����ʱҪע���ʽ���ո���ʡ�ԣ�дʱҪע�����뷨���л���
*/