//���󣺲����ڻ������������£�����������ֵ���ݻ���.
//���裺�����������½�һ��int������������һ����������������������¸�ֵ�����ֱ�����ñ����ڵ��÷���ǰ�����÷���ʱ�����÷������ֵ
//����һ���࣬��ParameterTest01
class ParameterTest01 {
	//����������
	public static void main(String[] args) {
		//������������int����
		int num = 36;
		//�������change����ǰnum��ֵ
		System.out.println("��main�����ճ�ʼ��ʱ��num = " + num);
		//����change����
		ParameterTest01.change(num);
		//�������change������num��ֵ
		System.out.println("��main���������change������num = " + num);
	}
	//����change����
	static void change(int number){
		//���num�ձ�����change��������δִ���������ʱ���ֵ
		System.out.println("����change����ǰ��num = " + number);
		//��number�������¸�ֵ
		number = 63;
		//���ִ�����������ֵ
		System.out.println("����change������num = " + number);
	}
}
/*
С�᣺Ϊʲô����������ĸ����أ� main������change�����ֱ��ڲ�ͬ��ջ֡�main������ջ�ף�change������ջ����
������ִ��change(number);ʱ��������change��������main�����������num��ֵ��36������һ�ݣ��ٴ��ݸ�change�������number���������ݵĽ�����36��������ĸ�����
����change�����number����һ��ʼ����36�������������¸�ֵ��Ϊ63��
��ʱchange������������ϣ�λ��ջ���������ȳ�ջ��Ȼ��main�������ڼ���ջ��������ջ�ס�
�ص���������������ջ֡�num������ֵ��δ�ı䣬��ȻΪ36.������ջ���治��Ҫ�������գ���Ϊ����������١�
ע�⣺Ҫ�������ı�num��ֵ��Ҫ��change�����ﶨ��һ������ֵ��return��ͬʱ���������ﶨ���±������ܷ��ؽ��
*/