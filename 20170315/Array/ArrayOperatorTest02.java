//���󣺲�����������㷨
//����һ���࣬��ArrayOperatorTest02
class ArrayOperatorTest02 {
	//����������
	public static void main(String[] args) {
		//�ȶ���һ������
		int[] arrayForTest = {96,36,58,12,106,3};
		//��ȡ���������Ԫ��
		//���裺ͨ������һ���������������һ�����һ��Ԫ�ش洢��ȥ���ٰ���������ʣ�µ�������һ���Ƚϡ�
		//�����������ֱ����󣬱�ѽϴ�ֵ���¸�����Ǹ�������ֱ���Ƚ������һ��Ԫ��
		int maxNumber = arrayForTest[0];
		//��forѭ����������������Ԫ��
		for(int i = 0;i < arrayForTest.length;i++){
			//��if��䣬���ڱ��������з��������ֱ�maxNumber�󣬰ѽϴ����ָ���maxNumber
			if(maxNumber < arrayForTest[i]){
				maxNumber = arrayForTest[i];
			}
		}
		System.out.println(maxNumber);
		//��ȡ��������СԪ��
		//���裺ͨ������һ���������������һ�����һ��Ԫ�ش洢��ȥ���ٰ���������ʣ�µ�������һ���Ƚϡ�
		//�����������ֱ���С����ѽ�Сֵ���¸�����Ǹ�������ֱ���Ƚ������һ��Ԫ��
		int minNumber = arrayForTest[0];
		//��forѭ����������������Ԫ��
		for(int i = 0;i < arrayForTest.length;i++){
			//��if��䣬���ڱ��������з��������ֱ�minNumberС���ѽ�С���ָ���minNumber
			if(minNumber > arrayForTest[i]){
				minNumber = arrayForTest[i];
			}
		}
		System.out.println(minNumber);

		//��ӡ����Ԫ��,���Ч��Ϊ{96,36,58,12,106,3}
		//���裺1.�����Ч�����Ϊ�����֣����ֲ��֣����Ų��ֺ�����������
		//2.���ֲ���Ҫ��forѭ�����������
		//3.������Ҫ��forѭ����ʼǰ�ͽ�����ͨ��Stringƴ��
		//4.����Ҫ��ÿһ�����������ͨ��Stringƴ�ӣ���������һ������ʱ���üӶ���
		String result = "{";
		for(int i = 0;i < arrayForTest.length;i++){
			result += arrayForTest[i];
			if(i < arrayForTest.length - 1){
				result += ",";
			}
		}
		result += "}";
		System.out.println(result);
		//�����¶�����շ������ص���������֮���������
		int[] newArray = ArrayOperatorTest02.reverse(arrayForTest);
		//ʹ��forѭ���������������Ԫ��
		for(int i = 0;i < newArray.length;i++){
			System.out.println(newArray[i]);
		}
	}
		//������������Ԫ��
		//���裺1.����һ���·���������������ʱ��δ֪�������������ƣ����룬��ʽ������һ��������Ϊ����
		//2.������������Ԫ�غ󣬻����һ�������飬����ֵ����ҲΪ����
		//3.�������Ԫ����ʱ��֪������������Ԫ��˳��ͬ�������鳤����ͬ���ö�̬��ʼ������������
	static int[] reverse(int[] arrayForTest){
		//�������������У�������Ԫ��[0] = ������Ԫ��[��.length - 1],������Ԫ��[1] = ������Ԫ��[��.length - 2],���������Ϊ��.length - 1
		int[] newArray = new int[arrayForTest.length];
		for(int i = 0;i < arrayForTest.length;i++){
			newArray[i] = arrayForTest[arrayForTest.length - 1 - i];
		}
		return newArray;
	}
}
/*
С�᣺�ڴ�ӡ��������Ԫ��ʱ��Ҫѧ��Ѳ�ͬԪ�ز�ֲַ�ͬ���֣���������ʲôʱ��ó��֡�
����Ԫ��ͨ����ѭ������ӡ��ֱ�Ӵ�ӡ����ֻ����������hasgcode
*/