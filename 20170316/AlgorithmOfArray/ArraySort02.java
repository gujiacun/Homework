//���󣺲���ð����������
//����һ���࣬��ArraySort02
class ArraySort02 {
	//����������
	public static void main(String[] args) {
		//��������
		int[] arr = {2,9,6,7,4,1};
		//ð������ı����������ڵ��������Ƚϣ�����ǰ�߱Ƚϴ������߽���λ��
		//���õ�һ��ڶ������Ƚϣ�����һ���Ƚϴ����ڶ�������λ��
		//����int[0] < int[1],�������߲�����λ��
		//���ڵó�int[1]����֪���������ģ������������һ�����Ƚ�
		//����int[1] > int[2],���Խ���λ�ã�������int[2] = 9,�Դ�����,����Ϊ��һ��
		int i = 0;
		int j = i + 1;
		for(;i < 1;i++){
			if(arr[i] > arr[j]){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		for (int k = 0; k < arr.length; k++) {
			System.out.println(arr[k]);
		}
		System.out.println("--------");
		//����Ϊ�ڶ���
		int i1 = 1;
		int j1 = i1 + 1;
		for(;i1 < 2;i1++){
			if(arr[i1] > arr[j1]){
				int temp = arr[i1];
				arr[i1] = arr[j1];
				arr[j1] = temp;
			}
		}
		for (int k = 0; k < arr.length; k++) {
			//���Կ���Ԫ��9��6������λ��
			System.out.println(arr[k]);
		}
		System.out.println("--------");
		//����չʾ,�ڱȽ�ʱ����ߵ���Ҫ������0�������ڶ�����
		for(int i2 = 0;i2 < arr.length - 1;i2++){
			//�ڱȽ�ʱ���ұߵ���Ҫ������1�����һ����
			for(int j2 = i2 + 1;j2 < arr.length;j2++){
				if(arr[i2] > arr[j2]){
					int temp = arr[i2];
					arr[i2] = arr[j2];
					arr[j2] = temp;
				}
			}
		}
		for (int k = 0; k < arr.length; k++) {
			//�����������Ԫ��
			System.out.println(arr[k]);
		}
	}
}
/*
С�᣺�������Ԫ�����αȽ����ڵ�����Ԫ�ش�С����ǰ�߽ϴ��򽻻�λ�ã�������һ�ֱȽ������ɵó����ֵ��Ȼ��ʹ��ͬ���ķ�����ʣ�µ�Ԫ������Ƚϣ����õ������
*/