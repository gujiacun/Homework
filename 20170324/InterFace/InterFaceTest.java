//�����˽�ӿڵĶ����ʽ���ӿڳ�Ա���ص�
//�����ӿ�
interface IWalkAble{
	//���Զ����ֶ�
	int age = 10;
	//���Զ�����ͨ����������: �ӿڳ��󷽷����ܴ�������
	void method(){
		System.out.println("mememe");
	}
}
//���Լ̳��࣬����: �˴���Ҫ�ӿ�
interface IWalkAble01 extends aaa{

}
//�ӿ�ֻ�ܼ̳нӿڣ�֧�ֶ�̳�
interface IWalkAble02 extends IWalkAble,IWalkAble01{
	//�����޸��ֶ�,����: ��Ҫ<��ʶ��>,�ӿ��ж���ĳ�Ա����,ʵ����ȫ�־�̬����,Ĭ��ʹ��  public static final������
	age = 20;
}
//������
class aaa{
}
//������
class InterFaceTest {
	//����������
	public static void main(String[] args) {
		//�����ڽӿ��д�������,����: IWalkAble�ǳ����; �޷�ʵ����
		//IWalkAble i = new IWalkAble();


	}
}
/*
С�᣺�ӿ��ж���ķ������ǹ����ĳ��󷽷��������з�����.
Ҫ�μǽӿڸ�����Ա���ص�
*/