//������������Σ���һ����1��X��Ȼ�����е�������5��
//����һ���࣬��TriangleTest
class  TriangleTest{
	//����������
	public static void main(String[] args) {
		//����һ�����д�ӡ
		//��һ��
		System.out.println("X");
		//�ڶ���
		System.out.println("XX");
		//������
		System.out.println("XXX");
		//������
		System.out.println("XXXX");
		//������
		System.out.println("XXXXX");
		//����������������ÿ����X�ĸ�����������ȣ����ϴ����дΪ
		//��һ��
		int line1 = 1;
		for(int i = 1;i <= line1;i++){
			System.out.print("X");
		}
		System.out.println();
		//�ڶ���
		int line2 = 2;
		for(int i = 1;i <= line2;i++){
			System.out.print("X");
		}
		System.out.println();
		//������
		int line3 = 3;
		for(int i = 1;i <= line3;i++){
			System.out.print("X");
		}
		System.out.println();
		//������
		int line4 = 4;
		for(int i = 1;i <= line4;i++){
			System.out.print("X");
		}
		System.out.println();
		//������
		int line5 = 5;
		for(int i = 1;i <= line5;i++){
			System.out.print("X");
		}
		System.out.println();
		//���������ڷ������У����ǿ��Կ���line������ÿ���ж��������Ӧ������Ϊ������ѭ���ı������������forѭ������һ������
		
		for(int linex = 1;linex <= 5;linex++){
			for(int i = 1;i <= linex;i++){
				System.out.print("X");
			}
			System.out.println();
		}
	}
}
/*
С�᣺Ҫע������System.out.print("X");��System.out.println("X");������һ�����ڱ����ڴ�ӡ��һ���ǻ��д�ӡ
*/