//���󣺲���ѡ����������
//����һ���࣬��ArraySort
class ArraySort {
	//����������
	public static void main(String[] args) {
		//��������
		int[] arr = {2,9,6,7,4,1};
		//ѡ������ı�����ѡ��ĳ������λ�õ�Ԫ�أ�ͨ���ǵ�һ����
		//Ȼ��������Ԫ�رȽϣ����ϴ��򽻻�λ�ã���һ�������Сֵ��Ȼ���������ƣ����µ�һ��
		//for(int i = 0;i < 1;i++){
			//if(arr[i] > arr[i + 1]){
				//int temp = arr[i];
				//arr[i] = arr[i + 1];
				//arr[i + 1] = temp;
			//}
		//}
		//�ڶ���
		//for(int i = 1;i < 2;i++){
			//if(arr[i] > arr[i + 1]){
				//int temp = arr[i];
				//arr[i] = arr[i + 1];
				//arr[i + 1] = temp;
			//}
		//}
		//������
		//for(int i = 2;i < 3;i++){
			//if(arr[i] > arr[i + 1]){
				//int temp = arr[i];
				//arr[i] = arr[i + 1];
				//arr[i + 1] = temp;
			//}
		//}
		//ÿһ�ֵ�������i���1���Դ���Ϊ�ⲿѭ�����������ϴ���ɼ�дΪ����
		//��������N��Ԫ�أ�ѭ������ҪN - 1 ��
		for(int times = 1;times < arr.length;times++){
			for(int i = times;i < arr.length;i++){
				//���������ͽ���������ֵ
				if(arr[times - 1] > arr[i]){
					int temp = arr[i];
					arr[i] = arr[times - 1];
					arr[times - 1] = temp;
				}
			}
		}
		for(int i = 0;i < arr.length;i++){
			System.out.println(arr[i]);
		}
	}
}
/*
С�᣺ѡ����������ѡ��һ��Ԫ�أ��������Ԫ�رȽϡ��ڷ����㷨ʱ�ǵ�Ҫ�໭ͼ��һ��ѭ��һ��һ�ε��𽥷��������ܽ���ɡ�
*/