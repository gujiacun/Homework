//���󣺴���һ������Ĺ����࣬���Ϊ����ģʽ�Ķ���ʽ
//����ʽ����ģʽ�Ĳ���
//      1):�����ڸ�����,�Լ��ȴ�����һ������.
//      2):˽�л�����Ĺ�����,��ֹ���ͨ�������������µĶ���.
//      3):���Ⱪ¶һ�������ľ�̬�������ڻ�ȡ����Ķ���.

//��������Ĺ����࣬ArraysUtil
class ArraysUtil{
	//�Լ���������
	//Ҫ��static���Σ�����Ϊ���Ⱪ¶�ķ���Ϊ��̬���ҷ��ض���
	//����������ķ���Ϊ�Ǿ�̬����̬�����Ĳ������÷Ǿ�̬�����ģ����Ⱪ¶�ķ�������
	private static final ArraysUtil tool = new ArraysUtil();
	//˽�л�����Ĺ�����
	private ArraysUtil(){
	}
	//���Ⱪ¶һ�������ľ�̬�������ڻ�ȡ����Ķ���
	public static ArraysUtil getInstance(){
		//����ֵ����Ϊ���࣬return�Ѵ����Ķ���
		return tool;
	}

	//int��͔��M��Ԫ�ؿ�ؐճ�N
	public void copy(int[] array,int srcPos,int[] newArray,int destPos,int length){
		if(srcPos <= 0 || destPos <= 0 || srcPos > destPos){
			System.out.println("������������");
		}
		for(int i = srcPos;i < length + srcPos;i++){
			newArray[destPos] = array[i];
			destPos++;
		}
		for(int i = 1;i < newArray.length;i++){
			System.out.println(newArray[i]);
		}
	}

	//����������
	public int binarySearch(int[] arr,int x){
		int low = 0;
		int high = arr.length - 1;
		while(low <= high){
			int mid = (low + high) >> 1;
			if(x > arr[mid]){
				low = mid + 1;
			}else if(x < arr[mid]){
				high = mid - 1;
			}else{
				return mid;
			}
		}
		return -1;
	}

	//������������Ԫ��
	public int[] reverse(int[] arrayForTest){
		int[] newArray = new int[arrayForTest.length];
		for(int i = 0;i < arrayForTest.length;i++){
			newArray[i] = arrayForTest[arrayForTest.length - 1 - i];
		}
		return newArray;
	}

	//��ӡ���MԪ��
	public void print(String[] args) {
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
	public int getMax(int[] arrayForTest){
		int maxNumber = arrayForTest[0];
		for(int i = 0;i < arrayForTest.length;i++){
			if(maxNumber < arrayForTest[i]){
				maxNumber = arrayForTest[i];
			}
		}
		return maxNumber;
	}

	
	//��ȡ��������СԪ��
	public int getMin(int[] arrayForTest){
		int minNumber = arrayForTest[0];
		for(int i = 0;i < arrayForTest.length;i++){
			if(minNumber < arrayForTest[i]){
				minNumber = arrayForTest[i];
			}
		}
		return minNumber;
	}
}

//���������࣬Singleton
public class Singleton {
	//�������������������
	public static void main(String[] args) {
		int[] array = {1,-3,61,0,54,-36};
		//ArrayUtil.getInstance()ͨ���������÷���������ֵΪ����Ķ���tool
		//tool.reverse()ͨ���õ��Ķ������reverse�������򷽷���������������
		int[] newArray = ArraysUtil.getInstance().reverse(array);
	}
}
/*
С�᣺���Ⱪ¶һ�������ľ�̬�������ڻ�ȡ����Ķ��󣬷���ֵΪ����
�ڸ�����,�Լ���������ʱ���������Ҫ��static���Σ���Ϊ���Ⱪ¶�ķ�����static���Σ�
����̬�������޷����÷Ǿ�̬�ı���
*/