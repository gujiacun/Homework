//���󣺷��Ͷ��Ź��ܵ����
//���裺���Ͷ�����һ�����ܣ������ɴ��뼯�϶��ɣ�����Ӧ����һ��������
//����һ��������
//���ڷ��Ͷ����ж���״̬����int����������ֵ���͡�
//����һ���࣬��MethodTest01
class MethodTest01 {
	//����������
	public static void main(String[] args) {
		//�����·���Message�����������������ݣ�ͬʱ�����±������մӷ����з��ص�ֵ
		int result = MethodTest01.Message("10086","How many brothers feel victim to the street?");
		System.out.println(result);
		//�����з���ֵ�ķ���ʱ��Ҫ�ڵ����ߴ��¶���һ�����������շ���ֵ��������������Ӧ����һ��
		boolean login = MethodTest01.login("������","10010");
		System.out.println(login);
	}
	//���巢�Ͷ��ŵķ���
	//�û������뷢�͵绰��long�������ݣ�String����������Ҫ������ʽ����
	//����Ҫ���û����ر�ʾ״̬��������Ҫ�з���ֵ
	/*
	0:��Ӫ���Ѿ�����
	1:�����ѽ���
	2:�����·���
	*/
	static int Message(String number, String essay){
		String str1 = "10086";
		String str2 = "10010";
		//��equals�����ȽϷ������ܵ�number������ֵ����Ϊ10086������0����Ϊ10010������1�����򷵻�2
		if(str1.equals(number)){
			return 0;
		}else if(str2.equals(number)){
			return 1;
		}else{
			return 2;
		}
	}
	//������Ƶ�¼����
	//ֻ������״̬����½�ɹ���ʧ�ܣ�������boolean������Ϊ�����ķ���ֵ����
	//���������˺ź����룬������������ʽ����
	static boolean login(String name,String password){
		String names = "������";
		String passwords = "10010";
		//��equals�����Ͷ�·�������ж��û�������û����������Ƿ���������洢����ͬ
		if(names.equals(name) && passwords.equals(password)){
			//��ͬ�򷵻�true
			return true;
		}else{
			//���򷵻�false
			return false;
		}
	}
}
/*
С�᣺�ڷ����ڲ�,ʹ��return�ؼ��֣���Ҫ����������
1.�������߷���һ�����ֵ.
2.������ǰ����.��һ����return��ѭ������е�������һ����

*/