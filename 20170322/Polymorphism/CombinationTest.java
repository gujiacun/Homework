//����Ϊ������븴�����⣬���������м̳й�ϵ�����ü̳�;���������������Ϲ�ϵ
//������������ʵ����Ϲ�ϵ���ȴ��������࣬ʵ�������ܡ������������д������飬���������㷨
//�������򹤾���
class ArraysUtil{
	//�½�������ʵ�������ܣ�ֻ���������贴�������飬Ҳ���践��ֵ
	public void sort(int[] score){
		for (int i = 0; i < score.length - 1; i++) {
			int minIndex = i;
			//����������ѭ��������Ž���ֵ������jҪ��������ѭ����
			int j = i + 1;
			for (; j < score.length; j++) {
				if (score[minIndex] > score[j]) {
					minIndex = j;
				}
			}
			//��ѭ�������󣬰ѵõ�����Сֵ��������score[i]������һ����ѭ��ֻ�轻��һ�Ρ�
			int temp = score[minIndex];
			score[minIndex] = score[i];
			score[i] = temp;
		}
	}
}
//���������࣬CombinationTest
public class CombinationTest {
	//����������
	public static void main(String[] args) {
		//����������
		int[] array = {1,3,-6,65,21,0};
		//�������󣬵��ù������е����򷽷��������鴫��ȥ������
		ArraysUtil tool = new ArraysUtil();
		tool.sort(array);
		//��Arrays���е�toString������newArrayת��ΪString���Ͳ����
		System.out.println(java.util.Arrays.toString(array));
	}
}
/*
С�᣺��Ϲ�ϵ���ڲ�������ͨ������������Ķ��������ù��߷�������̳й�ϵ��ͬ�������޸Ĺ������ֶ�
*/