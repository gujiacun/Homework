//����һ��С����3��ѧ�����ж�ѧ���Ƿ���ѧ�ѣ���û����ѧ��
//���裺�ȶ���һ���࣬���ѧ����״̬���������֣��Ƿ���ѧ�ѡ�
//����Ҫ�з�������ѧ��û�н�ѧ��ʱ������ø÷��������ж�������ж�
//�и�����ѧ����ִ�е���ͬһ��������ظ�������ѭ���ṹ
//�����1��000��ѧ������Ҫ���������е���1��000�Σ��������ѧ��������������
//�������ļ������ѧ�����ֶκͷ���
class Student{
	String name;
	//ֻ�н���ѧ����û��ѧ������״̬�������boolean������Ϊ�ֶε���������
	boolean isFee;
	//���巽������ѧ��û��ѧ��ʱ�ŵ���
	void fees(){
		isFee = true;
		System.out.println("��ѧ��δ��ѧ�ѣ����ѽ���");
	}
}
//�������ļ�
class StudentTest {
	//��������������������
	public static void main(String[] args) {
		//�ȴ�������ѧ�����󣬲�Ϊ���Ǹ�ֵ
		Student s1 = new Student();
		s1.name = "С��";
		s1.isFee = true;
		Student s2 = new Student();
		s2.name = "С��";
		s2.isFee = false;
		Student s3 = new Student();
		s3.name = "С��";
		s3.isFee = false;
		//�������飬��������������������飬�����������͵�����Ҳ������ϳ�����
		Student[] array = new Student[]{s1,s2,s3};
		//ʹ��forѭ��ִ���ظ�����
		for(int i = 0;i < array.length;i++){
			//�ж϶���������Ƿ�Ϊfalse���Ǿ͵��÷���
			if(!array[i].isFee){
				array[i].fees();
			}
		}
	}
}
/*
С�᣺Ҫ�μ�ÿ���﷨֪ʶ������ã�����������ʱҪѧ�������ת��Ϊ��Ӧ�Ĵ��롣
Ҫ�������еķ�static���ε��ֶλ򷽷���Ҫ��������Ķ����ٵ���
*/