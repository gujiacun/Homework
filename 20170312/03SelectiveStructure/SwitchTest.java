//���󣺲���switch���
//�����࣬��SwitchTest
class SwitchTest {
	//����������
	public static void main(String[] args) {
		//switch֧���ж�string���ͣ��ȶ���һ��string�ı���
		String answer = "�ܲ���������һ��΢С�Ĺ���";
		//�����ڵ�һ�������ͱ��ʽ��Ҳ�����Ǳ���
		switch(answer){
			//case����еĿո��ð�ž��Բ�����
			case "excited":
				System.out.println("�����ͧ");
				break;
			//������ʽ��ֵ����case�����ĳ�������ִ�иô����
			case "����������֧��֧��":
				System.out.println("�Ҿ���ȷ�ظ�������һ�㣬��˵�ʴ�");
				break;
				//�����ʽ��ֵ�����ϵĳ����������ʱ��ִ�б��д���
			default:
				System.out.println("�����˻���Ҫ����Լ�������ˮƽ��ʶ����ʶ�ã�");
		}
	}
}
/*
С�᣺switch��䱾����ֻ֧��int���ͣ�������Ҳ֧��string���ͣ����һ���ص���Ƿǳ�������ʵ����֤���Լ����뷨�Ƿ���ȷ��
ͬʱҲҪ���ڳ����¶�����
*/