//���󣺴���һ������{3��12��69��10��25��8}�����ĵڶ������ĸ�Ԫ�ظ��Ƶ�����Ϊ8����������,�ӵ�����Ԫ�ؿ�ʼ����
//����һ���·���������Ϊ�Ӿ�������ȡ�������У�ճ�����������ָ��λ����
//����һ���࣬��ArrayCopy
class ArrayCopy {
	//����������
	public static void main(String[] args) {
		//��������
		int[] array = {3,12,69,10,25,8}; 
		//����һ���յ�������
		int[] newArray = new int[8];
		//����copy���������ݲ���ֵ��ע�����Ҫһһ��Ӧ
		ArrayCopy.copy(array,newArray,1,2,3);

	}
	//�����·���������Ҫ�Ӿ����鿽��Ԫ�ص������飬������Ҫ�¾���������ơ�
	//�Ӿ�������ĸ�����λ�ÿ�ʼ����������������ĸ�����λ�ÿ�ʼճ������Ҫ�����±�
	//���������еĳ��ȣ�ȷ�������Ľ���λ��
	static void copy(int[] array,int[] newArray,int srcPos,int destPos,int length){
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
}
/*
С�᣺���巽���Ĳ�����ò�����5����ҪѰ���ܼ��ٲ����ķ�����ͬʱҪ�࿼�ǳ�����ԵĶ���������ó����ǿ׳
*/