//���󣺲���Object���еļ��ַ�������סʹ�ø�ʽ
//�����࣬��ObjectTest
class Test{
	int a = 10;
}
public class ObjectTest {
	//����������
	public static void main(String[] args) {
		//����Test��Ķ���
		Test t = new Test();
		//ʹ��equals�������ȴ�������String���ͱ���
		String str1 = "abc";
		String str2 = "abc";
		//�ڸ��ࣨObject���е�equals�����������"=="��ͬ�����ǱȽ϶�����ڴ��ַ��
		//����String���У�equals�����Ѿ���д��Object���е�equals�������Ѿ���Ϊ�Ƚ϶�������ݡ���ʽΪstr1.equals(str2)
		boolean whether = str1.equals(str2);
		//������
		System.out.println(whether);
		//����Ƚ�Arrays�е�toString������Object�е�toString����
		//������
		int[] arr = {1,2,30};
		//��toString������ת��ΪString���Ͳ����
		String array = java.util.Arrays.toString(arr);
		System.out.println(array);
		//��Object�е�toString������Ĭ������´�ӡ����,��ӡ���Ƕ����ʮ�����Ƶ�hashCodeֵ
		System.out.println(arr.toString());
		System.out.println(t.toString());
		//��hashCode�������������Ĺ�ϣֵ,hashCodeֵ�����˶����ڹ�ϣ���еĴ洢λ��
		System.out.println(t.hashCode());
		//����getClass�������õ��������ʵ���ͣ������Ǳ�������
		System.out.println(t.getClass());
	}
}
/*
С�᣺Obiect��ķ�����9�֣������ȼ�ס��õļ�����Ҫע�����������ͬ��������ʹ�ó�����ʹ�ø�ʽ�����֡�
*/