//���󣺶���Ͷ�����в�����������߹�ϵ����ס���߻�������
//�������ļ�������Ӷ�ˣ�����״̬���ֶΣ�����Ϊ��������,��������ĸ��д
class Servants{
	//Ӷ�˵��Ա�
	char sex ='m';
	//����
	int age = 36;
	//����
	String name;
	//�����ܶ����飬����ˣ���������࣬�÷���������
	void buy(){
		System.out.println("Ӷ��ȥ�����");
	}
	//ע�⣬�˴��ķ������ܱ�static���Σ���Ϊ����ķ������ֶ����ڸ����������Ķ���
	void cook(){
		System.out.println("Ӷ��ȥ������");
	}
	void clean(){
		System.out.println("Ӷ��ȥ�������");
	}
}
//�������ļ�����ServantTest
class ServantTest 
{
	//����������
	public static void main(String[] args) 
	{
		//�����������������class Servants��ķ��������ȰѸ���ʵ������ͨ��ʵ�������÷���
		//���󴴽���ʽ������ ������ = new ����();
		Servants serve = new Servants();
		//ͨ���������clean����
		serve.clean();
		//��ȡ�����״̬��ͨ����������ֶ�
		char sex = serve.sex;
		System.out.println(sex);
		//�޸Ķ�������Ե�ֵ,�����
		serve.age = 32;
		System.out.println(serve.age);
		//����Ĵ�ӡ����,��ֱ�Ӵ�ӡ������������@16���Ƶ�hashcode
		System.out.println(serve);
		//����ıȽϲ���
		Servants serve2 = new Servants();
		serve2.age = 55;
		Servants serve3 = new Servants();
		serve3.age = 66;
		//"=="���߶��ǻ�����������ʱ���Ƚ���ֵ����Ӧ����������ʱ���Ƚϵ����������ڴ��е����õ�ַ
		System.out.println(serve == serve2);
		System.out.println(serve2 == serve3);
		//���д����ʾ��serve2�����ĵ�ַ��ֵ��serve��serve��Ӧ�õ�ַ��serve2һ��
		serve = serve2;
		System.out.println(serve);
		System.out.println(serve2);
		//��serve3�����õ�ַ��ա���ʱserve3û��ָ����ַ
		serve3 = null;
		//������������,��ʽΪnew ����();
		new Servants().clean();
	}
}
/*
С�᣺�μ��½�����ĸ�ʽ��ͬʱ��������Ĵ�����ʽΪ�½������ʽ�ĺ�һ�룬����Ҫ���ù��������������ں���Ҫ��().
*/