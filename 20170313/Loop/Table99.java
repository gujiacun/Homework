//��������žų˷����ǰ����
//�����࣬��Table99
class Table99 {
	//����������
	public static void main(String[] args) {
		//����һ�����д�ӡ
		System.out.println("1 x 1 = 1");
		System.out.println("1 x 2 = 1  2 x 2 = 2");
		System.out.println("1 x 3 = 3  2 x 3 = 6  3 x 3 = 9");
		System.out.println("1 x 4 = 4  2 x 4 = 8  3 x 4 = 12  4 x 4 = 16");
		System.out.println("1 x 5 = 5  2 x 5 = 10 3 x 5 = 15  4 x 5 = 20  5 x 5 = 25");
		System.out.println("1 x 6 = 6  2 x 6 = 12 3 x 6 = 18  4 x 6 = 24  5 x 6 = 30  6 x 6 = 36");
		//����������ÿ���У���ʽ�ĸ�����������ȣ�ͬʱ����ʽ�еڶ���������������ȡ����ҵ�һ��������1��ʼ����1������ֱ�����������
		System.out.println("------�ָ�------");
		//�ڵ�1���У������дΪ
		int line1 = 1;
		//ѭ���������������
		for(int i = 1;i <= 1;i++){
			//ע�⣺���������Ҫ���о���println����������print
			System.out.print(i + " x " + line1 + " = " + i * line1 + "\t");
		}
		//ͬ����ʣ�µ����У������дΪ
		//����
		System.out.println();
		int line2 = 2;
		for(int i = 1;i <= 2;i++){
			System.out.print(i + " x " + line2 + " = " + i * line2 + "\t");
		}
		System.out.println();
		int line3 = 3;
		for(int i = 1;i <= 3;i++){
			System.out.print(i + " x " + line3 + " = " + i * line3 + "\t");
		}
		System.out.println();
		int line4 = 4;
		for(int i = 1;i <= 4;i++){
			System.out.print(i + " x " + line4 + " = " + i * line4 + "\t");
		}
		System.out.println();
		int line5 = 5;
		for(int i = 1;i <= 5;i++){
			System.out.print(i + " x " + line5 + " = " + i * line5 + "\t");
		}
		System.out.println();
		int line6 = 6;
		for(int i = 1;i <= 6;i++){
			System.out.print(i + " x " + line6 + " = " + i * line6 + "\t");
		}
		System.out.println();
		//������6�У�ÿ�е�������ѭ����������ͬ������Ӧ��������Ϊһ����������Ϊ���ѭ���ı���
		//��������ʹ��Ƕ��ѭ������������Ϊ�������ѭ���ı�������һ������Ϊ�����ڲ�ѭ���ı���
		for(int linex = 1;linex <= 6;linex++){
			for(int i = 1;i <= linex;i++){
				System.out.print(i + " x " + linex + " = " + i * linex + "\t");
			}
			System.out.println();
		}
	}
}
/*
С�᣺ע���ڹ۲�����ʱҪ��ϸѰ�ҹ��ɣ�Ҫѡ����ʵ�������Ϊ������������������ѭ��
*/