//�����˽�ӿڵĶ����ʽ���ӿڳ�Ա���ص�
//�����ӿ�
interface IWalkAble{
	//���Զ����ֶ�
	public int age = 10;
	//���Զ�����ͨ����������: �ӿڳ��󷽷����ܴ�������
	//void method(){
		//System.out.println("mememe");
	//}
	//public void method(){
		//System.out.println("mememe");
	//}
	//�������󷽷���û�����壬��������ʵ��
	void say();
}
//���Լ̳��࣬����: �˴���Ҫ�ӿڣ���Ϊ�ӿ��޷��̳��ֻ࣬�ܼ̳нӿ�
interface IWalkAble01 extends IWalkAble{

}
//�ӿ�ֻ�ܼ̳нӿڣ�֧�ֶ�̳�
interface IWalkAble02 extends IWalkAble,IWalkAble01{
	//�����޸��ֶ�,����: ��Ҫ<��ʶ��>,�ӿ��ж���ĳ�Ա����,ʵ����ȫ�־�̬����,Ĭ��ʹ��  public static final������
	//age = 20;
}
//������
class aaa{
}
//����ʵ����
class bbb implements IWalkAble{
	//��д�ӿڷ���,���ڽӿ��еķ���Ĭ��Ϊpublic abstract,�����з������η�Ҫ�ֶ�д��Ĭ��Ϊ������Ȩ��
	public void say(){
		System.out.println("excited!");
	}
}
//�����࣬��InterFaceTest
public class InterFaceTest {
	//����������
	public static void main(String[] args) {
		//�����ڽӿ��д�������,����: IWalkAble�ǳ����; �޷�ʵ��������Ϊ�ӿ�û�й�����
		//IWalkAble i = new IWalkAble();
		//����ӿڱ��,���ֶ�̬
		IWalkAble w = new bbb();
		w.say();

	}
}
/*
С�᣺�ӿ��ж���ķ���Ĭ���ǹ����ĳ��󷽷��������з�����.�����ֶ�д���η�
Ҫ�μǽӿڸ�����Ա���ص�
*/