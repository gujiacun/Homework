//�������ģ�巽�����ģʽ
//�½������࣬�ṩһ�������ͨ�÷�������������ĳ��������������ʵʩ
abstract class Father{
	//���㷨�Ǽܣ��Ƚ�����
	public long getTime(){
		//��¼��ʼʱ��
		long startTime = System.currentTimeMills();
		//�������У��˴�������ͬ����ʵ��
		this.method();
		//��¼����ʱ��
		long endTime = System.currentTimeMills();
		//������ʱ��
		long totalTime = endTime - startTime;
		return totalTime;
	}
	//��abstract���Σ��޷����壬��������ʵ��
	abstract void method();
}
//��һ�����࣬String����10,000��
class Son01 extends Father{
	public void method(){
		for(int i = 0;i < 10000;i++){
			String str = i + "";
		}
	}
}
//��һ�����࣬����0��10,000����֮��
class Son02 extends Father{
	public void method(){
		for(int i = 0;i <= 10000;i++){
			long result = 0 + i;
		}
	}
}
//���࣬��TemplateMethodTest
public class TemplateMethodTest {
	//�½�������
	public static void main(String[] args) {
		Son02 s = new Son02();
		s.getTime();
		System.out.println("Hello World!");
	}
}
