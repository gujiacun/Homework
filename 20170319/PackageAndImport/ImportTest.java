//���󣺲���import��䣬����Arrays�࣬��һ������ת����String���������Ȼ����������Ԫ�أ�����Ԫ��
//����Arrays����࣬��ʽΪ�� import ���ȫ�޶���;����ֻ�ܵ���һ����,Ҫ�ں����;
import java.util.Arrays;
//����һ�����ļ�����ImportTest
public class ImportTest {
	//����������
	public static void main(String[] args) {
		//��������
		int[] array = {52,63,0,-54,39,10,987};
		//��һ������ת��String�������
		String arr = Arrays.toString(array);
		System.out.println(arr);
		//����
		Arrays.sort(array);
		//��������array�������¸�ֵ��arr�����
		arr = Arrays.toString(array);
		System.out.println(arr);
		//����Ԫ��10
		int a = 0;
		//Ҫ�ö��������������ض���ֵ��ǰ���ǰ����鰴�մ�С�ź�˳��
		int index = Arrays.binarySearch(array,0);
		System.out.println(index);
		//����Ԫ��,�ڵ��÷���ʱҪע�ⰴ�����Ĳ����б���������,copyOf(int[] original, int newLength)
		//�ȶ�̬����һ�������飬�������մӾ����鿽��������Ԫ��
		int[] arr02 = new int[7];
		//����Ԫ�ص�������
		arr02 = Arrays.copyOf(array,7);
		//��������ת��ΪString���Ͳ����
		String arr03 = Arrays.toString(arr02);
		System.out.println(arr03);
	}
}
/*
С�᣺���뵼��ð��µ����е��ڵ�ǰ�ļ���ʹ�õ����࣬����ʽΪ��import java.util.*
*/