//����Ԫ�س���������һ��
//���裺1.�½�һ������������Ҫ������ѯ���������ƺ�Ҫ������Ԫ�أ��������β�
//2.��Ҫ����Ԫ�ص�һ�γ��ֵ����������巵��ֵ����Ϊint
//3.��Ҫ������������Ԫ�أ���forѭ��
//����һ���࣬��ArraySearchTest
class ArraySearchTest {
	//����������
	public static void main(String[] args) {
		//�ȶ���һ�����飬������Ѱ��5��һ�γ���ʱ������
		int[] array = {56,502,5,5,98,30};
		//������������һ�����������ܷ������صĽ��
		int result = ArraySearchTest.search(array,5);
		System.out.println(result);
	}
	//����������������������������Ҫ��Ѱ�ҵ�Ԫ��
	static int search(int[] arr,int a){
		//��������
		for(int i = 0;i < arr.length;i++){
			//�����жϣ���Ϊtrue����ʾ�ҵ�
			if(arr[i] == a){
				//���ؽ��
				return i;
			}
		}
		//��5�������ﲻ���ڣ�����-1��ʾ������
		return -1;
	}
}
/*
С�᣺��ʹ������ʱһ��Ҫ�ǵ���Ԫ�����ͺ������[]
�ڱ�������ʱ�������0��ʼ���Ƚϲ����׳�����
��ȡ����Ԫ�صĸ�ʽ�� Ԫ������ ������ = ������[index];��ס��������
*/