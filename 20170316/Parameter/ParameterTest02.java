//�������������������£�����������ֵ���ݻ���
//���裺���������д���һ������Ϊ2�����飬��������ķ��������÷���������Ԫ��˳��ߵ�����ǰ�����ε��������
//����һ���࣬��ParameterTest02
class ParameterTest02 {
	//����������
	public static void main(String[] args) {
		//��������
		int[] array = {5,6};
		//������ͨ��Arrays���������toString������int����ת��ΪString���Ͳ����
		String ret = java.util.Arrays.toString(array);
		//��ʽΪjava.util.Arrays.toString(ʵ��)��java.��.��.����(ʵ��);
		System.out.println("����swap����ǰ�����飺" + ret);
		//����swap�������������ڵ�����.����(ʵ��);��ʱarray�����ѷ����ı�
		ParameterTest02.swap(array);
		//�����±��������Ѹı������ת��ΪString���Ͳ����
		String result = java.util.Arrays.toString(array);
		System.out.println("����swap����������飺" + result);
	}
	//�������ڰ�����Ԫ��˳��ߵ��ķ���
	static void swap(int[] arr){
		//�����±���temp��������ʱ�洢����
		int temp = arr[0];
		arr[0] = arr[1];
		arr[1] = temp;
	}
}
/*
С�᣺�����������ͣ�����������ʵ�ʲ���ʱ���Ȱ����õ�ַ����һ�ݣ��ٰѸ�������������
�����������뱻���õķ�����������ͬһ���ڴ�ռ䣬�����������б�����ֵ�ڱ����õķ����б��޸ģ��������б�����ֵҲ���޸ġ�
*/
