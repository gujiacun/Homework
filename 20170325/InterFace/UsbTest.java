//���󣺱ȽϽӿںͳ����������
//����������
abstract class Aaa{
	//ʵ���������û�й��췽��
	Aaa(){
		System.out.println("���ǳ�����");
	}
}
//�����ӿ�,ָ��USB�淶
interface IUsb{
	//ʵ��ӿ���û�й��췽��,����֤��û��
	//IUsb(){
	//}
	//�����淶
	void swapData();
	//�����ӿ��е�����ڲ���
	class AAA{
		class aaa{
			//System.out.println("���ǽӿ��е��ڲ���");
		}
	}
}
//����ʵ���࣬��ʾ���
class Mouse implements IUsb{
	public void swapData(){
		System.out.println("�������������");
	}
}
//����ʵ���࣬��ʾ����
class Radio implements IUsb{
	public void swapData(){
		System.out.println("��������������");
	}
}
//����ʵ���࣬��ʾ����
class MotherBoard{
	//������������ʾ���豸���뵽������,������������
	public static void plugIn(IUsb usb){
		usb.swapData();
	}
}
//���������������,����̳г����࣬ʵ�ֽӿ�
class Son extends Aaa implements IUsb{
	Son(){
		System.out.println("���ǳ����������");
	}
	public void swapData(){
		System.out.println("������");
	}
}
//����������
public class UsbTest {
	//����������
	public static void main(String[] args) {
		//���Խ�����,����: Aaa,IUsb�ǳ����; �޷�ʵ����
		//Aaa a = new Aaa();
		//IUsb u = new IUsb();
		//��ʵ����Ķ���
		Radio r = new Radio();
		//����Son�Ĺ��췽����ʵ��ó�������Ҳ�й��췽��
		Son s = new Son();
		//����Mouse����,��ʵ����Ķ��󸳸��ӿڵı���������ʱ����ʵ����ķ���
		IUsb mice = new Mouse();
		//����MotherBoard����
		MotherBoard board = new MotherBoard();
		//ͨ��MotherBoard�������plugIn��������Mouse���󴫽�ȥ�����ֶ�̬
		board.plugIn(mice);
		//���ӿڴ��������ڲ�ʵ����
		new IUsb(){
			public void swapData(){
				System.out.println("fuck you");
			}
		};
	}
}
/*
С�᣺�ӿ��������ıȽϣ�����ʹ�ýӿڡ�������ֱ��ʵ���������ӿ�û���췽������������
һ������ֻ�ܼ̳�һ�����࣬��ʵ�ֶ���ӿ�
�ӿ��ֶ�Ĭ����public static final,����Ĭ��public abstract
*/