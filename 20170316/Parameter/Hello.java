//����������������main������String���鴫�ݲ���
//����һ���࣬��Hello
class Hello {
	//���������������ڱ�static���Σ����Կ��Ե��ã���ʽΪHello.main(ʵ��);
	public static void main(String[] args) {
		System.out.println("Hello World!");
		//�����hashcode��֤�����ݽ�����String���͵�����
		System.out.println(args);
		//�������鳤��Ϊ0����Ϊ������
		System.out.println(args.length);
		//���ǿ������������и�main�������ݲ���������forѭ���Ѵ��ݽ����������ӡ����
		for(int i = 0;i < args.length;i++){
			System.out.println(args[i]);
		}
		//��������������A B C D E�󣬳ɹ���ӡ�������������鳤��Ҳ��Ϊ5����hashcodeû�иı�
	}
}
/*
С�᣺�Ҷ������еĲ��������Ǻ���Ϥ����˵linux����Ҫ�õ������У�Ҫ��ס�����������в���
��main�������ݲ������Ҳ�����ա�
*/