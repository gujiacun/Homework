//���󣺲���static import����ס�����ص㣬����������ķ���
//����һ���࣬��Staticimport
//����toString�޷�ͨ����̬���룬��������ͨ��import
import java.util.Arrays;
//��̬���룬��ʽΪimport ����.�Ӱ���.*;��ʾ����ð��µ����е��ڵ�ǰ�ļ���ʹ�õ�����
import static java.util.Arrays.*;
//����һ���࣬��Staticimport
public class Staticimport {
	//����������
	public static void main(String[] args) {
		//��������
		int[] array = new int[]{52,63,0,-54,39,10,987};
		//��һ������ת��String�������
		//����Object��Ҳ��һ��������toString���������Ĭ�ϴӸø������ҷ���������Arrays�е�toString�����þ�̬����
		String arr = Arrays.toString(array);
		System.out.println(arr);
		//�����������˾�̬���룬����Arrays�µķ����ܹ�ֱ���� ����(����);
		sort(array);
		arr = Arrays.toString(array);
		System.out.println(arr);
	}
}
/*
С�᣺��̬�����ڵײ�Ҳ��ͨ����ͨ����ʵ�ֵ�,����ڿ���������,����ֲ���ĳһ����̬�������ֶ���Դ����һ����.

*/