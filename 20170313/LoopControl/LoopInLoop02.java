//��������Ƕ��ѭ������break;��continue;�ֱ������ѭ������ѭ�����۲������Ƚ���ͬ��
//�����࣬��LoopInLoop02
class LoopInLoop02 {
	//����������
	public static void main(String[] args) {
		//��Ŀ��ħ����ʦͽ���˷ֱ��1����10
		/*���裺1.�����ˣ����ѭ��4��
		2.ÿ�˴�1����10�����ѭ��10��
		*/
		for(int i = 1;i <= 4;i++){
			for(int j = 1;j <= 10;j++){
				if(j == 6){
					break;
				}
				System.out.println(j);
			}
			System.out.println("--------");
		}
		//��ʵ�飬break�������ѭ��ʱ���������ж�����ʱ�ͻ��������ѭ���������ѭ������Ӱ��

		for(int i1 = 1;i1 <= 4;i1++){
			if(i1 == 3){
				break;
			}
			for(int j1 = 1;j1 <= 10;j1++){
				System.out.println(j1);
			}
			System.out.println("--------");
			//��ʵ�飬break�������ѭ��ʱ���������ж�����ʱ�ͻ��������ѭ���������ѭ������Ӱ��

			for(int i2 = 1;i2 <= 4;i2++){
				for(int j2 = 1;j2 <= 10;j2++){
					if(j2 == 6){
						continue;
					}
					System.out.println(j2);
				}
				System.out.println("--------");
			}
			//��ʵ�飬continue�������ѭ��ʱ���������ж�����ʱ�ͻ��������ѭ���������ѭ������Ӱ��
		}
		for(int i3 = 1;i3 <= 4;i3++){
			if(i3 == 3){
				continue;
			}
			for(int j3 = 1;j3 <= 10;j3++){
				System.out.println(j3);
			}
			System.out.println("--------");
		}
		//��ʵ�飬continue�������ѭ��ʱ���������ж�����ʱ�ͻ��������ѭ���������ѭ������Ӱ��
	}
}
/*
С�᣺���������������ѭ��ʱ��Ҫע����������÷�Χ�������������ĸ�ѭ��
*/