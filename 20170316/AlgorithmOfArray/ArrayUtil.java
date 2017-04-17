//���󣺔��M�Ĺ�����Ѳ������M���õķ������b�ڴ����
//����Ҫ�����������҂���ֱ���\�����������ڄe������{�ô���еķ���
class ArrayUtil {

	//int��͔��M��Ԫ�ؿ�ؐճ�N
	static void copy(int[] array,int srcPos,int[] newArray,int destPos,int length){
		if(srcPos <= 0 || destPos <= 0 || srcPos > destPos){
			System.out.println("������������");
		}
		//���ȷ��ѭ��������ѭ���ӿ�ʼ������ֵ���������еĳ��ȼ��Ͽ�ʼ����ֵ����
		for(int i = srcPos;i < length + srcPos;i++){
			newArray[destPos] = array[i];
			//��������±�ҲҪÿѭ��һ������1���������ƥ��
			destPos++;
		}
		//������ӡ������Ԫ��
		for(int i = 1;i < newArray.length;i++){
			System.out.println(newArray[i]);
		}
	}

	//����������
	static int binarySearch01(int[] arr,int x){
		int low = 0;
		//���M���������ֵ�锵�M�L�� - 1
		int high = arr.length - 1;
		//һ�����Ķ��M�Ɣ�������һλ�����x2��������һλ�����/2�����g����
		while(low <= high){
			//���g������ֵһ��Ҫ����ѭ�h�Y�棬�S��ѭ�h������׃����������ѭ�h�⣬��ֵ�͟o����׃
			int mid = (low + high) >> 1;
			if(x > arr[mid]){
				low = mid + 1;
			}else if(x < arr[mid]){
				high = mid - 1;
			}else{
				return mid;
			}
		}
		//�������ϗl���������ϣ���ݔ�딵�����`������-1
		return -1;
	}

	//������������Ԫ��
	static int[] reverse(int[] arrayForTest){
		//�������������У�������Ԫ��[0] = ������Ԫ��[��.length - 1],������Ԫ��[1] = ������Ԫ��[��.length - 2],���������Ϊ��.length - 1
		int[] newArray = new int[arrayForTest.length];
		for(int i = 0;i < arrayForTest.length;i++){
			newArray[i] = arrayForTest[arrayForTest.length - 1 - i];
		}
		return newArray;
	}

	//��ӡ���MԪ��
	static void print(String[] args) {
		int nums[] = { 1, 2, 3, 4, 5 };
		String str = "[";
		for (int i = 0; i < nums.length; i++) {
			str += nums[i];
			if(i != nums.length - 1){
				str += ", ";
			}
		}
		System.out.println(str);
	}


	//��ȡ���������Ԫ��
	//���裺ͨ������һ���������������һ�����һ��Ԫ�ش洢��ȥ���ٰ���������ʣ�µ�������һ���Ƚϡ�
	//�����������ֱ����󣬱�ѽϴ�ֵ���¸�����Ǹ�������ֱ���Ƚ������һ��Ԫ��
	static int getMax(int[] arrayForTest){
		int maxNumber = arrayForTest[0];
		//��forѭ����������������Ԫ��
		for(int i = 0;i < arrayForTest.length;i++){
			//��if��䣬���ڱ��������з��������ֱ�maxNumber�󣬰ѽϴ����ָ���maxNumber
			if(maxNumber < arrayForTest[i]){
				maxNumber = arrayForTest[i];
			}
		}
		return maxNumber;
	}

	
	//��ȡ��������СԪ��
	//���裺ͨ������һ���������������һ�����һ��Ԫ�ش洢��ȥ���ٰ���������ʣ�µ�������һ���Ƚϡ�
	//�����������ֱ���С����ѽ�Сֵ���¸�����Ǹ�������ֱ���Ƚ������һ��Ԫ��
	static int getMin(int[] arrayForTest){
		int minNumber = arrayForTest[0];
		//��forѭ����������������Ԫ��
		for(int i = 0;i < arrayForTest.length;i++){
			//��if��䣬���ڱ��������з��������ֱ�maxNumber�󣬰ѽϴ����ָ���maxNumber
			if(minNumber < arrayForTest[i]){
				minNumber = arrayForTest[i];
			}
		}
		return minNumber;
	}
}
/*
С�Y����editplus�У���ctrl + F11���ɿ��ٌ������@���ļ��е����з����б�
����һ��������҂��ڄe���ļ��Y�Ͳ����������������p�pؓ����ͬ�rʹ���̽Y��������
*/
