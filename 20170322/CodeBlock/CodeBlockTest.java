//���󣺲�������鲻ͬ���������ס���ص�
//���������࣬CodeBlockTest
//����һ���࣬������ʼ�������(��������)
class CodeBlock{
	{
		System.out.println("���ǳ�ʼ�������");
	}
	//������̬����飬���Կ�������ִ��˳��ȹ��췽������
	static{
		System.out.println("���Ǿ�̬�����");
	}
}
public class CodeBlockTest {
	//����������
	public static void main(String[] args) {
		System.out.println("���������������");
		//��������,���Կ������еĳ�ʼ������鱻�������Ϊ�����������Ž����췽���ĵ�һ��
		CodeBlock c = new CodeBlock();
		//����method����
		CodeBlockTest.method();
		
	}
	//����һ���·����������ֲ������,�������˳��
	public static void method(){
		//�����ֲ������
		{
			System.out.println("������method�����е�ǰ��Ĵ����");
		}
		System.out.println("������method�����е�С͸��");
		{
			System.out.println("������method�����еĺ���Ĵ����");
		}
	}
}
/*
С�᣺��̬��Ա�����ֽ���ļ���Ҳ���ؽ�JVM,��ʱ���췽����ûִ��,��Ϊ������ҪJVM����
*/