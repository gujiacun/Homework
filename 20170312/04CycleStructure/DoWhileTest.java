//������do - while��˳���ӡ��д��ĸA��Z
//����һ���࣬��DoWhileTest
class DoWhileTest {
	//����������
	public static void main(String[] args) {
		//��ʼ������ֵalphabet�������һ����ӡ��Ԫ��A
		char alphabet = 'A';
		do{
			//�����һ��Ԫ��A
			System.out.println(alphabet);
			//��������1������char�����ڵײ��Ǵ洢Ϊint���ͣ����԰�������һ�����ͱ���
			alphabet ++;
			//ѭ����������������������ʱ��ִ�����һ��ѭ�������ش�ӡ���
		}while (alphabet <= 'Z');
	}
}
/*

С�᣺char�����ڵײ��Ǵ洢Ϊint���ͣ�����char���ͱ�������ִ�������Լ�
*/