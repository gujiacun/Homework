//���󣺲���if-else��䡣ע��if-else�������Ԫ���������ͬ
//����һ���࣬��IfElseTest
class IfElseTest {
	//����������
	public static void main(String[] args) {
		//һ����վ��125�����ݣ�ÿҳֻ����ʾ20������Ҫ��ƶ��ٸ�ҳ�棿
		//�ⷨһ����Ԫ�����
		//������
		int allData = 125;
		//ÿҳ��ʾ����
		int eachPage = 20;
		//��Ҫ��ҳ��
		int pageAmount = allData / eachPage;
		//���������ݳ���ÿҳ��ʾ����������������Ҫ�����һҳ���洢ʣ�µ�����
		pageAmount = allData % eachPage == 0 ? pageAmount : pageAmount + 1;
		//������
		System.out.println(pageAmount);

		//һ����վ��639�����ݣ�ÿҳֻ����ʾ30������Ҫ��ƶ��ٸ�ҳ�棿
		//�ⷨ����if - else���
		int totalData = 639;
		int everyPage = 30;
		int amountOfPage = totalData / everyPage;
		int leftAmount = totalData % everyPage;
		if(leftAmount == 0){
			System.out.println(amountOfPage);
		}else{
			System.out.println(amountOfPage + 1);
		}
	}
}
/*
С�᣺if-else����Ԫ��������������϶��ߵĺ�����ͬ.
�ӱ�����˵,if-else�����ṹ,��Ԫ�������һ���������.
��Ԫ�����������һ�����,���ʽ�����н��,�����з���.��if-else,���ܷ���ʲô���,ֻ�ܿ������Ľṹ.
*/