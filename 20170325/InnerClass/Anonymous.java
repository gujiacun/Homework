//�������������ڲ������ָ�ʽ
//����һ���ӿ�
interface IWalkAble{
	//д���󷽷�
	void say();
}

//����һ����
class Father{
	public void say(){
		System.out.println("���ǰְ�");
		//����һ�������ڲ���̳и���,����û�й�����,���ǻ���ø��๹����
		new Father() {
			public void say(){
			System.out.println("���ǰְֵ��ڲ���");
			}
		//�ֺž��Բ���ʡ��
		};
	}
}

public class Anonymous {
	public static void main(String[] args) {
		//����һ�������ڲ���ʵ�ֽӿڣ�һ��Ҫ��д�ӿ��еĳ��󷽷�
		new IWalkAble(){
			public void say(){
				System.out.println("excited!");
			}
		//�ֺž��Բ���ʡ��
		};
		//
	}
}
/*
С�᣺�����ڲ�����붨����ĳ�����������棬���һ���ĳ��������
��Ϊ�����ڲ���ֻ�Ǿֲ��ڲ����һ���������
*/